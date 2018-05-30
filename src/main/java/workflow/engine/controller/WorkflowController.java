/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import workflow.engine.model.ApiResponse;
import workflow.engine.model.Request;
import workflow.engine.model.RequestAction;
import workflow.engine.service.RequestActionService;
import workflow.engine.service.RequestService;

/**
 *
 * @author trungchanh
 */
@RestController
@RequestMapping("/api")
public class WorkflowController {

    @Autowired
    RequestActionService reqActionService;

    @Autowired
    RequestService requestService;

    @PostMapping("/actions/{id}")
    public ResponseEntity<ApiResponse> performAction(@PathVariable int id) {
        RequestAction requestAction = reqActionService.performAction(id);
        ApiResponse apiResponse = new ApiResponse(requestAction);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    
    @PostMapping("/requests")
    public ResponseEntity<ApiResponse> createRequest(@RequestBody Request request) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(mapper.writeValueAsString(request));
        request = requestService.create(request, request.getStateId());
        ApiResponse apiResponse = new ApiResponse(request);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
