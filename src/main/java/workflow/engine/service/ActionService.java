package workflow.engine.service;

import java.util.List;

import workflow.engine.model.Action;
import workflow.engine.model.Request01;

public interface ActionService{
    List<Action> getAll();
    Action findById(int id);
    List<Request01> getRequests();
}