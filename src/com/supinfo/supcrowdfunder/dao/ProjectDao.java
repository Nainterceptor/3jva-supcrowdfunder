package com.supinfo.supcrowdfunder.dao;

import com.supinfo.supcrowdfunder.entity.Categorie;
import com.supinfo.supcrowdfunder.entity.Project;
import com.supinfo.supcrowdfunder.entity.User;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Fireaxe
 * Date: 25/11/13
 * Time: 11:25
 * To change this template use File | Settings | File Templates.
 */
public class ProjectDao extends AbstractDao {
    public static List<Project> getAll() {
        init();

        Query query = em.createQuery("SELECT p FROM Project p");
        List<Project> projects = query.getResultList();

        destroy();
        return projects;
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

    public static void insertOne(String name, String details, Categorie categories, Long needCredits, Date term) throws Exception {

        try {
            Project oneProject = new Project()
                    .setName(name)
                    .setDetails(details)
                    .setCategories(categories)
                    .setNeedCredits(needCredits)
                    .setTerm(term);
            insertOne(oneProject);
        } catch (Exception e) {
            throw new Exception("Internal : Can't create project");
        }
    }
}
