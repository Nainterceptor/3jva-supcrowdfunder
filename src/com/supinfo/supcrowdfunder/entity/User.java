package com.supinfo.supcrowdfunder.entity;

import com.supinfo.supcrowdfunder.implementable.IUser;
import com.supinfo.supcrowdfunder.util.SecurityHelper;

import javax.persistence.*;
import java.util.List;

/**
 * Author: Gaël Demette
 * Date: 19/11/13
 * Time: 15:54
 */
@Entity
@Table(name = "user")
public class User implements IUser {

    protected Long id;
    protected String email;
    protected String password;
    protected String salt;
    protected String firstname;
    protected String lastname;
    protected String address;
    protected String zipCode;
    protected String city;
    protected Boolean sex;
    protected Boolean admin;
    protected List<Contribute> contributes;



    public boolean isEqualPassword(String password) {
        boolean isEqual;
        try {
            isEqual = this.password.equals(SecurityHelper.hashPassword(password, this.salt));
        } catch (Exception e) {
            isEqual = false;
        }
        return isEqual;
    }
    @OneToMany(mappedBy="user")
    public List<Contribute> getContributes() {
        return contributes;
    }

    public User setContributes(List<Contribute> contributes) {
        this.contributes = contributes;
        return this;
    }

    @Id
    @GeneratedValue


    @Column(name = "id")
    public Long getId() {
        return id;
    }

    public User setId(Long id) {
        this.id = id;
        return this;
    }

    @Column(name = "email", nullable = false)
    public String getEmail() {
        return email;
    }

    public User setEmail(String email) {
        this.email = email.toLowerCase();
        return this;
    }

    @Column(name = "password", nullable = false)
    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @Column(name = "salt", nullable = false)
    public String getSalt() {
        return salt;
    }

    public User setSalt(String salt) {
        this.salt = salt;
        return this;
    }

    @Column(name = "firstname", nullable = true)
    public String getFirstname() {
        return firstname;
    }

    public User setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    @Column(name = "lastname", nullable = true)
    public String getLastname() {
        return lastname;
    }

    public User setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    @Column(name = "address", nullable = true)
    public String getAddress() {
        return address;
    }

    public User setAddress(String address) {
        this.address = address;
        return this;
    }

    @Column(name = "zipCode", nullable = true)
    public String getZipCode() {
        return zipCode;
    }

    public User setZipCode(String zipCode) {
        this.zipCode = zipCode;
        return this;
    }

    @Column(name = "city", nullable = true)
    public String getCity() {
        return city;
    }

    public User setCity(String city) {
        this.city = city;
        return this;
    }

    @Column(name = "sex", nullable = true)
    public Boolean getSex() {
        return sex;
    }

    public User setSex(Boolean sex) {
        this.sex = sex;
        return this;
    }

    @Column(name = "admin", nullable = true)
    public Boolean getAdmin() {
        return admin;
    }

    public User setAdmin(Boolean admin) {
        this.admin = admin;
        return this;
    }


}
