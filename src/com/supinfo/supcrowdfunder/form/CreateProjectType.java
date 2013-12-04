package com.supinfo.supcrowdfunder.form;

import com.supinfo.supcrowdfunder.dao.CategorieDao;
import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.Project;
import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.util.Convertion;
import com.supinfo.supcrowdfunder.validator.ProjectValidator;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Robin
 * Date: 01/12/13
 * Time: 17:04
 * To change this template use File | Settings | File Templates.
 */
public class CreateProjectType extends AddProjectType{
    public void persist(HttpServletRequest request) {

        try {
            ProjectDao.insertOne(request.getParameter("name"),
                    request.getParameter("details"),
                    CategorieDao.findOne(Long.parseLong(request.getParameter("categories"))),
                    Long.parseLong(request.getParameter("needCredits")),
                    Convertion.conversionDate(request.getParameter("term")),
                    Long.parseLong(request.getParameter("userId")));
        } catch (Exception e) {
            errors.put("internal", e.getMessage());
        }
    }

    public void merge(HttpServletRequest request){
        User user = UserDao.findOne(Long.parseLong((request.getParameter("userId"))));;
        Project oneProject = new Project()
                .setId(Long.parseLong(request.getParameter("id")))
                .setName(request.getParameter("name"))
                .setDetails(request.getParameter("details"))
                .setCategories(CategorieDao.findOne(Long.parseLong(request.getParameter("categories"))))
                .setNeedCredits(Long.parseLong(request.getParameter("needCredits")))
                .setTerm(Convertion.conversionDate(request.getParameter("term")))
                .setUser(user);
        try {
            ProjectDao.persist(oneProject);
        } catch (Exception e) {
            errors.put("internal", e.getMessage());
            result = false;
        }
    }

    public void validate(HttpServletRequest request) {
        try {
            ProjectValidator.name(request.getParameter("name"));
        } catch (Exception e) {
            errors.put("name", e.getMessage());
        }
        try {
            ProjectValidator.details(request.getParameter("details"));
        } catch (Exception e) {
            errors.put("details", e.getMessage());
        }
        try {
            Long.parseLong(request.getParameter("categories"));
            ProjectValidator.categories(CategorieDao.findOne(Long.parseLong(request.getParameter("categories"))));
        } catch (NumberFormatException e) {
            errors.put("categories", "validator.project.categorie.empty");
        } catch (Exception e) {
            errors.put("categories", e.getMessage());
        }
        try {
            Long.parseLong(request.getParameter("needCredits"));
            ProjectValidator.needCredits(Long.parseLong(request.getParameter("needCredits")));
        } catch (NumberFormatException e) {
            errors.put("needCredits", "validator.project.needCredits.empty");
        } catch (Exception e) {
            errors.put("needCredits", e.getMessage());
        }
        try {
            Convertion.conversionDate(request.getParameter("term"));
        } catch (IllegalArgumentException e) {
            errors.put("term", "validator.term.date.format");
        }
        try {
            Long.parseLong(request.getParameter("userId"));
            ProjectValidator.userId(Long.parseLong(request.getParameter("userId")));
        } catch (NumberFormatException e) {
            errors.put("userId", "validator.project.userId.empty");
        } catch (Exception e) {
            errors.put("userId", e.getMessage());
        }
        if (!errors.isEmpty())
            result = false;
    }
}
