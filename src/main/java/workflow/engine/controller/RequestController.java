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
import org.springframework.web.bind.annotation.RestController;
import workflow.engine.model.ApiResponse;
import workflow.engine.model.Request;
import workflow.engine.model.Request01;
import workflow.engine.service.RequestService;

/**
 *
 * @author trungchanh
 */
@RestController
@RequestMapping("/api")
public class RequestController {


    @Autowired
    private RequestService requestService;


    @GetMapping("/requests")
    public ResponseEntity<ApiResponse> getAll() {
    //    List<Request> requests = requestRepository.findAll();
        List<Request01> requests = requestService.getRequests();
        ApiResponse apiResponse = new ApiResponse(requests);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/requests", produces = "application/json", consumes = "application/json")
    public ResponseEntity<ApiResponse> create(@Valid @RequestBody Request request) {
       
            // request = requestRepository.save(request);
            
            ApiResponse apiResponse = new ApiResponse(request);
            return new ResponseEntity<>(apiResponse, HttpStatus.OK);
      
    }

    @GetMapping("/requests/{id}")
    public ResponseEntity<ApiResponse> getRequest(@PathVariable int id) {
        Request01 request = requestService.getRequest(id);
        ApiResponse apiResponse = new ApiResponse(request);
        return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    }

    // @PostMapping("/requests/{id}/approve")
    // public ResponseEntity<ApiResponse> approve(@PathVariable int id) {
    //     List<Request> requests = requestRepository.findAll();
    //     ApiResponse apiResponse = new ApiResponse(requests);
    //     return new ResponseEntity<>(apiResponse, HttpStatus.OK);
    // }
}
