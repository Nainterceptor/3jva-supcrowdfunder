package com.supinfo.supcrowdfunder.dao;

import com.supinfo.supcrowdfunder.entity.Categorie;
import com.supinfo.supcrowdfunder.entity.Project;
import com.supinfo.supcrowdfunder.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.Timestamp;
import java.util.List;

/**
 * User: Fireaxe
 * Date: 25/11/13
 * Time: 11:25
 */
public class ProjectDao extends AbstractDao {
    public static List<Project> getAll() {

        Query query = DaoRessource.getEm().createQuery("SELECT p FROM Project p");
        List<Project> projects = query.getResultList();

        return projects;
    }
    public static List<Project> getAll(Long category) {
        EntityManager em = DaoRessource.getEm();
        Query query = em.createQuery("SELECT p FROM Project p WHERE p.categories = :category")
                .setParameter("category", em.find(Categorie.class, category));
        List<Project> projects = query.getResultList();

        return projects;
    }

    public static Project findProjectById(Long id ) {
        return DaoRessource.getEm().find(Project.class, id);
    }

    public static void insertOne(Project oneProject) {
        EntityManager em = DaoRessource.getEm();
        em.getTransaction().begin();
        em.merge(oneProject);
        em.getTransaction().commit();
        em.clear();
    }

    public static void insertOne(String name, String details, Categorie categories, Long needCredits, Timestamp term, Long userId) throws Exception {
        User user = UserDao.findOne(userId);
        try {
            Project oneProject = new Project()
                    .setName(name)
                    .setDetails(details)
                    .setCategories(categories)
                    .setNeedCredits(needCredits)
                    .setTerm(term)
                    .setUser(user);
            insertOne(oneProject);
        } catch (Exception e) {
            throw new Exception("Internal : Can't create project");
        }
    }
    public static void removeOne(Long id) {
        EntityManager em = DaoRessource.getEm();
        em.getTransaction().begin();
        em.createQuery("DELETE Project WHERE id = :projectId")
                .setParameter("projectId", id)
                .executeUpdate();
        em.getTransaction().commit();
    }
}
