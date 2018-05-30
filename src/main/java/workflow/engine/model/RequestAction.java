/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 *
 * @author trungchanh
 */
@Entity
@Table(name = "request_action", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"transition_id", "request_id", "action_id"})})
//@EntityListeners(AuditingEntityListener.class)
public class RequestAction implements Serializable {

    /**
     * @return the request
     */
    public Request getRequest() {
        return request;
    }

    /**
     * @param request the request to set
     */
    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     * @return the transition
     */
    public Transition getTransition() {
        return transition;
    }

    /**
     * @param transition the transition to set
     */
    public void setTransition(Transition transition) {
        this.transition = transition;
    }

    /**
     * @return the actionId
     */
    public Integer getAction() {
        return actionId;
    }

    /**
     * @param action the actionId to set
     */
    public void setAction(Integer action) {
        this.actionId = action;
    }

    /**
     * @return the completedBy
     */
    public Integer getCompletedBy() {
        return completedBy;
    }

    /**
     * @param completedBy the completedBy to set
     */
    public void setCompletedBy(Integer completedBy) {
        this.completedBy = completedBy;
    }

    /**
     * @return the isActive
     */
    public Boolean getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * @return the isComplete
     */
    public Boolean getIsComplete() {
        return isComplete;
    }

    /**
     * @param isComplete the isComplete to set
     */
    public void setIsComplete(Boolean isComplete) {
        this.isComplete = isComplete;
    }

    private static final long serialVersionUID = 2303329690517682228L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "request_id")
    @NotNull
    @JsonIgnore
    private Request request;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "transition_id")
    @NotNull
    @JsonIgnore
    private Transition transition;

    @Column(name = "action_id")
    @NotNull
    private Integer actionId;

    @Column(name = "completed_by")
    private Integer completedBy;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "is_complete")
    private Boolean isComplete = false;

}
