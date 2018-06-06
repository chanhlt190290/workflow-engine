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
import workflow.engine.model.Activity;
import workflow.engine.model.ApiResponse;
import workflow.engine.service.ActivityService;

/**
 *
 * @author trungchanh
 */
@RestController
@RequestMapping("/api/v1")
public class ActivityController {

    @Autowired
    ActivityService activityService;

    @PostMapping(value = "/activities", consumes = "application/json")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody Activity activity) {
        activity = activityService.create(activity);
        ApiResponse apiResponse = new ApiResponse(activity);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/activities/{activityId}/targets", consumes = "application/json")
    public ResponseEntity<ApiResponse> addTargets(@PathVariable("activityId") int activityId, @Valid @RequestBody List<Integer> targetIds) {
        Activity activity = activityService.addTargets(activityId, targetIds);
        ApiResponse apiResponse = new ApiResponse(activity);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
