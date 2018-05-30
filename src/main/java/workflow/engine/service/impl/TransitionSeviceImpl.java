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
import workflow.engine.model.State;
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
    public List<Transition> findByState(State state) {
        TypedQuery<Transition> query = em.createQuery("select t from Transition t where t.currentState = ?1", Transition.class);
        query.setParameter(1, state);
        List<Transition> transitions = query.getResultList();
        return transitions;
    }

    @Override
    public void loadTransitions(Request req) {
        List<Transition> transitions = findByState(req.getState());
        for (Transition transition : transitions) {
            Set<Action> actions = transition.getActions();
            for (Action action : actions) {
                RequestAction reqAction = new RequestAction();
                reqAction.setAction(action.getId());
                reqAction.setRequest(req);
                reqAction.setTransition(transition);
                em.persist(reqAction);
            }
        }
    }

    @Override
    public void disableTransitions(Request req) {
        List<Transition> transitions = findByState(req.getState());
        for (Transition transition : transitions) {
            Set<Action> actions = transition.getActions();
            for (Action action : actions) {
                TypedQuery<RequestAction> query
                        = em.createQuery("select ra from RequestAction ra where ra.actionId = ?1 and ra.request = ?2 and ra.transition = ?3",
                                RequestAction.class);
                query.setParameter(1, action.getId());
                query.setParameter(2, req);
                query.setParameter(3, transition);

                List<RequestAction> ras = query.getResultList();
                if (!ras.isEmpty()) {
                    for (RequestAction ra : ras) {
                        ra.setIsActive(Boolean.FALSE);
                        em.flush();
                    }
                }
            }
        }
    }

}
