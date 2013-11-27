package com.supinfo.supcrowdfunder.form;

import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: Gaël Demette
 * Date: 22/11/13
 * Time: 01:05
 */
public class EditMyUserType extends UserType {
    public void validate(HttpServletRequest request) {
        String password = request.getParameter("password");
        if (password != null && password.length() > 0) {
            try {
                UserValidator.password(password);
            } catch (Exception e) {
                errors.put("password", e.getMessage());
            }
            try {
                UserValidator.confirmpassword(password, request.getParameter("confirmPassword"));
            } catch (Exception e) {
                errors.put("confirmPassword", e.getMessage());
            }
        }
        try {
            UserValidator.email(request.getParameter("email"));
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
