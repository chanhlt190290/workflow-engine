/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.service.impl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
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
    public List<Transition> findByCurrentStateId(int stateId) {
        TypedQuery query = em.createQuery("select t from Transition t where t.id = ?1", Transition.class);
        query.setParameter(1, stateId);
        List<Transition> transitions = query.getResultList();
        return transitions;
    }

}
