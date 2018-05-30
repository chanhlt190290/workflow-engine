package workflow.engine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import workflow.engine.model.ApiResponse;
import workflow.engine.service.ActionService;

@RestController
@RequestMapping("/api")
public class ActionController {

    @Autowired
    ActionService actionService;

//    @GetMapping("/actions")
//    public ResponseEntity<ApiResponse> getAll() {
//        List<Action> actions = actionService.getAll();
//        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, null, actions);
//        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
//    }

}
