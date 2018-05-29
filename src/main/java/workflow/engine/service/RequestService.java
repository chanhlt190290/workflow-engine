/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.service;

import java.util.List;
import workflow.engine.model.Request01;

/**
 *
 * @author trungchanh
 */
public interface RequestService {
    Request01 getRequest(int id);
    List<Request01> getRequests();
}
