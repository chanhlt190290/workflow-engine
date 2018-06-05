/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.validation.constraints.NotNull;

/**
 *
 * @author trungchanh
 */
@Entity
@Table(name = "request_action")
public class RequestAction implements Serializable {

    /**
     * @return the completedAt
     */
    public Date getCompletedAt() {
        return completedAt;
    }

    /**
     * @param completedAt the completedAt to set
     */
    public void setCompletedAt(Date completedAt) {
        this.completedAt = completedAt;
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

    @JoinColumn(name = "request_id")
    @NotNull
    private Integer requestId;

    @JoinColumn(name = "transition_id")
    @NotNull
    private Integer transitionId;

    @Column(name = "action_id")
    @NotNull
    private Integer actionId;

    @Column(name = "completed_by")
    private Integer completedBy;

    @Column(name = "completed_at")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date completedAt;

    @Column(name = "is_active")
    @NotNull
    private Boolean isActive = true;

    @Column(name = "is_complete")
    @NotNull
    private Boolean isComplete = false;

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the requestId
     */
    public Integer getRequestId() {
        return requestId;
    }

    /**
     * @param requestId the requestId to set
     */
    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
    }

    /**
     * @return the transitionId
     */
    public Integer getTransitionId() {
        return transitionId;
    }

    /**
     * @param transitionId the transitionId to set
     */
    public void setTransitionId(Integer transitionId) {
        this.transitionId = transitionId;
    }

    /**
     * @return the actionId
     */
    public Integer getActionId() {
        return actionId;
    }

    /**
     * @param actionId the actionId to set
     */
    public void setActionId(Integer actionId) {
        this.actionId = actionId;
    }

}
