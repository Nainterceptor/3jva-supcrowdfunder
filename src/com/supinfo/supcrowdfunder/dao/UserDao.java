package com.supinfo.supcrowdfunder.dao;

import com.supinfo.supcrowdfunder.entity.User;

import javax.persistence.Query;
import java.util.List;

/**
 * Author: Gaël Demette
 * Date: 20/11/13
 * Time: 14:36
 */
public class UserDao extends AbstractDao {
    public static List<User> getAll() {
        init();

        Query query = em.createQuery("SELECT u FROM User u");
        List<User> users = query.getResultList();

        destroy();
        return users;
    }


}
