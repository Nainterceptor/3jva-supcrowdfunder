package com.supinfo.supcrowdfunder.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Author: Gaël Demette
 * Date: 20/11/13
 * Time: 15:23
 */
public abstract class AbstractDao {
    protected static EntityManagerFactory emf;
    protected static EntityManager em;
    public static void init() {
        emf = Persistence.createEntityManagerFactory("PU");
        em = emf.createEntityManager();
    }
    public static void destroy() {
        em.close();
        emf.close();
    }
}
