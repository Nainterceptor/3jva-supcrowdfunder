package com.supinfo.supcrowdfunder.dao;

import javax.persistence.Query;

/**
 * Created with IntelliJ IDEA.
 * User: Robin
 * Date: 01/12/13
 * Time: 20:31
 * To change this template use File | Settings | File Templates.
 */
public class StatisticDao extends AbstractDao {

    public static Short percentage (Long num, Long den){
        return (short) ((num*100)/den);
    }

    public static Long sumContributes(Long projectId){
        init();
        Query query = em.createQuery("SELECT SUM(c.amount) FROM Contribute c WHERE c.project.id = :projectId", Long.class)
                .setParameter("projectId", projectId);
        Long contributes = (Long) query.getSingleResult();
        if (contributes == null)
            contributes=0L;
        destroy();
        return contributes;
    }
}
