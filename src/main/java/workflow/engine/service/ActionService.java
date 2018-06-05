package workflow.engine.service;

import java.util.List;
import workflow.engine.model.Action;

public interface ActionService {

    Action get(int id);

    Action create(Action action);

    public Action addTargets(int actionId, List<Integer> targetIds);

}
