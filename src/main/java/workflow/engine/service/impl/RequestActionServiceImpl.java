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
    public RequestAction get(int id) {
        return em.find(RequestAction.class, id);
    }

    @Override
    public RequestAction perform(int id) {
        RequestAction requestAction = get(id);
        if (requestAction.getIsComplete() || requestAction.getIsActive() == false) {
            return requestAction;
        }
        requestAction.setCompletedBy(1);
        requestAction.setIsActive(false);
        requestAction.setIsComplete(true);
        em.persist(requestAction);
        em.flush();

        List<RequestAction> requestActions = findByTransition(requestAction.getTransitionId(), requestAction.getRequestId());

        boolean isComplete = true;
        for (RequestAction ra : requestActions) {
            if (!ra.getIsComplete()) {
                isComplete = false;
                break;
            }
        }
        if (isComplete) {
            Request request = em.find(Request.class, requestAction.getRequestId());
            transitionService.disableTransitions(request);
            Transition transition = em.find(Transition.class, requestAction.getTransitionId());
            request.setStateId(transition.getNextStateId());
            em.persist(request);
            transitionService.loadTransitions(request);
        }
        return requestAction;
    }

    private List<RequestAction> findByTransition(Integer transitionId, Integer requestId) {
        TypedQuery<RequestAction> query = em.createQuery("select ra from RequestAction ra where ra.transitionId = ?1 and ra.requestId = ?2 and ra.isActive = true and ra.isComplete = false", RequestAction.class);
        query.setParameter(1, transitionId);
        query.setParameter(2, requestId);
        List<RequestAction> ras = query.getResultList();
        return ras;
    }

}
