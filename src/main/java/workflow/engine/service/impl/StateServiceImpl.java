/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import workflow.engine.model.State;
import workflow.engine.service.StateService;

/**
 *
 * @author trungchanh
 */
@Service
@Transactional
public class StateServiceImpl implements StateService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public State create(State state) {
        em.persist(state);
        return state;
    }

}
