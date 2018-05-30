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
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workflow.engine.model.Action;
import workflow.engine.model.Request;
import workflow.engine.model.RequestAction;
import workflow.engine.model.State;
import workflow.engine.model.Transition;
import workflow.engine.repository.ActionRepository;
import workflow.engine.repository.RequestActionRepository;
import workflow.engine.repository.RequestRepository;
import workflow.engine.repository.TransitionRepository;
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
    ActionRepository actionRepo;

    @Autowired
    RequestRepository requestRepo;
    @Autowired
    TransitionService transitionService;
    
    @Autowired
    RequestActionRepository requestActionRepo;

    @Override
    public Request create(Request req) {
        req = requestRepo.save(req);
        
        List<Transition> transitions = transitionService.findByCurrentStateId(req.getState().getId());
        for(Transition transition: transitions){
            Set<Action> actions = transition.getActions();
            for(Action action: actions){
                RequestAction reqAction = new RequestAction();
                reqAction.setAction(action.getId());
                reqAction.setRequest(req.getId());
                reqAction.setTransition(transition.getId());
                requestActionRepo.save(reqAction);
            }
        }
        return req;
    }

//    @Autowired
//    RequestMapper requestMapper;
//    @Override
//    public Request01 getRequest(int id) {
//        return requestMapper.getRequest(id);
//    }
//
//    @Override
//    public List<Request01> getRequests() {
//        return requestMapper.getRequests();
//    }

    @Override
    public Request getById(int id) {
        Request one = requestRepo.getOne(id);
        State state = one.getState();
        System.out.println(state.getName());
        return one;
    }
}
