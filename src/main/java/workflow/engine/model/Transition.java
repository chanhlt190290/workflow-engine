/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.model;

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
import javax.persistence.ManyToMany;
import javax.persistence.Table;

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
    public Integer getCurrentState() {
        return currentState;
    }

    /**
     * @param currentState the currentState to set
     */
    public void setCurrentState(Integer currentState) {
        this.currentState = currentState;
    }

    /**
     * @return the nextState
     */
    public Integer getNextState() {
        return nextState;
    }

    /**
     * @param nextState the nextState to set
     */
    public void setNextState(Integer nextState) {
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
    @Column(name = "current_state_id")
    private Integer currentState;
    @Column(name = "next_state_id")
    private Integer nextState;
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
