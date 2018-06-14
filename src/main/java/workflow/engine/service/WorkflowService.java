/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.service;

import workflow.engine.entity.Request;

/**
 *
 * @author trungchanh
 */
public interface WorkflowService {

    Request makeRequest(Request request);

    Request doRequestAction(Long requestId, Long actionId, Long userId);

    Request getRequest(Long requestId);

    public Request makeRequest(long processId, long userId, String title);

}
