package workflow.engine.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import workflow.engine.model.Action;

@Repository
@Transactional
public interface ActionRepository extends JpaRepository<Action, Integer>{
    
}