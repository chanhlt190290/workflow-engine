/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.service;

import java.util.List;
import workflow.engine.model.Transition;

/**
 *
 * @author trungchanh
 */
public interface TransitionService {

    public List<Transition> findByCurrentStateId(int stateId);
    
}
