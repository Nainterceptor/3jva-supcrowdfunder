package com.supinfo.supcrowdfunder.entity;


import com.supinfo.supcrowdfunder.implementable.IEntity;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Robin
 * Date: 26/11/13
 * Time: 17:28
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "contribute")
public class Contribute implements IEntity {

    protected Long id;
    protected Long amount;
    protected User user;
    protected Timestamp rightNow;
    protected Project project;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = User.class)
    @JoinColumn(name = "userId", nullable = false)
    public User getUser() {
        return user;
    }

    public Contribute setUser(User user) {
        this.user = user;
        return this;
    }

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity = Project.class)
    @JoinColumn(name = "projectId", nullable = false)
    public Project getProject() {
        return project;
    }

    public Contribute setProject(Project project) {
        this.project = project;
        return this;
    }

    @Id
    @GeneratedValue

    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public Contribute setId(Long id) {
        this.id = id;
        return this;
    }

    @Column(name = "amount", nullable = false)
    public Long getAmount() {
        return amount;
    }

    public Contribute setAmount(Long amount) {
        this.amount = amount;
        return this;
    }


    @Column(name = "rightNow", nullable = false)
    public Timestamp getRightNow() {
        return rightNow;
    }

    public Contribute setRightNow(Timestamp rightNow) {
        this.rightNow = rightNow;
        return this;
    }


}
