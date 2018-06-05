package workflow.engine.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import workflow.engine.model.Action;
import workflow.engine.service.ActionService;

@Service
@Transactional
public class ActionServiceImpl implements ActionService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Action get(int id) {
        return em.find(Action.class, id);
    }

    @Override
    public Action create(Action action) {
        em.persist(action);
        return action;
    }

}
