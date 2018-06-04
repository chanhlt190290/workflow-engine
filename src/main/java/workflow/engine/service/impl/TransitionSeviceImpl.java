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
import workflow.engine.model.Action;
import workflow.engine.model.Request;
import workflow.engine.model.RequestAction;
import workflow.engine.model.Transition;
import workflow.engine.service.TransitionService;

/**
 *
 * @author trungchanh
 */
@Service
@Transactional
public class TransitionSeviceImpl implements TransitionService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Transition> findByState(Integer stateId) {
        TypedQuery<Transition> query = em.createQuery("select t from Transition t where t.currentStateId = ?1", Transition.class);
        query.setParameter(1, stateId);
        List<Transition> transitions = query.getResultList();
        return transitions;
    }

    @Override
    public void loadTransitions(Request req) {
        List<Transition> transitions = findByState(req.getStateId());
        transitions.forEach((transition) -> {
            Set<Action> actions = transition.getActions();
            actions.stream().map((action) -> {
                RequestAction reqAction = new RequestAction();
                reqAction.setAction(action.getId());
                return reqAction;
            }).map((reqAction) -> {
                reqAction.setRequestId(req.getId());
                return reqAction;
            }).map((reqAction) -> {
                reqAction.setTransitionId(transition.getId());
                return reqAction;
            }).forEachOrdered((reqAction) -> {
                em.persist(reqAction);
            });
        });
    }

    @Override
    public void disableTransitions(Request req) {
        List<Transition> transitions = findByState(req.getStateId());
        transitions.stream().map((transition) -> {
            TypedQuery<RequestAction> query
                    = em.createQuery("select ra from RequestAction ra where ra.requestId = ?1 and ra.transitionId = ?2",
                            RequestAction.class);
            query.setParameter(1, req.getId());
            query.setParameter(2, transition.getId());
            return query;
        }).map((query) -> query.getResultList()).filter((ras) -> (!ras.isEmpty())).forEachOrdered((ras) -> {
            ras.stream().map((ra) -> {
                ra.setIsActive(Boolean.FALSE);
                return ra;
            }).forEachOrdered((_item) -> {
                em.flush();
            });
        });
    }

}
