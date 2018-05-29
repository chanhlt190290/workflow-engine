package workflow.engine.dao;

import java.util.List;

import workflow.engine.model.Action;

public interface ActionDao{
    List<Action> getAll();
    Action findById(int  id);
}