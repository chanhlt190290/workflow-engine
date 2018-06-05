/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.service;

import java.util.List;
import workflow.engine.model.Activity;

/**
 *
 * @author trungchanh
 */
public interface ActivityService {

    Activity create(Activity activity);

    public Activity addTargets(int activityId, List<Integer> targetIds);
}
