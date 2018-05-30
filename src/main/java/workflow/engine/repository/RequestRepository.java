/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import workflow.engine.model.Request;

/**
 *
 * @author trungchanh
 */
public interface RequestRepository extends JpaRepository<Request, Integer> {
    
}
