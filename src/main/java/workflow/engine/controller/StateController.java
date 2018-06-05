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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import workflow.engine.model.ApiResponse;
import workflow.engine.model.State;
import workflow.engine.model.Transition;
import workflow.engine.service.StateService;

/**
 *
 * @author trungchanh
 */
@RestController
@RequestMapping("/api/v1")
public class StateController {

    @Autowired
    StateService stateService;

    @PostMapping(value = "/states", consumes = "application/json")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody State state) {
        state = stateService.create(state);
        ApiResponse apiResponse = new ApiResponse(state);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
    
    @PostMapping(value = "/states/{stateId}/activities", consumes = "application/json")
    public ResponseEntity<ApiResponse> addActivities(@PathVariable("stateId") int stateId, @Valid @RequestBody List<Integer> activityIds) {
        State state = stateService.addActivities(stateId, activityIds);
        ApiResponse apiResponse = new ApiResponse(state);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
