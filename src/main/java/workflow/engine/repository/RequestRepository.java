package workflow.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import workflow.engine.model.Request;

@Repository
@Transactional
public interface RequestRepository extends JpaRepository<Request, Integer>{

    
    
}