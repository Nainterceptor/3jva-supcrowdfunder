package com.supinfo.supcrowdfunder.entity;


import javax.persistence.*;
import java.util.Date;

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
    protected String user;
    protected Date rightNow;

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

    @Column(name = "user", nullable = false)
    public String getUser() {
        return user;
    }

    public Contribute setUser(String user) {
        this.user = user;
        return this;
    }

    @Column(name = "rightNow", nullable = false)
    public Date getRightNow() {
        return rightNow;
    }

    public Contribute setRightNow(Date rightNow) {
        this.rightNow = rightNow;
        return this;
    }
}
