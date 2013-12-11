package com.supinfo.supcrowdfunder.entity;

import com.supinfo.supcrowdfunder.implementable.IEntity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Romain Letrémy
 * Date: 25/11/13
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "categorie")
@XmlRootElement()
public class Categorie implements IEntity {

    protected Long id;
    protected String name;
    private List<Project> project;

    public Categorie setProject(List<Project> project) {
        this.project = project;
        return this;
    }

    @OneToMany(mappedBy = "categories")
    @XmlTransient
    public List<Project> getProject() {
        return project;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public Categorie setName(String name) {
        this.name = name;
        return this;
    }
}
