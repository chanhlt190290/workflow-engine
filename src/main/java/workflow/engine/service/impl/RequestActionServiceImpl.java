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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workflow.engine.model.Request;
import workflow.engine.model.RequestAction;
import workflow.engine.model.Transition;
import workflow.engine.service.RequestActionService;
import workflow.engine.service.TransitionService;

/**
 *
 * @author trungchanh
 */
@Service
@Transactional
public class RequestActionServiceImpl implements RequestActionService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    TransitionService transitionService;

    @Override
    public RequestAction getRequestAction(int id) {
        TypedQuery<RequestAction> query = em.createQuery("select r from RequestAction r where r.id = ?1", RequestAction.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    @Override
    public RequestAction update(RequestAction requestAction) {
        em.persist(requestAction);
        em.flush();
        return requestAction;
    }

    @Override
    public boolean checkTransitionComplete(int requestId, int transitionId) {
        TypedQuery query = em.createQuery("select count(ra) from RequestAction ra where ra.request = ?1 and ra.transition = ?2 and ra.isActive = true and ra.isComplete = false", Integer.class);
        query.setParameter(1, requestId);
        query.setParameter(2, transitionId);
        Integer count = query.getFirstResult();
        return count == 0;
    }

    @Override
    public RequestAction performAction(int id) {
        TypedQuery<RequestAction> query = em.createQuery("select r from RequestAction r where r.id = ?1", RequestAction.class);
        query.setParameter(1, id);
        RequestAction requestAction = query.getSingleResult();

        if (requestAction.getIsComplete() || requestAction.getIsActive() == false) {
            return requestAction;
        }
        requestAction.setCompletedBy(1);
        requestAction.setIsActive(false);
        requestAction.setIsComplete(true);
        em.persist(requestAction);
        em.flush();

        List<RequestAction> requestActions = findByTransitionId(requestAction.getTransition(), requestAction.getRequest());

        boolean isComplete = true;
        for (RequestAction ra : requestActions) {
            if (!ra.getIsComplete()) {
                isComplete = false;
                break;
            }
        }
        if (isComplete) {
            Request request = requestAction.getRequest();
            transitionService.disableTransitions(request);
            Transition transition = requestAction.getTransition();
            request.setState(transition.getNextState());
            em.persist(request);
            em.flush();
            transitionService.loadTransitions(request);
        }
        return requestAction;
    }

    private List<RequestAction> findByTransitionId(Transition transition, Request request) {
        TypedQuery query = em.createQuery("select ra from RequestAction ra where ra.transition = ?1 and ra.request = ?2 and ra.isActive = true and ra.isComplete = false", RequestAction.class);
        query.setParameter(1, transition);
        query.setParameter(2, request);
        List<RequestAction> ras = query.getResultList();
        return ras;
    }

}
