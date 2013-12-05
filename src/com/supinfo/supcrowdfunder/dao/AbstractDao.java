package com.supinfo.supcrowdfunder.dao;

import com.supinfo.supcrowdfunder.implementable.IEntity;

import javax.persistence.EntityManager;

/**
 * Author: Gaël Demette
 * Date: 20/11/13
 * Time: 15:23
 */
public abstract class AbstractDao {
    public static void persist(IEntity one) {
        EntityManager em = DaoRessource.getEm();
        try {
            em.getTransaction().begin();
            if (one.getId() == null || one.getId() < 1)
                em.persist(one);
            else
                em.merge(one);
            em.getTransaction().commit();
            em.clear();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
