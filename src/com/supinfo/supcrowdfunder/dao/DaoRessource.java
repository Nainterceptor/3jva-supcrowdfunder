package com.supinfo.supcrowdfunder.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Author: Gaël Demette
 * Date: 03/12/13
 * Time: 22:13
 */
public final class DaoRessource {
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
    public static EntityManager getEm() {
        if (em == null)
            init();
        return em;
    }
}
