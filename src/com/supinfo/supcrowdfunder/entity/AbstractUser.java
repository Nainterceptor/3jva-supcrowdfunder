package com.supinfo.supcrowdfunder.entity;
import com.supinfo.supcrowdfunder.implementable.User;

/**
 * Author: Gaël Demette
 * Date: 19/11/13
 * Time: 15:54
 */
public class AbstractUser implements User {

    public boolean isEqualPassword(String password) {
        return false;
    }
}
