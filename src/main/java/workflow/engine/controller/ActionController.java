package workflow.engine.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import workflow.engine.model.Action;
import workflow.engine.model.ApiResponse;
import workflow.engine.repository.ActionRepository;

@RestController
@RequestMapping("/api")
public class ActionController {

    @Autowired
    private ActionRepository actionRepository;

    @GetMapping("/actions")
    public ResponseEntity<ApiResponse> getAll() {
        List<Action> actions = actionRepository.findAll();
        ApiResponse apiResponse = new ApiResponse(HttpStatus.OK, null, actions);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

}
