package com.supinfo.supcrowdfunder.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

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
    protected User user;
    protected Long needCredits;
    protected Timestamp term;
    private Categorie categories;
    private List<Contribute> contributes;

//    public Short percentage(){
//        return Statistic.percentage(ContributeDao.sumContributes(id), this.needCredits);
//    }

    @OneToMany(mappedBy="project")
    public List<Contribute> getContributes() {
        return contributes;
    }

    public Project setContributes(List<Contribute> contributes) {
        this.contributes = contributes;
        return this;
    }

    public Project setCategories(Categorie categories) {
        this.categories = categories;
        return this;
    }

    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=Categorie.class )
    @JoinColumn(name="categorie_id")
    public Categorie getCategories() {
        return categories;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public Project setId(Long id) {
        this.id = id;
        return this;
    }

    @Column(name = "name", nullable = false)
    public String getName() {
        return name;
    }

    public Project setName(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "details", nullable = false)
    public String getDetails() {
        return details;
    }

    public Project setDetails(String details) {
        this.details = details;
        return this;
    }

    @Column(name = "needCredits", nullable = false)
    public Long getNeedCredits() {
        return needCredits;
    }

    public Project setNeedCredits(Long needCredits) {
        this.needCredits = needCredits;
        return this;
    }

    @Column(name = "term", nullable = true)
    public Timestamp getTerm() {
        return term;
    }

    public Project setTerm(Timestamp term) {
        this.term = term;
        return this;
    }

    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=User.class )
    @JoinColumn(name="userId", nullable = false)
    public User getUser() {
        return user;
    }

    public Project setUser(User user) {
        this.user = user;
        return this;
    }
}
