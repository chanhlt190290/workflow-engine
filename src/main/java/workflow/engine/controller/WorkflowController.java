/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import workflow.engine.model.ApiResponse;
import workflow.engine.model.Request;
import workflow.engine.model.RequestAction;
import workflow.engine.service.WorkflowService;

/**
 *
 * @author trungchanh
 */
@RestController
@RequestMapping("/api/v1/workflow")
public class WorkflowController {

    @Autowired
    private WorkflowService workflowService;

    @PostMapping(value = "/make-request")
    public ResponseEntity<ApiResponse> makeRequest(@Valid @RequestBody Request request) {
        request = workflowService.makeRequest(request);
        ApiResponse apiResponse = new ApiResponse(request);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/perform-action")
    public ResponseEntity<ApiResponse> performAction(@RequestParam("actionId") int actionId, @RequestParam("userId") int userId) {
        RequestAction requestAction = workflowService.doRequestAction(actionId, userId);
        ApiResponse apiResponse = new ApiResponse(requestAction);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
