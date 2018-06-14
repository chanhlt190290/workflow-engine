/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author trungchanh
 */
@Entity
@Table(name = "transition")
@EntityListeners(AuditingEntityListener.class)
public class Transition implements Serializable {

    /**
     * @return the activities
     */
    public Set<Activity> getActivities() {
        return activities;
    }

    /**
     * @param activities the activities to set
     */
    public void setActivities(Set<Activity> activities) {
        this.activities = activities;
    }

    private static final long serialVersionUID = 775042849188644497L;

    /**
     * @return the processId
     */
    public Long getProcessId() {
        return processId;
    }

    /**
     * @param process the processId to set
     */
    public void setProcessId(Long process) {
        this.processId = process;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "process_id")
    @NotNull
    private Long processId;

    @JoinColumn(name = "current_state_id")
    @NotNull
    private Long currentStateId;

    @JoinColumn(name = "next_state_id")
    @NotNull
    private Long nextStateId;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "transition_action",
            inverseJoinColumns = {
                @JoinColumn(name = "action_id", referencedColumnName = "id")},
            joinColumns = {
                @JoinColumn(name = "transition_id", referencedColumnName = "id")})
    private Set<Action> actions = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "transition_activity",
            inverseJoinColumns = {
                @JoinColumn(name = "activity_id", referencedColumnName = "id")},
            joinColumns = {
                @JoinColumn(name = "transition_id", referencedColumnName = "id")})
    private Set<Activity> activities = new HashSet<>();

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the currentStateId
     */
    public Long getCurrentStateId() {
        return currentStateId;
    }

    /**
     * @param currentStateId the currentStateId to set
     */
    public void setCurrentStateId(Long currentStateId) {
        this.currentStateId = currentStateId;
    }

    /**
     * @return the nextStateId
     */
    public Long getNextStateId() {
        return nextStateId;
    }

    /**
     * @param nextStateId the nextStateId to set
     */
    public void setNextStateId(Long nextStateId) {
        this.nextStateId = nextStateId;
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
