package com.supinfo.supcrowdfunder.dao;

import com.supinfo.supcrowdfunder.entity.Project;

import javax.persistence.Query;
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
}
