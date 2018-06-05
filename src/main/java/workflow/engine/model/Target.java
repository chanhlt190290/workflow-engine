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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author trungchanh
 */
@Entity
@Table(name = "target")
public class Target implements Serializable {

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
     * @return the targetTypeId
     */
    public Integer getTargetTypeId() {
        return targetTypeId;
    }

    /**
     * @param targetTypeId the targetTypeId to set
     */
    public void setTargetTypeId(Integer targetTypeId) {
        this.targetTypeId = targetTypeId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * @return the userGroupId
     */
    public Integer getUserGroupId() {
        return userGroupId;
    }

    /**
     * @param userGroupId the userGroupId to set
     */
    public void setUserGroupId(Integer userGroupId) {
        this.userGroupId = userGroupId;
    }

    private static final long serialVersionUID = 8644933097540474847L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "target_type_id")
    @NotNull
    private Integer targetTypeId;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_group_id")
    private Integer userGroupId;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "action_target",
            joinColumns = {
                @JoinColumn(name = "target_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "action_id", referencedColumnName = "id")})
    @JsonIgnore
    private Set<Action> actions = new HashSet<>();

}
