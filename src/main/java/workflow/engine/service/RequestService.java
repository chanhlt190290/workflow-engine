/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.service;

import workflow.engine.model.Request;

/**
 *
 * @author trungchanh
 */
public interface RequestService {

    Request create(Request req);

    Request getById(int id);

    public Request create(Request request, Integer stateId);
}
