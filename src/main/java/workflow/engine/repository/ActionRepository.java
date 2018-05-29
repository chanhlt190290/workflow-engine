package workflow.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import workflow.engine.model.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer>{
    
}