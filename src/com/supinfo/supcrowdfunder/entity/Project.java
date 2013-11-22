package com.supinfo.supcrowdfunder.entity;

import javax.persistence.*;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Fireaxe
 * Date: 22/11/13
 * Time: 01:41
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "project")
public class Project {

    protected Long id;
    protected String name;
    protected String details;
    protected Long actualCredits;
    protected Long needCredits;
    protected Date term;

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "details", nullable = false)
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Column(name = "actualCredits")
    public Long getActualCredits() {
        return actualCredits;
    }

    public void setActualCredits(Long actualCredits) {
        this.actualCredits = actualCredits;
    }

    @Column(name = "needCredits", nullable = false)
    public Long getNeedCredits() {
        return needCredits;
    }

    public void setNeedCredits(Long needCredits) {
        this.needCredits = needCredits;
    }

    @Column(name = "term", nullable = false)
    public Date getTerm() {
        return term;
    }

    public void setTerm(Date term) {
        this.term = term;
    }
}
