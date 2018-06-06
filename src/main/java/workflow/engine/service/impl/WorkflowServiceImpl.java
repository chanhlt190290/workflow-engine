/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.service.impl;

import java.util.Date;
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
import workflow.engine.model.State;
import workflow.engine.model.Transition;
import workflow.engine.service.WorkflowService;
import workflow.engine.utils.Constants.StateType;

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
        State startState = getStartState(request.getProcessId());
        request.setStateId(startState.getId());
        request.setUpdatedBy(request.getCreatedBy());
        em.persist(request);
        em.flush();
        loadNewActions(request);
        applyRequest(request);
        request.setAvailableActions(getAvailableActions(request.getId()));
        return request;
    }

    @Override
    public Request doRequestAction(int requestId, int actionId, int userId) {
        RequestAction action = em.find(RequestAction.class, actionId);
        if (action == null || action.getIsComplete() || action.getIsActive() == false) {
            throw new ResourceNotFoundException("action", "id", actionId);
        }
        Request request = em.find(Request.class, requestId);
        if (request == null) {
            throw new ResourceNotFoundException("request", "id", requestId);
        }
        completeAction(action, userId);
        boolean transitionCompleted = checkTransitionCompleted(action);
        if (transitionCompleted) {
            transitRequest(request, action);
        }

        return request;

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
                ra.setAction(action);
                ra.setRequestId(req.getId());
                ra.setTransitionId(transition.getId());
                return ra;
            }).forEachOrdered((ra) -> {
                em.persist(ra);
                em.flush();
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

    private void transitRequest(Request request, RequestAction action) {
        disableCurrentActions(request);
        Transition transition = em.find(Transition.class, action.getTransitionId());
        State state = em.find(State.class, transition.getNextStateId());
        request.setStateId(state.getId());
        request.setState(state);
        request.setUpdatedBy(action.getCompletedBy());
        em.flush();
        loadNewActions(request);

        request.setAvailableActions(getAvailableActions(request.getId()));
        request.setActivities(state.getActivities());
        request.getActivities().addAll(transition.getActivities());
    }

    private void completeAction(RequestAction action, int userId) {
        action.setCompletedBy(userId);
        action.setIsActive(false);
        action.setIsComplete(true);
        action.setCompletedAt(new Date());
        em.flush();
    }

    private boolean checkTransitionCompleted(RequestAction action) {
        List<RequestAction> remainActions = getRemainActions(action.getRequestId(), action.getTransitionId());
        return remainActions.isEmpty();
    }

    @Override
    public Request getRequest(int requestId) {
        Request request = em.find(Request.class, requestId);
        request.setAvailableActions(getAvailableActions(request.getId()));
        return request;
    }

    private List<RequestAction> getAvailableActions(int requestId) {
        TypedQuery<RequestAction> query = em.createQuery("select ra from RequestAction ra where ra.requestId = :requestId and ra.isActive = true", RequestAction.class);
        query.setParameter("requestId", requestId);
        return query.getResultList();
    }

    private State getStartState(Integer processId) {
        TypedQuery<State> query = em.createQuery("select s from State s where s.processId = :processId and s.stateTypeId = :stateTypeId", State.class);
        query.setParameter("processId", processId);
        query.setParameter("stateTypeId", StateType.START.getValue());
        return query.getSingleResult();
    }

    private List<RequestAction> getRemainActions(Integer requestId, Integer transitionId) {
        TypedQuery<RequestAction> query = em.createQuery("select ra from RequestAction ra where ra.requestId = :requestId and ra.transitionId = :transitionId and ra.isActive = true", RequestAction.class);
        query.setParameter("requestId", requestId);
        query.setParameter("transitionId", transitionId);
        return query.getResultList();
    }

    private void applyRequest(Request request) {
        List<RequestAction> availableActions = getAvailableActions(request.getId());
        availableActions.forEach((ra) -> {
            doRequestAction(request.getId(), ra.getId(), request.getCreatedBy());
        });
    }

}
