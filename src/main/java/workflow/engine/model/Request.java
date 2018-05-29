/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author trungchanh
 */
@Entity
@Table(name = "request")
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
    
    @Column(name = "current_state_id")
    @NotNull
    private Integer state;
    
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
    public Integer getState() {
        return state;
    }

    /**
     * @param stateId the state to set
     */
    public void setState(Integer stateId) {
        this.state = stateId;
    }

}
