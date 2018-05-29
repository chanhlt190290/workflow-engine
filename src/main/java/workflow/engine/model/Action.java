package workflow.engine.model;

import java.io.Serializable;
//import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//
//import org.springframework.data.annotation.CreatedDate;
//import org.springframework.data.annotation.LastModifiedDate;
//import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 *
 * @author chanhlt
 */
@Entity
@Table(name = "action")
//@EntityListeners(AuditingEntityListener.class)
//@JsonIgnoreProperties(value = { "Created", "Updated" }, allowGetters = true)
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

//    @Column(name = "created_at", nullable = false, updatable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @CreatedDate
//    private Date created;
//
//    @Column(name = "updated_at", nullable = false)
//    @Temporal(TemporalType.TIMESTAMP)
//    @LastModifiedDate
//    private Date updated;

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

//    public Date getCreated(){
//        return this.created;
//    }
//
//    public void setCreated(Date created){
//        this.created =  created;
//    }
//
//    public Date getUpdated(){
//        return this.updated;
//    }
//
//    public void setUpdated(Date created){
//        this.updated =  created;
//    }
}
