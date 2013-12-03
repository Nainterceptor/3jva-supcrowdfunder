package com.supinfo.supcrowdfunder.dao;

import javax.persistence.EntityManager;

/**
 * Author: Gaël Demette
 * Date: 20/11/13
 * Time: 15:23
 */
public abstract class AbstractDao {
    public static <T> void persist(T one) {
        EntityManager em = DaoRessource.getEm();
        try {
            em.getTransaction().begin();
            em.persist(one);
            em.getTransaction().commit();
            em.clear();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
