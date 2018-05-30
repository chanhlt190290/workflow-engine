/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author trungchanh
 */
@Entity
@Table(name = "transition")
public class Transition implements Serializable {

    /**
     * @return the process
     */
    public Integer getProcess() {
        return process;
    }

    /**
     * @param process the process to set
     */
    public void setProcess(Integer process) {
        this.process = process;
    }

    /**
     * @return the currentState
     */
    public State getCurrentState() {
        return currentState;
    }

    /**
     * @param currentState the currentState to set
     */
    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    /**
     * @return the nextState
     */
    public State getNextState() {
        return nextState;
    }

    /**
     * @param nextState the nextState to set
     */
    public void setNextState(State nextState) {
        this.nextState = nextState;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "process_id")
    private Integer process;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_state_id")
    @NotNull
    @JsonIgnore
    private State currentState;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "next_state_id")
    @NotNull
    @JsonIgnore
    private State nextState;
    
    
    @Column(name = "description")
    private String description;
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            },
            mappedBy = "transitions")
    private Set<Action> actions = new HashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the actions
     */
    public Set<Action> getActions() {
        return actions;
    }

    /**
     * @param actions the actions to set
     */
    public void setActions(Set<Action> actions) {
        this.actions = actions;
    }

}
