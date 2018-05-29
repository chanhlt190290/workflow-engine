/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workflow.engine.mapper.RequestMapper;
import workflow.engine.model.Request;
import workflow.engine.service.RequestService;

/**
 *
 * @author trungchanh
 */
@Service
public class RequestServiceImpl implements RequestService{

    @Autowired
    RequestMapper requestMapper;
    
    @Override
    public Request getRequest(int id) {
       return  requestMapper.getRequest(id);
    }
    
}
