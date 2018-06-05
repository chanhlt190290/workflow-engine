/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.service.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Service;
import workflow.engine.model.Target;
import workflow.engine.service.TargetService;

/**
 *
 * @author trungchanh
 */
@Service
@Transactional
public class TargetServiceImpl implements TargetService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Target create(Target target) {
        em.persist(target);
        return target;
    }

}
