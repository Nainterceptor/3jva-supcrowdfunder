package com.supinfo.supcrowdfunder.form;

import com.supinfo.supcrowdfunder.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: Gaël Demette
 * Date: 27/11/13
 * Time: 18:11
 */
public class CreateUserType extends UserType {
    public void validate(HttpServletRequest request) {
        try {
            UserValidator.emailRegistration(request.getParameter("email"));
        } catch (Exception e) {
            errors.put("email", e.getMessage());
        }
        try {
            UserValidator.password(request.getParameter("password"));
        } catch (Exception e) {
            errors.put("password", e.getMessage());
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
        try {
            UserValidator.city(request.getParameter("city"));
        } catch (Exception e) {
            errors.put("city", e.getMessage());
        }
        try {
            UserValidator.zipCode(request.getParameter("zipCode"));
        } catch (Exception e) {
            errors.put("zipCode", e.getMessage());
        }
        try {
            UserValidator.address(request.getParameter("address"));
        } catch (Exception e) {
            errors.put("address", e.getMessage());
        }
        if (!errors.isEmpty())
            result = false;
    }
}
