/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import workflow.engine.model.ApiResponse;
import workflow.engine.model.RequestAction;
import workflow.engine.service.RequestActionService;

/**
 *
 * @author trungchanh
 */
@RestController
@RequestMapping("/api/v1")
public class RequestActionController {

    @Autowired
    private RequestActionService requestActionService;

    @PostMapping("/actions/{id}")
    public ResponseEntity<ApiResponse> perform(@PathVariable int id) {
        RequestAction requestAction = requestActionService.perform(id);
        ApiResponse apiResponse = new ApiResponse(requestAction);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
