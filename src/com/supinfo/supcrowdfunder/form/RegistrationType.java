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
        try {
            UserDao.insertOne(request.getParameter("email"), request.getParameter("password"));
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
            UserValidator.email(request.getParameter("email"));
        } catch (Exception e) {
            errors.put("email", e.getMessage());
        }
        if (!errors.isEmpty())
            result = false;
    }
}
