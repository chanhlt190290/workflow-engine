package workflow.engine.service;

import java.util.List;

import workflow.engine.model.Action;

public interface ActionService{
    List<Action> getAll();
}