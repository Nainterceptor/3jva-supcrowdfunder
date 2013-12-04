package com.supinfo.supcrowdfunder.form;

import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: Gaël Demette
 * Date: 22/11/13
 * Time: 01:05
 */
public class RegistrationType extends AbstractType {

    public void persist(HttpServletRequest request) {
        persist(request, false);
    }
    public void persist(HttpServletRequest request, Boolean admin) {
        try {
            UserDao.insertOne(
                    request.getParameter("email"),
                    request.getParameter("password"),
                    request.getParameter("firstname"),
                    request.getParameter("lastname"),
                    admin
            );
        } catch (Exception e) {
            errors.put("internal", e.getMessage());
        }
    }
    public void validate(HttpServletRequest request) {
        try {
            UserValidator.password(request.getParameter("password"));
        } catch (Exception e) {
            errors.put("password", e.getMessage());
        }
        try {
            UserValidator.confirmpassword(request.getParameter("password"), request.getParameter("confirmPassword"));
        } catch (Exception e) {
            errors.put("confirmPassword", e.getMessage());
        }
        //In last, validators with SQL queries
        try {
            UserValidator.emailRegistration(request.getParameter("email"));
        } catch (Exception e) {
            errors.put("email", e.getMessage());
        }
        try {
            UserValidator.firstname(request.getParameter("firstname"));
        } catch (Exception e) {
            errors.put("firstname", e.getMessage());
        }
        try {
            UserValidator.lastname(request.getParameter("lastname"));
        } catch (Exception e) {
            errors.put("lastname", e.getMessage());
        }
        if (!errors.isEmpty())
            result = false;
    }
}
