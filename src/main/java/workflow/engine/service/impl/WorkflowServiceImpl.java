/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.service.impl;

import java.util.List;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import workflow.engine.exception.ResourceNotFoundException;
import workflow.engine.model.Action;
import workflow.engine.model.Request;
import workflow.engine.model.RequestAction;
import workflow.engine.model.Transition;
import workflow.engine.service.WorkflowService;

/**
 *
 * @author trungchanh
 */
@Service
@Transactional
public class WorkflowServiceImpl implements WorkflowService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Request makeRequest(Request request) {
        em.persist(request);
        loadNewActions(request);
        return request;
    }

    @Override
    public RequestAction doRequestAction(int actionId, int userId) {
        RequestAction action = em.find(RequestAction.class, actionId);
        if (action.getIsComplete() || action.getIsActive() == false) {
            throw new ResourceNotFoundException("action", "id", actionId);
        }

        completeAction(action, userId);

        boolean transitionCompleted = checkTransitionCompleted(action);

        if (transitionCompleted) {
            transitRequest(action);
        }
        return action;

    }

    private List<RequestAction> getAvailableActions(Integer transitionId, Integer requestId) {
        TypedQuery<RequestAction> query = em.createQuery("select ra from RequestAction ra where ra.transitionId = ?1 and ra.requestId = ?2 and ra.isActive = true", RequestAction.class);
        query.setParameter(1, transitionId);
        query.setParameter(2, requestId);
        List<RequestAction> ras = query.getResultList();
        return ras;
    }

    private List<Transition> findByState(Integer stateId) {
        TypedQuery<Transition> query = em.createQuery("select t from Transition t where t.currentStateId = :stateId", Transition.class);
        query.setParameter("stateId", stateId);
        List<Transition> transitions = query.getResultList();
        return transitions;
    }

    private void loadNewActions(Request req) {
        List<Transition> transitions = findByState(req.getStateId());
        transitions.forEach((transition) -> {
            Set<Action> actions = transition.getActions();
            actions.stream().map((action) -> {
                RequestAction ra = new RequestAction();
                ra.setActionId(action.getId());
                ra.setRequestId(req.getId());
                ra.setTransitionId(transition.getId());
                return ra;
            }).forEachOrdered((ra) -> {
                em.persist(ra);
            });
        });
    }

    private void disableCurrentActions(Request req) {
        List<Transition> transitions = findByState(req.getStateId());
        transitions.stream().map((transition) -> {
            TypedQuery<RequestAction> query
                    = em.createQuery("select ra from RequestAction ra where ra.requestId = :requestId and ra.transitionId = :transitionId",
                            RequestAction.class);
            query.setParameter("requestId", req.getId());
            query.setParameter("transitionId", transition.getId());
            return query;
        }).map((query) -> query.getResultList()).filter((ras) -> (!ras.isEmpty())).forEachOrdered((List<RequestAction> ras) -> {
            ras.stream().map((RequestAction ra) -> {
                ra.setIsActive(Boolean.FALSE);
                return ra;
            }).forEachOrdered((RequestAction ra) -> {
                em.flush();
            });
        });
    }

    private void transitRequest(RequestAction action) {
        Request request = em.find(Request.class, action.getRequestId());
        disableCurrentActions(request);
        Transition transition = em.find(Transition.class, action.getTransitionId());
        request.setStateId(transition.getNextStateId());
        em.persist(request);
        loadNewActions(request);
    }

    private void completeAction(RequestAction action, int userId) {
        action.setCompletedBy(userId);
        action.setIsActive(false);
        action.setIsComplete(true);
        em.persist(action);
        em.flush();
    }

    private boolean checkTransitionCompleted(RequestAction action) {
        List<RequestAction> remainActions = getAvailableActions(action.getTransitionId(), action.getRequestId());
        return remainActions.isEmpty();
    }
}