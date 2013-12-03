package com.supinfo.supcrowdfunder.dao;

import com.supinfo.supcrowdfunder.entity.Contribute;
import com.supinfo.supcrowdfunder.entity.Project;
import com.supinfo.supcrowdfunder.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.List;



public class ContributeDao extends AbstractDao {
    public static List<Contribute> getAll() {

        Query query = DaoRessource.getEm().createQuery("SELECT p FROM Contribute p");
        List<Contribute> contributes = query.getResultList();

        return contributes;
    }

    public static Contribute findOne(Long id) {
        return DaoRessource.getEm().find(Contribute.class, id);
    }

    public static void insertOne(Long amount, Long userId, Timestamp rightNow, Long projectId) throws Exception {

        Project project = ProjectDao.findProjectById(projectId);
        User user = UserDao.findOne(userId);
        try {
            Contribute oneContribute = new Contribute()
                    .setAmount(amount)
                    .setUser(user)
                    .setRightNow(rightNow)
                    .setProject(project);
            persist(oneContribute);
        } catch (Exception e) {
            throw new Exception("Internal : Can't create project");
        }
    }

    public static void removeOne(Long id) {
        EntityManager em = DaoRessource.getEm();
        em.getTransaction().begin();
        em.createQuery("DELETE Contribute WHERE id = :contributeId")
                .setParameter("contributeId", id)
                .executeUpdate();
        em.getTransaction().commit();
    }

}

