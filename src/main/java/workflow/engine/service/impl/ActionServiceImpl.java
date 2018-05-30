package workflow.engine.service.impl;



import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
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
        return em.createQuery("from Action", Action.class).getResultList();
    }

    @Override
    public Action findById(int id) {
        TypedQuery<Action> query = em.createQuery("from Action where id = ?1", Action.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }
////
////    @Override
////	public List<Request01> getRequests() {
////		return requestService.getRequests();
////	}

//    @Override
//    public List<Action> getAll() {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public Action findById(int id) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }

    @Override
    public Action create(Action action) {
        em.persist(action);
        em.flush();
        return action;
    }



}