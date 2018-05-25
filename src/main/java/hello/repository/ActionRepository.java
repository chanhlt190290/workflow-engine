package hello.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hello.model.Action;

@Repository
public interface ActionRepository extends JpaRepository<Action, Integer>{
    
}