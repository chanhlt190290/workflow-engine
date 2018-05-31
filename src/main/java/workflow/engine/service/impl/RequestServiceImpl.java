/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workflow.engine.model.Request;
import workflow.engine.model.State;
import workflow.engine.service.RequestService;
import workflow.engine.service.TransitionService;

/**
 *
 * @author trungchanh
 */
@Service
@Transactional
public class RequestServiceImpl implements RequestService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    TransitionService transitionService;

    @Override
    public Request create(Request req) {
        em.persist(req);
        transitionService.loadTransitions(req);
        return req;
    }

    @Override
    public Request getById(int id) {
        return em.find(Request.class, id);
    }


    @Override
    public Request create(Request req, Integer stateId) {
        State state = new State();
        state.setId(stateId);
        req.setState(state);
        em.persist(req);
        transitionService.loadTransitions(req);
        return req;
    }
}
