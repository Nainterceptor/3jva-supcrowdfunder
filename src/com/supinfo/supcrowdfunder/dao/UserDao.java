package com.supinfo.supcrowdfunder.dao;

import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.util.SecurityHelper;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.sql.Timestamp;
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
    public static void persist(User oneUser) {
        init();
        em.getTransaction().begin();
        if (oneUser.getId() != null)
            em.merge(oneUser);
        else {
            oneUser.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            em.persist(oneUser);
        }
        em.getTransaction().commit();
        em.clear();
        destroy();
    }
    public static void insertOne(String email, String password) throws Exception {

        String salt = SecurityHelper.generateSalt();
        try {
            String hashedPassword = SecurityHelper.hashPassword(password, salt);
            User oneUser = new User()
                    .setEmail(email)
                    .setPassword(hashedPassword)
                    .setSalt(salt);
            persist(oneUser);
        } catch (Exception e) {
            throw new Exception("Internal : Can't register user");
        }
    }
    public static void insertOne(String email, String password, String firstname, String lastname) throws Exception {

        String salt = SecurityHelper.generateSalt();
        try {
            String hashedPassword = SecurityHelper.hashPassword(password, salt);
            User oneUser = new User()
                    .setFirstname(firstname)
                    .setLastname(lastname)
                    .setEmail(email)
                    .setPassword(hashedPassword)
                    .setSalt(salt);
            persist(oneUser);
        } catch (Exception e) {
            throw new Exception("Internal : Can't register user");
        }
    }
    public static boolean isMailExist(String email) {
        init();
        Query query = em.createQuery("SELECT COUNT(u) as count FROM User u WHERE u.email = :email", Long.class)
            .setParameter("email", email);
        long result = (Long) query.getSingleResult();

        destroy();
        return result > 0;
    }
    public static User findUserByMail(String email) {
        init();

        Query query = em.createQuery("SELECT u FROM User u WHERE u.email = :email")
                .setParameter("email", email.toLowerCase());
        User result;
        try {
            result = (User) query.getSingleResult();
        } catch (NoResultException e) {
            result = null;
        }
        destroy();
        return result;
    }
    public static User findOne(Long id) {
        init();
        User user = em.find(User.class, id);
        destroy();
        return user;
    }
    public static void removeOne(Long id) {
        init();
        em.getTransaction().begin();
        em.createQuery("DELETE User WHERE id = :userId")
                .setParameter("userId", id)
                .executeUpdate();
        em.getTransaction().commit();
        destroy();
    }
}
