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
    public List<Transition> findByCurrentStateId(State state) {
        System.out.println("stateId = " + state.getId());
        TypedQuery query = em.createQuery("select t from Transition t where t.currentState = ?1", Transition.class);
        query.setParameter(1, state);
        List<Transition> transitions = query.getResultList();
        return transitions;
    }

    @Override
    public void loadTransitions(Request req) {
        List<Transition> transitions = findByCurrentStateId(req.getState());
        for (Transition transition : transitions) {
            Set<Action> actions = transition.getActions();

            for (Action action : actions) {
                RequestAction reqAction = new RequestAction();
                reqAction.setAction(action.getId());
                reqAction.setRequest(req);
                reqAction.setTransition(transition);

//                TypedQuery<RequestAction> query = em.createQuery("select ra from RequestAction ra where ra.actionId = ?1 and ra.request = ?2 and ra.transition = ?3", RequestAction.class);
//                query.setParameter(1, reqAction.getAction());
//                query.setParameter(2, reqAction.getRequest());
//                query.setParameter(3, reqAction.getTransition());
//
//                List<RequestAction> ras = query.getResultList();
//                if (!ras.isEmpty()) {
//                    for (RequestAction ra : ras) {
//                        ra.setIsActive(Boolean.TRUE);
//                        ra.setIsComplete(Boolean.FALSE);
//                        em.merge(ra);
//                        em.flush();
//                    }
//                } else {
                    em.persist(reqAction);
                    em.flush();
//                }

            }
        }
    }

    @Override
    public void disableTransitions(Request req) {
        List<Transition> transitions = findByCurrentStateId(req.getState());
        for (Transition transition : transitions) {
            Set<Action> actions = transition.getActions();
            for (Action action : actions) {
                RequestAction reqAction = new RequestAction();
                reqAction.setAction(action.getId());
                reqAction.setRequest(req);
                reqAction.setTransition(transition);

                TypedQuery<RequestAction> query = em.createQuery("select ra from RequestAction ra where ra.actionId = ?1 and ra.request = ?2 and ra.transition = ?3", RequestAction.class);
                query.setParameter(1, reqAction.getAction());
                query.setParameter(2, reqAction.getRequest());
                query.setParameter(3, reqAction.getTransition());

                List<RequestAction> ras = query.getResultList();
                if (!ras.isEmpty()) {
                    for (RequestAction ra : ras) {
                        ra.setIsActive(Boolean.FALSE);
                        em.merge(ra);
                        em.flush();
                    }
                }
            }
        }
    }

}
