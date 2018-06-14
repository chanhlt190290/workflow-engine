/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workflow.engine.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "state")
@EntityListeners(AuditingEntityListener.class)
public class State implements Serializable {

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

    private static final long serialVersionUID = 8644933097540474847L;

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
    @JsonIgnore
    private Long id;

    @Column(name = "state_type_id")
    @NotNull
    @JsonIgnore
    private Integer stateTypeId;

    @Column(name = "process_id")
    @NotNull
    @JsonIgnore
    private Long processId;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "description", columnDefinition = "TEXT")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "state_activity",
            inverseJoinColumns = {
                @JoinColumn(name = "activity_id", referencedColumnName = "id")},
            joinColumns = {
                @JoinColumn(name = "state_id", referencedColumnName = "id")})
    @JsonIgnore
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
     * @return the stateTypeId
     */
    public Integer getStateTypeId() {
        return stateTypeId;
    }

    /**
     * @param stateTypeId the stateTypeId to set
     */
    public void setStateTypeId(Integer stateTypeId) {
        this.stateTypeId = stateTypeId;
    }

}
