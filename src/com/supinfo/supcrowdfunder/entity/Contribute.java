package com.supinfo.supcrowdfunder.entity;


import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;
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
public class Contribute {

    protected Long id;
    protected Long amount;
    protected Long userId;
    protected Timestamp rightNow;
    private Project project;


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

    @Column(name = "userId", nullable = false)
    public Long getUserId() {
        return userId;
    }

    public Contribute setUserId(Long userId) {
        this.userId = userId;
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

    @ManyToOne( cascade = {CascadeType.PERSIST, CascadeType.MERGE}, targetEntity=Project.class )
    @JoinColumn(name="projectId", nullable = false)
    public Project getProject() {
        return project;
    }

    public Contribute setProject(Project project) {
        this.project = project;
        return this;
    }
}
