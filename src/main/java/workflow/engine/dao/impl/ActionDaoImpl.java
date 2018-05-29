package workflow.engine.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import workflow.engine.dao.ActionDao;
import workflow.engine.model.Action;

@Repository
public class ActionDaoImpl implements ActionDao {

    final static Logger logger = LoggerFactory.getLogger(ActionDaoImpl.class);
    private SessionFactory sessionFactory;

    @Autowired
    public ActionDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Action> getAll() {
        return this.sessionFactory.getCurrentSession().createQuery("from Action").list();
    }

    @Override
    public Action findById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        @SuppressWarnings("unchecked")
        TypedQuery<Action> query = session.getNamedQuery("findActionById");
        query.setParameter("id", id);
        Action action = query.getSingleResult();
        return action;
    }

}