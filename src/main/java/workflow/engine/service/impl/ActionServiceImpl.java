package workflow.engine.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import workflow.engine.dao.ActionDao;
import workflow.engine.model.Action;
import workflow.engine.model.Request01;
import workflow.engine.service.ActionService;
import workflow.engine.service.RequestService;

@Service
@Transactional
public class ActionServiceImpl implements ActionService {

    @Autowired
    private ActionDao actionDao;

    @Autowired
    RequestService requestService;

    @Override
    public List<Action> getAll() {
        return actionDao.getAll();
    }

    @Override
    public Action findById(int id) {
        return actionDao.findById(id);
    }

    @Override
	public List<Request01> getRequests() {
		return requestService.getRequests();
	}



}