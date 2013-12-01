package com.supinfo.supcrowdfunder.dao;

import com.supinfo.supcrowdfunder.entity.Contribute;
import com.supinfo.supcrowdfunder.entity.Project;
import com.supinfo.supcrowdfunder.entity.User;

import javax.persistence.Query;
import java.sql.Timestamp;
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
        em.merge(oneContribute);
        em.getTransaction().commit();
        em.clear();
        destroy();
    }

    public static User userExist (Long userId){
        init();
        User result = em.find(User.class, userId);
        destroy();
        return result;
    }

    public static Project projectExist (Long projectId){
        init();
        Project result = em.find(Project.class, projectId);
        destroy();
        return result;
    }

    public static Contribute findOne(Long id) {
        init();
        Contribute contribute = em.find(Contribute.class, id);
        destroy();
        return contribute;
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
            insertOne(oneContribute);
        } catch (Exception e) {
            throw new Exception("Internal : Can't create project");
        }
    }

    public static void removeOne(Long id) {
        init();
        em.getTransaction().begin();
        em.createQuery("DELETE Contribute WHERE id = :contributeId")
                .setParameter("contributeId", id)
                .executeUpdate();
        em.getTransaction().commit();
        destroy();
    }

}

