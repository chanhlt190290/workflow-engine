package workflow.engine.service;

import workflow.engine.model.Action;

public interface ActionService {

    Action get(int id);

    Action create(Action action);

}
