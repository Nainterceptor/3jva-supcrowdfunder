package com.supinfo.supcrowdfunder.dao;

import com.supinfo.supcrowdfunder.entity.Categorie;
import com.supinfo.supcrowdfunder.entity.Project;
import com.supinfo.supcrowdfunder.entity.User;

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
        init();

        Query query = em.createQuery("SELECT p FROM Project p");
        List<Project> projects = query.getResultList();

        destroy();
        return projects;
    }
    public static List<Project> getAll(Long category) {
        init();

        Query query = em.createQuery("SELECT p FROM Project p WHERE p.categories = :category")
                .setParameter("category", em.find(Categorie.class, category));
        List<Project> projects = query.getResultList();

        destroy();
        return projects;
    }

    public static User userExist (Long userId){
        init();
        User result = em.find(User.class, userId);
        destroy();
        return result;
    }


    public static Project findProjectById(Long id ) {
        init();

        Project result = em.find(Project.class, id);

        destroy();
        return result;
    }

    public static void insertOne(Project oneProject) {
        init();
        em.getTransaction().begin();
        em.merge(oneProject);
        em.getTransaction().commit();
        em.clear();
        destroy();
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
        init();
        em.getTransaction().begin();
        em.createQuery("DELETE Project WHERE id = :projectId")
                .setParameter("projectId", id)
                .executeUpdate();
        em.getTransaction().commit();
        destroy();
    }
}
