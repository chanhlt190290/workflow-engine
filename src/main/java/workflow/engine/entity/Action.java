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
 * @author chanhlt
 */
@Entity
@Table(name = "action")
@EntityListeners(AuditingEntityListener.class)
public class Action implements Serializable {

    /**
     * @return the targets
     */
    public Set<Target> getTargets() {
        return targets;
    }

    /**
     * @param targets the targets to set
     */
    public void setTargets(Set<Target> targets) {
        this.targets = targets;
    }

    public Action() {
    }

    public Action(Long id) {
        this.id = id;
    }

    /**
     * @return the transitions
     */
    public Set<Transition> getTransitions() {
        return transitions;
    }

    /**
     * @param transitions the transitions to set
     */
    public void setTransitions(Set<Transition> transitions) {
        this.transitions = transitions;
    }

    private static final long serialVersionUID = 4277037918733220692L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Long id;

    @Column(name = "action_type_id")
    @NotNull
    private Integer actionTypeId;

    @Column(name = "process_id")
    @NotNull
    @JsonIgnore
    private Long processId;

    @Column(name = "name")
    @NotNull
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "transition_action",
            joinColumns = {
                @JoinColumn(name = "action_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "transition_id", referencedColumnName = "id")})
    @JsonIgnore
    private Set<Transition> transitions = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "action_target",
            joinColumns = {
                @JoinColumn(name = "action_id", referencedColumnName = "id")},
            inverseJoinColumns = {
                @JoinColumn(name = "target_id", referencedColumnName = "id")})
    private Set<Target> targets = new HashSet<>();

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the actionTypeId
     */
    public Integer getActionTypeId() {
        return actionTypeId;
    }

    /**
     * @param actionTypeId the actionTypeId to set
     */
    public void setActionTypeId(Integer actionTypeId) {
        this.actionTypeId = actionTypeId;
    }

    /**
     * @return the processId
     */
    public Long getProcessId() {
        return processId;
    }

    /**
     * @param processId the processId to set
     */
    public void setProcessId(Long processId) {
        this.processId = processId;
    }

}
