package workflow.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import workflow.engine.model.Request;

@Repository
public interface RequestRepository extends JpaRepository<Request, Integer>{
    
}