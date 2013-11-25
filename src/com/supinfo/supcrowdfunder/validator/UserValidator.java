package com.supinfo.supcrowdfunder.validator;

import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.implementable.IUser;

/**
 * Author: Gaël Demette
 * Date: 22/11/13
 * Time: 00:07
 */
public class UserValidator {
    public static void email(String email) throws Exception {
        if (email == null || email.trim().length() == 0)
            throw new Exception("validator.user.mail.empty");
        if (!email.toLowerCase().matches("[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}"))
            throw new Exception("validator.user.mail.notMatch");
    }
    public static void password(String password) throws Exception {
        if (password == null || password.trim().length() == 0)
            throw new Exception("validator.user.password.empty");
    }
    public static void confirmpassword(String password, String confirm) throws Exception {
        if (confirm == null || password.trim().length() == 0)
            throw new Exception("validator.user.confirmPassword.empty");
        if (!confirm.equals(password))
            throw new Exception("validator.user.confirmPassword.notEquals");
    }
    public static void emailRegistration(String email) throws Exception {
        UserValidator.email(email);
        if (UserDao.isMailExist(email))
            throw new Exception("validator.user.mail.alreadyExist");
    }
    public static void emailLogin(String email, IUser user) throws Exception {
        UserValidator.email(email);
        if (user == null)
            throw new Exception("validator.user.mail.notExist");
    }
    public static void passwordLogin(String password, IUser user) throws Exception {
        UserValidator.password(password);
        if (user == null)
            throw new Exception("validator.user.password.notExist");
        if (!user.isEqualPassword(password))
            throw new Exception("validator.user.password.notMatch");
    }

    public static void firstname(String firstname) throws Exception {
        if (firstname == null || firstname.trim().length() == 0)
            throw new Exception("validator.user.firstname.empty");
        if (firstname.trim().length() > 255)
            throw new Exception("validator.user.firstname.tooLong");
    }
    public static void lastname(String lastname) throws Exception {
        if (lastname == null || lastname.trim().length() == 0)
            throw new Exception("validator.user.lastname.empty");
        if (lastname.trim().length() > 255)
            throw new Exception("validator.user.lastname.tooLong");
    }
}
