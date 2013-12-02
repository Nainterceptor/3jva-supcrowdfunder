package com.supinfo.supcrowdfunder.dao;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.HashMap;
import java.util.Map;

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

    public static Map<String, Long> findGlobalStats() {
        init();
        String queryString = "SELECT new map(\n" +
                "COUNT(u) as nbrUsers, \n" +
                "(SELECT COUNT(co) FROM Contribute co) as nbrContributes, \n" +
                "(SELECT COUNT(p) FROM Project p) as nbrProjects, \n" +
                "(SELECT COUNT(ca) FROM Categorie ca) as nbrCategories, \n" +
                "(SELECT SUM(co1.amount) FROM Contribute co1) as sumContributes \n" +
                ") FROM User u";
        Query query = em.createQuery(queryString, Map.class).setMaxResults(1);
        Map<String, Long> result = (Map<String, Long>) query.getSingleResult();
        destroy();
        return result;
    }
}
