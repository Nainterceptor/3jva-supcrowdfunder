package com.supinfo.supcrowdfunder.dao;

import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.util.SecurityHelper;

import javax.persistence.EntityManager;
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

        Query query = DaoRessource.getEm().createQuery("SELECT u FROM User u");
        List<User> users = query.getResultList();

        return users;
    }
    public static void persist(User oneUser) {
        if (oneUser.getId() == null || oneUser.getId() == 0)
            oneUser.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        AbstractDao.persist(oneUser);
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
    public static void insertOne(String email, String password, String firstname, String lastname, Boolean admin) throws Exception {

        String salt = SecurityHelper.generateSalt();
        try {
            String hashedPassword = SecurityHelper.hashPassword(password, salt);
            User oneUser = new User()
                    .setFirstname(firstname)
                    .setLastname(lastname)
                    .setEmail(email)
                    .setPassword(hashedPassword)
                    .setSalt(salt)
                    .setAdmin(admin);
            persist(oneUser);
        } catch (Exception e) {
            throw new Exception("Internal : Can't register user");
        }
    }
    public static boolean isMailExist(String email) {
        Query query = DaoRessource.getEm().createQuery("SELECT COUNT(u) as count FROM User u WHERE u.email = :email", Long.class)
            .setParameter("email", email);
        long result = (Long) query.getSingleResult();
        return result > 0;
    }
    public static boolean hasUser(){
        Query query = DaoRessource.getEm().createQuery("SELECT COUNT(u.id) FROM User u", Long.class);
        long result = (Long) query.getSingleResult();
        return result > 0;
    }
    public static User findUserByMail(String email) {

        Query query = DaoRessource.getEm().createQuery("SELECT u FROM User u WHERE u.email = :email")
                .setParameter("email", email.toLowerCase());
        User result;
        try {
            result = (User) query.getSingleResult();
        } catch (NoResultException e) {
            result = null;
        }
        return result;
    }
    public static User findOne(Long id) {
        return DaoRessource.getEm().find(User.class, id);
    }
    public static void removeOne(Long id) {
        EntityManager em = DaoRessource.getEm();
        em.getTransaction().begin();
        em.createQuery("DELETE User WHERE id = :userId")
                .setParameter("userId", id)
                .executeUpdate();
        em.getTransaction().commit();
    }
}
