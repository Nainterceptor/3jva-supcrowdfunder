package com.supinfo.supcrowdfunder.form;

import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: Gaël Demette
 * Date: 25/11/13
 * Time: 12:59
 */
public class LoginType extends AbstractType {
    public void validate(HttpServletRequest request) {
        User userToCheck = UserDao.findUserByMail(request.getParameter("email"));
        try {
            UserValidator.emailLogin(request.getParameter("email"), userToCheck);
        } catch (Exception e) {
            errors.put("email", e.getMessage());
        }
        try {
            UserValidator.passwordLogin(request.getParameter("password"), userToCheck);
        } catch (Exception e) {
            errors.put("password", e.getMessage());
        }

        if (!errors.isEmpty())
            result = false;
    }
}