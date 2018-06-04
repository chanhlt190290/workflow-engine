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
import workflow.engine.model.Process;
import workflow.engine.service.ProcessService;

/**
 *
 * @author trungchanh
 */
@Service
@Transactional
public class ProcessServiceImpl implements ProcessService {

    @PersistenceContext
    private EntityManager em;

    @Override
    public Process create(Process process) {
        em.persist(process);
        return process;
    }

}
