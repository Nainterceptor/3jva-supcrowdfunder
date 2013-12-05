package com.supinfo.supcrowdfunder.form;

import com.supinfo.supcrowdfunder.dao.ContributeDao;
import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.Contribute;
import com.supinfo.supcrowdfunder.entity.Project;
import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.util.Convertion;
import com.supinfo.supcrowdfunder.validator.ContributeValidator;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Robin
 * Date: 29/11/13
 * Time: 01:50
 * To change this template use File | Settings | File Templates.
 */
public class CreateContributeType extends ContributeType {
    public void persist(HttpServletRequest request) {
        try {
            ContributeDao.insertOne(Long.parseLong(request.getParameter("amount")),
                    Long.parseLong(request.getParameter("userId")),
                    Convertion.conversionDate(request.getParameter("rightNow")),
                    Long.parseLong(request.getParameter("projectId")));

        } catch (Exception e) {
            errors.put("internal", e.getMessage());
        }
    }

    public void merge(HttpServletRequest request) {
        Project project = ProjectDao.findProjectById(Long.parseLong(request.getParameter("projectId")));
        User user = UserDao.findOne(Long.parseLong((request.getParameter("userId"))));
        Contribute contribute = new Contribute()
                .setId(Long.parseLong(request.getParameter("id")))
                .setAmount(Long.parseLong(request.getParameter("amount")))
                .setUser(user)
                .setRightNow(Convertion.conversionDate(request.getParameter("rightNow")))
                .setProject(project);
        try {
            ContributeDao.persist(contribute);
        } catch (Exception e) {
            errors.put("internal", e.getMessage());
            result = false;
        }
    }

    public void validate(HttpServletRequest request) {

        try {
            Long.parseLong(request.getParameter("amount"));
            ContributeValidator.amount(Long.parseLong(request.getParameter("amount")));
        } catch (NumberFormatException e) {
            errors.put("amount", "validator.contribute.amount.empty");
        } catch (Exception e) {
            errors.put("amount", e.getMessage());
        }

        try {
            Long.parseLong(request.getParameter("userId"));
            ContributeValidator.userId(Long.parseLong(request.getParameter("userId")));
        } catch (NumberFormatException e) {
            errors.put("userId", "validator.contribute.userId.empty");
        } catch (Exception e) {
            errors.put("userId", e.getMessage());
        }

        try {
            Long.parseLong(request.getParameter("projectId"));
            ContributeValidator.projectId(Long.parseLong(request.getParameter("projectId")));
        } catch (NumberFormatException e) {
            errors.put("projectId", "validator.contribute.projectId.empty");
        } catch (Exception e) {
            errors.put("projectId", e.getMessage());
        }

        try {
            Convertion.conversionDate(request.getParameter("rightNow"));
            ContributeValidator.rightNow(Convertion.conversionDate(request.getParameter("rightNow")), Long.parseLong(request.getParameter("projectId")));
        } catch (IllegalArgumentException e) {
            errors.put("rightNow", "validator.contribute.date.format");
        } catch (Exception e) {
            errors.put("rightNow", e.getMessage());
        }

        if (!errors.isEmpty())
            result = false;
    }
}
