package com.supinfo.supcrowdfunder.dao;

import com.supinfo.supcrowdfunder.entity.Contribute;
import com.supinfo.supcrowdfunder.entity.Project;

import javax.persistence.Query;
import java.util.List;



public class ContributeDao extends AbstractDao {
    public static List<Contribute> getAll() {
        init();

        Query query = em.createQuery("SELECT p FROM Contribute p");
        List<Contribute> contributes = query.getResultList();

        destroy();
        return contributes;
    }

    public static void insertOne(Contribute oneContribute) {
        init();
        em.getTransaction().begin();
        em.persist(oneContribute);
        em.getTransaction().commit();
        em.clear();
        destroy();
    }

    public static Long sumContributes(Long projectId){
        init();
        Query query = em.createQuery("SELECT SUM(c.amount) FROM Contribute c WHERE c.project = :projectId", Long.class)
                .setParameter("projectId", projectId);
        Long contributes = (Long) query.getSingleResult();

        destroy();
        return contributes;
    }

    public static void insertOne(Long amount, Long userId, java.sql.Date rightNow, Long projectId) throws Exception {

        Project project = ProjectDao.findProjectById(projectId);
        try {
            Contribute oneContribute = new Contribute()
                    .setAmount(amount)
                    .setUserId(userId)
                    .setRightNow(rightNow)
                    .setProject(project);
            insertOne(oneContribute);
        } catch (Exception e) {
            throw new Exception("Internal : Can't create project");
        }
    }

}

