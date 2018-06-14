/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.LastModifiedDate;

/**
 *
 * @author trungchanh
 */
@Entity
@Table(name = "request_action")
public class RequestAction implements Serializable {

    /**
     * @return the action
     */
    public Action getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(Action action) {
        this.action = action;
    }

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
    public Long getCompletedBy() {
        return completedBy;
    }

    /**
     * @param completedBy the completedBy to set
     */
    public void setCompletedBy(Long completedBy) {
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
    private Long id;

    @Column(name = "request_id")
    @NotNull
    @JsonIgnore
    private Long requestId;

    @Column(name = "transition_id")
    @NotNull
    @JsonIgnore
    private Long transitionId;

    @Column(name = "completed_by")
    @JsonIgnore
    private Long completedBy;

    @Column(name = "completed_at")
    @Temporal(TIMESTAMP)
    @LastModifiedDate
    @JsonIgnore
    private Date completedAt;

    @Column(name = "is_active")
    @NotNull
    @JsonIgnore
    private Boolean isActive = true;

    @Column(name = "is_complete")
    @NotNull
    @JsonIgnore
    private Boolean isComplete = false;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "action_id")
    @NotNull
    private Action action;
    
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
     * @return the requestId
     */
    public Long getRequestId() {
        return requestId;
    }

    /**
     * @param requestId the requestId to set
     */
    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    /**
     * @return the transitionId
     */
    public Long getTransitionId() {
        return transitionId;
    }

    /**
     * @param transitionId the transitionId to set
     */
    public void setTransitionId(Long transitionId) {
        this.transitionId = transitionId;
    }

}
