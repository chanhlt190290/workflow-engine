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
import org.springframework.web.bind.annotation.RestController;
import workflow.engine.model.Action;
import workflow.engine.model.ApiResponse;
import workflow.engine.service.ActionService;

/**
 *
 * @author trungchanh
 */
@RestController
@RequestMapping("/api/v1")
public class ActionController {

    @Autowired
    ActionService actionService;

    @PostMapping(value = "/actions", consumes = "application/json")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody Action action) {
        action = actionService.create(action);
        ApiResponse apiResponse = new ApiResponse(action);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}