/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.service;

import workflow.engine.model.Request;

/**
 *
 * @author trungchanh
 */
public interface WorkflowService {

    Request makeRequest(Request request);

    Request doRequestAction(int requestId, int actionId, int userId);

    Request getRequest(int requestId);

}
