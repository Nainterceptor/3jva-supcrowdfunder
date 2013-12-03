package com.supinfo.supcrowdfunder.dao;

import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.Map;

/**
 * User: Robin
 * Date: 01/12/13
 * Time: 20:31
 */
public class StatisticDao extends AbstractDao {

    public static Short percentage (Long num, Long den){
        return (short) ((num*100)/den);
    }

    public static Long sumContributes(Long projectId){
        Query query = DaoRessource.getEm().createQuery("SELECT SUM(c.amount) FROM Contribute c WHERE c.project.id = :projectId", Long.class)
                .setParameter("projectId", projectId);
        Long contributes = (Long) query.getSingleResult();
        if (contributes == null)
            contributes=0L;
        return contributes;
    }

    public static Map<String, Long> findGlobalStats() {
        String queryString = "SELECT new map(\n" +
                "COUNT(u) as nbrUsers, \n" +
                "(SELECT COUNT(co) FROM Contribute co) as nbrContributes, \n" +
                "(SELECT COUNT(p) FROM Project p) as nbrProjects, \n" +
                "(SELECT COUNT(ca) FROM Categorie ca) as nbrCategories, \n" +
                "(SELECT SUM(co1.amount) FROM Contribute co1) as sumContributes, \n" +
                "(SELECT SUM(p1.needCredits) FROM Project p1) as sumNeeded \n" +
                ") FROM User u";
        Query query = DaoRessource.getEm().createQuery(queryString, Map.class).setMaxResults(1);
        Map<String, Long> result = (Map<String, Long>) query.getSingleResult();
        return result;
    }
    public static Map<String, Long> findGlobalStatsFrom(Timestamp from) {
        String queryString = "SELECT new map(\n" +
                "COUNT(u) as nbrUsers, \n" +
                "(SELECT COUNT(co) FROM Contribute co) as nbrContributes, \n" +
                "(SELECT COUNT(p) FROM Project p) as nbrProjects, \n" +
                "(SELECT COUNT(ca) FROM Categorie ca) as nbrCategories, \n" +
                "(SELECT SUM(co1.amount) FROM Contribute co1) as sumContributes, \n" +
                "(SELECT SUM(p1.needCredits) FROM Project p1 WHERE p1.foo >= :from) as sumNeeded \n" +
                ") FROM User u\n" +
                " WHERE u.createdAt >= :from";
        Query query = DaoRessource.getEm().createQuery(queryString, Map.class).setMaxResults(1);
        Map<String, Long> result = (Map<String, Long>) query.getSingleResult();
        return result;
    }
    public static Map<String, Long> findGlobalStatsTo(Timestamp to) {
        String queryString = "SELECT new map(\n" +
                "COUNT(u) as nbrUsers, \n" +
                "(SELECT COUNT(co) FROM Contribute co) as nbrContributes, \n" +
                "(SELECT COUNT(p) FROM Project p) as nbrProjects, \n" +
                "(SELECT COUNT(ca) FROM Categorie ca) as nbrCategories, \n" +
                "(SELECT SUM(co1.amount) FROM Contribute co1) as sumContributes, \n" +
                "(SELECT SUM(p1.needCredits) FROM Project p1) as sumNeeded \n" +
                ") FROM User u\n";
        Query query = DaoRessource.getEm().createQuery(queryString, Map.class).setMaxResults(1);
        Map<String, Long> result = (Map<String, Long>) query.getSingleResult();
        return result;
    }
    public static Map<String, Long> findGlobalStatsFromTo(Timestamp from, Timestamp to) {
        String queryString = "SELECT new map(\n" +
                "COUNT(u) as nbrUsers, \n" +
                "(SELECT COUNT(co) FROM Contribute co) as nbrContributes, \n" +
                "(SELECT COUNT(p) FROM Project p) as nbrProjects, \n" +
                "(SELECT COUNT(ca) FROM Categorie ca) as nbrCategories, \n" +
                "(SELECT SUM(co1.amount) FROM Contribute co1) as sumContributes, \n" +
                "(SELECT SUM(p1.needCredits) FROM Project p1) as sumNeeded \n" +
                ") FROM User u\n";
        Query query = DaoRessource.getEm().createQuery(queryString, Map.class).setMaxResults(1);
        Map<String, Long> result = (Map<String, Long>) query.getSingleResult();
        return result;
    }
}
