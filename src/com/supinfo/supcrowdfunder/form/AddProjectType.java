package com.supinfo.supcrowdfunder.form;

import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.validator.ProjectValidator;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

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
                    Long.parseLong(request.getParameter("needCredits")),
                    Date.valueOf(request.getParameter("term")));
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
            ProjectValidator.needCredits(Long.parseLong(request.getParameter("needCredits")));
        } catch (Exception e) {
            errors.put("needCredits", e.getMessage());
        }
        try {
            ProjectValidator.term(Date.valueOf(request.getParameter("term")));
        } catch (Exception e) {
            errors.put("term", e.getMessage());
        }
        if (!errors.isEmpty())
            result = false;
    }
}