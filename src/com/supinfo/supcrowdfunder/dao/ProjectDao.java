package com.supinfo.supcrowdfunder.dao;

import com.supinfo.supcrowdfunder.entity.Categorie;
import com.supinfo.supcrowdfunder.entity.Project;
import com.supinfo.supcrowdfunder.util.Statistic;

import javax.persistence.Query;
import java.util.Date;
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
