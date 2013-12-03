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
            ContributeValidator.amount(Long.parseLong(request.getParameter("amount")));
        } catch (Exception e) {
            errors.put("amount", "validator.contribute.amount.empty");
        }

        try {
            ContributeValidator.userId(Long.parseLong(request.getParameter("userId")));
        } catch (Exception e) {
            errors.put("userId", "validator.contribute.userId.empty");
        }

        try {
            ContributeValidator.projectId(Long.parseLong(request.getParameter("projectId")));
        } catch (Exception e) {
            errors.put("projectId", "validator.contribute.projectId.empty");
        }

        try {
            ContributeValidator.rightNow(Convertion.conversionDate(request.getParameter("rightNow")));
        } catch (Exception e) {
            errors.put("rightNow", "validator.contribute.date.empty");
        }

        if (!errors.isEmpty())
            result = false;
    }
}
