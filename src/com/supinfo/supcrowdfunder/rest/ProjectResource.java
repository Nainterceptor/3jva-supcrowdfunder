package com.supinfo.supcrowdfunder.rest;

import com.supinfo.supcrowdfunder.dao.*;
import com.supinfo.supcrowdfunder.entity.Categorie;
import com.supinfo.supcrowdfunder.entity.Project;
import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.util.Convertion;
import com.supinfo.supcrowdfunder.validator.CategorieValidator;
import com.supinfo.supcrowdfunder.validator.ContributeValidator;
import com.supinfo.supcrowdfunder.validator.ProjectValidator;
import com.supinfo.supcrowdfunder.validator.UserValidator;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GET @Path("/{id}/contributions") @Produces(MediaType.APPLICATION_JSON)
    public Long getContributed(@PathParam("id") Long id) {
        return StatisticDao.sumContributes(id);
    }

    @POST @Path("/{id}/contribute") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Map contribute(@FormParam("email") final String email, @FormParam("password") final String password, @PathParam("id") Long id, @FormParam("amount") final Long amount) {
        Map<String, Object> json = new HashMap<>();
        try {
            User currentUser = UserDao.findUserByMail(email);
            UserValidator.emailLogin(email, currentUser);
            UserValidator.passwordLogin(password, currentUser);
            ContributeValidator.amount(amount);
            ContributeValidator.projectId(id);
            ContributeDao.insertOne(amount, currentUser, id);
            json.put("newSum", StatisticDao.sumContributes(id));
        } catch (Exception e) {
            json.put("error", e.getMessage());
        }
        return json;
    }

    @POST @Path("/create") @Produces(MediaType.APPLICATION_JSON) @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public Map create(
        @FormParam("email") final String email,
        @FormParam("password") final String password,
        @FormParam("name") final String name,
        @FormParam("details") final String details,
        @FormParam("category") final Long categoryId,
        @FormParam("needCredits") final Long needCredits,
        @FormParam("term") final String termString
    ) {
        Map<String, Object> json = new HashMap<>();
        try {
            User currentUser = UserDao.findUserByMail(email);
            UserValidator.emailLogin(email, currentUser);
            UserValidator.passwordLogin(password, currentUser);
            ProjectValidator.name(name);
            ProjectValidator.details(details);
            Timestamp term = Convertion.conversionDate(termString);
            ProjectValidator.term(term);
            Categorie category = CategorieDao.findOne(categoryId);
            ProjectValidator.categories(category);
            ProjectDao.insertOne(name, details, category, needCredits, term, currentUser);
            json.put("error", false);
        } catch (Exception e) {
            json.put("error", e.getMessage());
        }
        return json;
    }
}
