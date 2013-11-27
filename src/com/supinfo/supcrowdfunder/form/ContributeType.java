package com.supinfo.supcrowdfunder.form;

import com.supinfo.supcrowdfunder.dao.ContributeDao;
import com.supinfo.supcrowdfunder.validator.ContributeValidator;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Robin
 * Date: 27/11/13
 * Time: 00:13
 * To change this template use File | Settings | File Templates.
 */
public class ContributeType extends AbstractType {

    public void persist(HttpServletRequest request) {

        try {
            ContributeDao.insertOne(Long.parseLong(request.getParameter("amount")),
                    request.getParameter("user"),
                    Date.valueOf(request.getParameter("rightNow")));
        } catch (Exception e) {
            errors.put("internal", e.getMessage());
        }
    }

    public void validate(HttpServletRequest request) {

        try {
            ContributeValidator.amount(Long.parseLong(request.getParameter("amount")));
        } catch (Exception e) {
            errors.put("amount", e.getMessage());
        }

        try {
            ContributeValidator.user(request.getParameter("user"));
        } catch (Exception e) {
            errors.put("user", e.getMessage());
        }

        try {
            ContributeValidator.rightNow(Date.valueOf(request.getParameter("rightNow")));
        } catch (Exception e) {
            errors.put("rightNow", e.getMessage());
        }
        if (!errors.isEmpty())
            result = false;
    }

}
