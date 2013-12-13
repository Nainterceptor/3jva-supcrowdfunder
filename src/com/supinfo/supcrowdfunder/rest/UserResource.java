package com.supinfo.supcrowdfunder.rest;

import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.util.SecurityHelper;
import com.supinfo.supcrowdfunder.validator.UserValidator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Gaël Demette
 * Date: 11/12/13
 * Time: 14:00
 */
@Path("/user")
public class UserResource {
    @POST @Path("/checkuser") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Map checkUser(@FormParam("email") final String email, @FormParam("password") final String password) {
        Map<String, Object> json = new HashMap<>();
        try {
            User currentUser = UserDao.findUserByMail(email);
            UserValidator.emailLogin(email, currentUser);
            UserValidator.passwordLogin(password, currentUser);
            json.put("user", currentUser);
        } catch (Exception e) {
            json.put("error", e.getMessage());
        }
        return json;
    }

    @POST @Path("/register") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Map register(
            @FormParam("email") final String email,
            @FormParam("password") final String password,
            @FormParam("confirmPassword") final String confirmPassword,
            @FormParam("firstname") final String firstname,
            @FormParam("lastname") final String lastname
    ) {
        //Never admin on registration, please register the first user on the website
        Map<String, Object> json = new HashMap<>();
        try {
            UserValidator.emailRegistration(email);
            UserValidator.password(password);
            UserValidator.confirmpassword(password, confirmPassword);
            UserValidator.firstname(firstname);
            UserValidator.lastname(lastname);
            UserDao.insertOne(email, password, firstname, lastname);
            json.put("error", false);
        } catch (Exception e) {
            json.put("error", e.getMessage());
        }
        return json;
    }

    @POST @Path("/edit") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Map edit(
            @FormParam("email") final String email,
            @FormParam("password") final String password,
            @FormParam("newEmail") final String newEmail,
            @FormParam("newPassword") final String newPassword,
            @FormParam("confirmPassword") final String confirmPassword,
            @FormParam("firstname") final String firstname,
            @FormParam("lastname") final String lastname,
            @FormParam("address") final String address,
            @FormParam("zipCode") final String zipCode,
            @FormParam("city") final String city,
            @FormParam("sex") final Boolean sex
    ) {
        Map<String, Object> json = new HashMap<>();
        try {
            User currentUser = UserDao.findUserByMail(email);
            UserValidator.emailLogin(email, currentUser);
            UserValidator.passwordLogin(password, currentUser);
            UserValidator.email(newEmail);
            UserValidator.firstname(firstname);
            UserValidator.lastname(lastname);
            UserValidator.address(address);
            UserValidator.zipCode(zipCode);
            UserValidator.city(city);
            if (newPassword != null && newPassword.length() > 0) {
                UserValidator.password(newPassword);
                UserValidator.confirmpassword(newPassword, confirmPassword);
                String salt = SecurityHelper.generateSalt();
                currentUser.setSalt(salt).setPassword(SecurityHelper.hashPassword(newPassword, salt));
            }
            currentUser
                    .setEmail(newEmail)
                    .setFirstname(firstname)
                    .setLastname(lastname)
                    .setAddress(address)
                    .setZipCode(zipCode)
                    .setCity(city)
                    .setSex(sex);
            UserDao.persist(currentUser);
            json.put("error", false);
        } catch (Exception e) {
            json.put("error", e.getMessage());
        }
        return json;
    }
}
