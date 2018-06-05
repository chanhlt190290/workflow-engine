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

    public Transition create(Transition transition);

    public Transition addActions(int transitionId, List<Integer> actionIds);

    public Transition addActivities(int transitionId, List<Integer> activityIds);

}
