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
        UserDao.insertOne(request.getParameter("email"), request.getParameter("password"));
    }
    public void validate(HttpServletRequest request) {
        try {
            UserValidator.email(request.getParameter("email"));
        } catch (Exception e) {
            errors.put("email", e.getMessage());
        }
        try {
            UserValidator.password(request.getParameter("password"));
        } catch (Exception e) {
            errors.put("password", e.getMessage());
        }
        if (!errors.isEmpty())
            result = false;
    }
}
