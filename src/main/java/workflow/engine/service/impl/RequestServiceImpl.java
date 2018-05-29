/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workflow.engine.mapper.RequestMapper;
import workflow.engine.model.Request01;
import workflow.engine.service.RequestService;

/**
 *
 * @author trungchanh
 */
@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
    RequestMapper requestMapper;

    @Override
    public Request01 getRequest(int id) {
        return requestMapper.getRequest(id);
    }

    @Override
    public List<Request01> getRequests() {
        return requestMapper.getRequests();
    }

}
