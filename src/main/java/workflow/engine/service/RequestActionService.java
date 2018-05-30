/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.service;

import workflow.engine.model.RequestAction;

/**
 *
 * @author trungchanh
 */
public interface RequestActionService {

    public RequestAction getRequestAction(int id);

    public RequestAction update(RequestAction requestAction);
    
    public boolean checkTransitionComplete(int requestId, int transitionId);

    public RequestAction performAction(int id);
    
}
