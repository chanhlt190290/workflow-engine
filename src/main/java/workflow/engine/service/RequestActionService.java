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

    public RequestAction get(int id);

    public RequestAction perform(int id);
    
}
