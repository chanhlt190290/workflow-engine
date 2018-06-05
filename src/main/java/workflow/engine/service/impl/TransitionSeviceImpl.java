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
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import workflow.engine.model.Action;
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
    public Transition create(Transition transition) {
        em.persist(transition);
        return transition;
    }

    @Override
    public Transition addActions(int transitionId, List<Integer> actionIds) {
        Transition transition = em.find(Transition.class, transitionId);
        for (Integer actionId : actionIds) {
            Action action = em.find(Action.class, actionId);
            transition.getActions().add(action);
        }
        em.flush();
        return transition;
    }

}
