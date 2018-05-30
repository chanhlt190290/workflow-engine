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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author chanhlt
 */
@Entity
@Table(name = "action")
@NamedQueries({
    @NamedQuery(
        name = "findActionById",
        query = "from Action a where a.id = :id"
        ),
})
public class Action implements Serializable {

    private static final long serialVersionUID = 4277037918733220692L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "action_type_id")
    private Integer type;

    @Column(name = "process_id")
    private Integer process;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
    
    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
            })
    @JoinTable(name = "transition_action",
            joinColumns = { @JoinColumn(name = "transition_id") },
            inverseJoinColumns = { @JoinColumn(name = "action_id") })
    private Set<Transition> transitions = new HashSet<>();


    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id =  id;
    }

    public Integer getType(){
        return this.type;
    }

    public void setType(Integer id){
        this.type =  id;
    }

    public Integer getProcess(){
        return this.process;
    }

    public void setProcess(Integer id){
        this.process =  id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name =  name;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description =  description;
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
}
