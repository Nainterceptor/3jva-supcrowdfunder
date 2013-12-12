package com.supinfo.supcrowdfunder.rest;

import com.supinfo.supcrowdfunder.dao.CategorieDao;
import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.entity.Categorie;
import com.supinfo.supcrowdfunder.entity.Project;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Author: Gaël Demette
 * Date: 11/12/13
 * Time: 14:00
 */
@Path("/project")
public class ProjectResource {
    @GET @Path("/all") @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getProjects() {
        return ProjectDao.getAll();
    }

    @GET @Path("/category/{id}") @Produces(MediaType.APPLICATION_JSON)
    public List<Project> getProjectsByCategory(@PathParam("id") Long id) {
        return ProjectDao.getAll(id);
    }

    @GET @Path("/{id}") @Produces(MediaType.APPLICATION_JSON)
    public Project getCategory(@PathParam("id") Long id) {
        return ProjectDao.findProjectById(id);
    }
}
