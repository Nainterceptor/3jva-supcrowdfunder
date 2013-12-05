package com.supinfo.supcrowdfunder.validator;

import com.supinfo.supcrowdfunder.dao.ProjectDao;
import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.Project;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Robin
 * Date: 27/11/13
 * Time: 00:08
 * To change this template use File | Settings | File Templates.
 */

public class ContributeValidator {
    public static void amount(Long amount) throws Exception {
        if (amount == null || amount <= 0)
            throw new Exception("validator.contribute.amount.empty");
    }

    public static void userId(Long userId) throws Exception {
        if (userId == null || UserDao.findOne(userId) == null)
            throw new Exception("validator.contribute.userId.empty");
    }

    public static void projectId(Long projectId) throws Exception {
        if (projectId == null || ProjectDao.findProjectById(projectId) == null)
            throw new Exception("validator.contribute.projectId.empty");
    }

    public static void rightNow(Timestamp rightNow, Long projectId) throws Exception {
        Project project = ProjectDao.findProjectById(projectId);
        if (rightNow == null || rightNow.after(project.getTerm()))
            throw new Exception("validator.contribute.date.late");
    }
}


