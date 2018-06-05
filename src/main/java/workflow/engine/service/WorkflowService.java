/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.service;

import workflow.engine.model.Request;
import workflow.engine.model.RequestAction;

/**
 *
 * @author trungchanh
 */
public interface WorkflowService {

    Request makeRequest(Request request);

    RequestAction doRequestAction(int actionId, int userId);

}
