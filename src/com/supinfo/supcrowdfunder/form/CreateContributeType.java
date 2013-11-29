package com.supinfo.supcrowdfunder.form;

import com.supinfo.supcrowdfunder.dao.ContributeDao;
import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.util.Convertion;
import com.supinfo.supcrowdfunder.validator.ContributeValidator;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Robin
 * Date: 29/11/13
 * Time: 01:50
 * To change this template use File | Settings | File Templates.
 */
public class CreateContributeType extends ContributeType {
    protected Convertion convertion = new Convertion();
    public void persist(HttpServletRequest request) {
        try {
            ContributeDao.insertOne(Long.parseLong(request.getParameter("amount")),
                    Long.parseLong(request.getParameter("userId")),
                    convertion.conversionDate(request.getParameter("rightNow")),
                    Long.parseLong(request.getParameter("projectId")));

        } catch (Exception e) {
            errors.put("internal", e.getMessage());
        }
    }

    public void validate(HttpServletRequest request) {

        try {
            ContributeValidator.amount(Long.parseLong(request.getParameter("amount")));
        } catch (Exception e) {
            errors.put("amount", "validator.contribute.amount.fail");
        }

        try {
            ContributeValidator.userId(Long.parseLong(request.getParameter("userId")));
        } catch (Exception e) {
            errors.put("userId", e.getMessage());
        }

        try {
            ContributeValidator.projectId(Long.parseLong(request.getParameter("projectId")));
        } catch (Exception e) {
            errors.put("projectId", e.getMessage());
        }

        try {
            ContributeValidator.rightNow(convertion.conversionDate(request.getParameter("rightNow")));
        } catch (Exception e) {
            errors.put("rightNow", e.getMessage());
        }

        if (!errors.isEmpty())
            result = false;
    }
}
