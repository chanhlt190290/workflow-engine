package workflow.engine.service.impl;



import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import workflow.engine.model.Action;
import workflow.engine.service.ActionService;
import workflow.engine.service.RequestService;

@Service
@Transactional
public class ActionServiceImpl implements ActionService {

    @PersistenceContext
    private EntityManager em;

    @Autowired
    RequestService requestService;

    @Override
    public List<Action> getAll() {
        return em.createQuery("select a from Action a", Action.class).getResultList();
    }

    @Override
    public Action findById(int id) {
        return em.find(Action.class, id);
    }

    @Override
    public Action create(Action action) {
        em.persist(action);
        return action;
    }



}