package workflow.engine.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import workflow.engine.dao.ActionDao;
import workflow.engine.model.Action;
import workflow.engine.service.ActionService;

@Service
@Transactional
public class ActionServiceImpl implements ActionService{

    @Autowired
    private ActionDao actionDao;
	@Override
	public List<Action> getAll() {
		return actionDao.getAll();
	}

}