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
        Short percentage;
        try {
            percentage = (short) ((num*100)/den);
        } catch (Exception e) {
            percentage = 0;
        }
        return percentage ;
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
                "(SELECT COUNT(u) FROM User u) as nbrUsers, \n" +
                "(SELECT COUNT(co) FROM Contribute co) as nbrContributes, \n" +
                "(SELECT COUNT(p) FROM Project p) as nbrProjects, \n" +
                "(SELECT COUNT(ca) FROM Categorie ca) as nbrCategories, \n" +
                "(SELECT SUM(co1.amount) FROM Contribute co1) as sumContributes, \n" +
                "(SELECT SUM(p1.needCredits) FROM Project p1) as sumNeeded \n" +
                ") FROM User";
        Query query = DaoRessource.getEm().createQuery(queryString, Map.class).setMaxResults(1);
        Map<String, Long> result = (Map<String, Long>) query.getSingleResult();
        return result;
    }
    public static Map<String, Long> findGlobalStatsFrom(Timestamp from) {
        String queryString = "SELECT new map(\n" +
                "(SELECT COUNT(u) FROM User u  WHERE u.createdAt >= :from) as nbrUsers, \n" +
                "(SELECT COUNT(co) FROM Contribute co WHERE co.rightNow >= :from) as nbrContributes, \n" +
                "(SELECT COUNT(p) FROM Project p WHERE p.term >= :from) as nbrProjects, \n" +
                "(SELECT COUNT(ca) FROM Categorie ca) as nbrCategories, \n" +
                "(SELECT SUM(co1.amount) FROM Contribute co1 WHERE co1.rightNow >= :from) as sumContributes, \n" +
                "(SELECT SUM(p1.needCredits) FROM Project p1 WHERE p1.term >= :from) as sumNeeded \n" +
                ") FROM User u";
        Query query = DaoRessource.getEm().createQuery(queryString, Map.class).setMaxResults(1).setParameter("from", from);
        Map<String, Long> result = (Map<String, Long>) query.getSingleResult();
        return result;
    }
    public static Map<String, Long> findGlobalStatsTo(Timestamp to) {
        String queryString = "SELECT new map(\n" +
                "(SELECT COUNT(u) FROM User u  WHERE u.createdAt <= :to) as nbrUsers, \n" +
                "(SELECT COUNT(co) FROM Contribute co WHERE co.rightNow <= :to) as nbrContributes, \n" +
                "(SELECT COUNT(p) FROM Project p WHERE p.term <= :to) as nbrProjects, \n" +
                "(SELECT COUNT(ca) FROM Categorie ca) as nbrCategories, \n" +
                "(SELECT SUM(co1.amount) FROM Contribute co1 WHERE co1.rightNow <= :to) as sumContributes, \n" +
                "(SELECT SUM(p1.needCredits) FROM Project p1 WHERE p1.term <= :to) as sumNeeded \n" +
                ") FROM User u";
        Query query = DaoRessource.getEm().createQuery(queryString, Map.class).setMaxResults(1).setParameter("to", to);
        Map<String, Long> result = (Map<String, Long>) query.getSingleResult();
        return result;
    }
    public static Map<String, Long> findGlobalStatsFromTo(Timestamp from, Timestamp to) {
        String queryString = "SELECT new map(\n" +
                "(SELECT COUNT(u) FROM User u  WHERE u.createdAt <= :to AND u.createdAt >= :from) as nbrUsers, \n" +
                "(SELECT COUNT(co) FROM Contribute co WHERE co.rightNow <= :to AND co.rightNow >= :from) as nbrContributes, \n" +
                "(SELECT COUNT(p) FROM Project p WHERE p.term <= :to AND p.term >= :from) as nbrProjects, \n" +
                "(SELECT COUNT(ca) FROM Categorie ca) as nbrCategories, \n" +
                "(SELECT SUM(co1.amount) FROM Contribute co1 WHERE co1.rightNow <= :to AND co1.rightNow >= :from) as sumContributes, \n" +
                "(SELECT SUM(p1.needCredits) FROM Project p1 WHERE p1.term <= :to AND p1.term >= :from) as sumNeeded \n" +
                ") FROM User u";
        Query query = DaoRessource.getEm().createQuery(queryString, Map.class)
                .setMaxResults(1)
                .setParameter("to", to)
                .setParameter("from", from);
        Map<String, Long> result = (Map<String, Long>) query.getSingleResult();
        return result;
    }
}
