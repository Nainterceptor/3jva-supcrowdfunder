package com.supinfo.supcrowdfunder.validator;

/**
 * Author: Gaël Demette
 * Date: 22/11/13
 * Time: 00:07
 */
public class UserValidator {
    public static void email(String email) throws Exception {
      //email can't be null, it's a Sting, obliviously.
      if (email.trim().length() == 0)
          throw new Exception("validator.user.mail.empty");
      if (!email.matches("[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,4}")) //TODO: fix that
          throw new Exception("validator.user.mail.notMatch");
    }
    public static void password(String password) throws Exception {
        if (password.trim().length() == 0)
                throw new Exception("validator.user.password.empty");
    }
}
