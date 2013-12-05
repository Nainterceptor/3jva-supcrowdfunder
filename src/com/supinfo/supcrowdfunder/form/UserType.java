package com.supinfo.supcrowdfunder.form;

import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.util.SecurityHelper;
import com.supinfo.supcrowdfunder.validator.UserValidator;

import javax.servlet.http.HttpServletRequest;

/**
 * Author: Gaël Demette
 * Date: 22/11/13
 * Time: 01:05
 */
public class UserType extends AbstractType {
    public void persist(User user) {
        try {
            UserDao.persist(user);
        } catch (Exception e) {
            errors.put("internal", e.getMessage());
            result = false;
        }
    }

    public User fill(User user, HttpServletRequest request, Boolean ignoreAdmin) {
        String password = request.getParameter("password");
        if (password != null && password.length() > 0) {
            String salt = SecurityHelper.generateSalt();
            try {
                user.setSalt(salt).setPassword(SecurityHelper.hashPassword(password, salt));
            } catch (Exception e) {
                errors.put("internal", "Hash failed");
            }
        }
        String email = request.getParameter("email");
        user.setEmail(email);

        String firstname = request.getParameter("firstname");
        user.setFirstname(firstname);

        String lastname = request.getParameter("lastname");
        user.setLastname(lastname);

        String address = request.getParameter("address");
        user.setAddress(address);

        String zipCode = request.getParameter("zipCode");
        user.setZipCode(zipCode);

        String city = request.getParameter("city");
        user.setCity(city);

        Boolean sex = Boolean.parseBoolean(request.getParameter("sex"));
        user.setSex(sex);

        if (!ignoreAdmin) {
            Boolean admin = Boolean.parseBoolean(request.getParameter("admin"));
            user.setAdmin(admin);
        }
        return user;
    }

    public User fill(User user, HttpServletRequest request) {
        return fill(user, request, false);
    }

    public void validate(HttpServletRequest request) {
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
