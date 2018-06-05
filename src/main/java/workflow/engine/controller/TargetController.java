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
import workflow.engine.exception.ArgumentNotValidException;
import workflow.engine.model.ApiResponse;
import workflow.engine.model.Target;
import workflow.engine.service.TargetService;
import workflow.engine.utils.Constants.TargetType;

/**
 *
 * @author trungchanh
 */
@RestController
@RequestMapping("/api/v1")
public class TargetController {

    @Autowired
    TargetService targetService;

    @PostMapping(value = "/targets", consumes = "application/json")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody Target target) {

        if (target.getTargetTypeId() == TargetType.USER.getValue()) {
            if (target.getUserId() == null) {
                throw new ArgumentNotValidException("userId");
            }
        } else if (target.getTargetTypeId() == TargetType.USER_GROUP.getValue()) {
            if (target.getUserGroupId() == null) {
                throw new ArgumentNotValidException("userGroupId");
            }
        } else {
            throw new ArgumentNotValidException("targetTypeId");
        }
        target = targetService.create(target);
        ApiResponse apiResponse = new ApiResponse(target);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }
}
