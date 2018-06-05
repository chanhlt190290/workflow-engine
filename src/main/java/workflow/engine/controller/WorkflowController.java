/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @PostMapping(value = "/requests", consumes = "application/json")
    public ResponseEntity<ApiResponse> makeRequest(@Valid @RequestBody Request request) {
        request = workflowService.makeRequest(request);
        ApiResponse apiResponse = new ApiResponse(request);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/requests/{requestId}/actions/{actionId}", consumes = "application/json")
    public ResponseEntity<ApiResponse> performAction(@PathVariable("requestId") int requestId,
            @PathVariable("actionId") int actionId, @RequestParam("userId") int userId) {
        RequestAction requestAction = workflowService.doRequestAction(requestId, actionId, userId);
        ApiResponse apiResponse = new ApiResponse(requestAction);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @GetMapping(value = "/requests/{requestId}")
    public ResponseEntity<ApiResponse> getRequest(@PathVariable("requestId") int requestId) {
        Request request = workflowService.getRequest(requestId);
        ApiResponse apiResponse = new ApiResponse(request);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    
    @GetMapping(value = "/requests/{requestId}/actions")
    public ResponseEntity<ApiResponse> getAvailableActions(@PathVariable("requestId") int requestId) {
        List<RequestAction> availableActions = workflowService.getAvailableActions(requestId);
        ApiResponse apiResponse = new ApiResponse(availableActions);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
