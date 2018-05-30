/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.TIMESTAMP;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author trungchanh
 */
@Entity
@Table(name = "request")
@EntityListeners(AuditingEntityListener.class)

public class Request implements Serializable {

    private static final long serialVersionUID = 2303329690517682228L;

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

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
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the user
     */
    public Integer getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Integer user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "process_id")
    @NotNull
    private Integer process;

    @Column(name = "title")
    @NotNull
    private String title;

    @Column(name = "user_id")
    @NotNull
    private Integer user;

    @Column(name = "username")
    @NotNull
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "current_state_id")
    @NotNull
    @JsonIgnore
    private State state;

//    @Column(name = "current_state_id", insertable = false, updatable = false)
//    @NotNull
//    private Integer stateId;

    @Column(name = "date_requested", nullable = false, updatable = false)
    @Temporal(TIMESTAMP)
    @CreatedDate

    private Date created;
    
    @Transient
    private Integer stateId;

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
     * @return the state
     */
    public State getState() {
        return state;
    }

    /**
     * @param stateId the state to set
     */
    public void setState(State stateId) {
        this.state = stateId;
    }

    /**
     * @return the created
     */
    public Date getCreated() {
        return created;
    }

    /**
     * @param created the created to set
     */
    public void setCreated(Date created) {
        this.created = created;
    }

//    /**
//     * @return the stateId
//     */
//    public Integer getStateId() {
//        return stateId;
//    }
//
//    /**
//     * @param stateId the stateId to set
//     */
//    public void setStateId(Integer stateId) {
//        this.stateId = stateId;
//    }

    /**
     * @return the stateId
     */
    public Integer getStateId() {
        return stateId;
    }

    /**
     * @param stateId the stateId to set
     */
    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

}
