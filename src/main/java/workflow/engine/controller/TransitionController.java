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
import workflow.engine.model.Transition;
import workflow.engine.service.TransitionService;

/**
 *
 * @author trungchanh
 */
@RestController
@RequestMapping("/api/v1")
public class TransitionController {

    @Autowired
    TransitionService transitionService;

    @PostMapping(value = "/transitions", consumes = "application/json")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody Transition transition) {
        transition = transitionService.create(transition);
        ApiResponse apiResponse = new ApiResponse(transition);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/transitions/{transitionId}/actions", consumes = "application/json")
    public ResponseEntity<ApiResponse> addActions(@PathVariable("transitionId") int transitionId, @Valid @RequestBody List<Integer> actionIds) {
        Transition transition = transitionService.addActions(transitionId, actionIds);
        ApiResponse apiResponse = new ApiResponse(transition);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
