package com.supinfo.supcrowdfunder.entity;

import javax.persistence.*;

/**
 * Created with IntelliJ IDEA.
 * User: Romain Letrémy
 * Date: 25/11/13
 * Time: 14:44
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table (name = "categorie")
public class Categorie {
    protected Long id;
    protected String name;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue
    @Column (name = "id")
    public Long getId() {
        return id;
    }

    @Column (name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public Categorie setName(String name) {
        this.name = name;
        return this;
    }
}
