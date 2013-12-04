package com.supinfo.supcrowdfunder.form;

import com.supinfo.supcrowdfunder.dao.CategorieDao;
import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.util.Convertion;
import com.supinfo.supcrowdfunder.validator.ProjectValidator;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Fireaxe
 * Date: 25/11/13
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class AddProjectType extends AbstractType {

    public void persist(HttpServletRequest request) {

        try {
            ProjectDao.insertOne(request.getParameter("name"),
                    request.getParameter("details"),
                    CategorieDao.findOne(Long.parseLong(request.getParameter("categories"))),
                    Long.parseLong(request.getParameter("needCredits")),
                    Convertion.conversionDate(request.getParameter("term")),
                    ((User) request.getAttribute("currentUser")).getId());
        } catch (Exception e) {
            errors.put("internal", e.getMessage());
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
            ProjectValidator.term(Convertion.conversionDate(request.getParameter("term")));
        } catch (IllegalArgumentException e) {
            errors.put("term", "validator.term.date.format");
        } catch (Exception e) {
            errors.put("term", e.getMessage());
        }
        if (!errors.isEmpty())
            result = false;
    }
}
