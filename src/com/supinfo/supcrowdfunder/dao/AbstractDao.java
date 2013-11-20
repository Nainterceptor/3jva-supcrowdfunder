package com.supinfo.supcrowdfunder.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created with IntelliJ IDEA.
 * User: nainterceptor
 * Date: 20/11/13
 * Time: 15:23
 * To change this template use File | Settings | File Templates.
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
