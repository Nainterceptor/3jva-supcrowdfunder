package com.supinfo.supcrowdfunder.form;

import com.supinfo.supcrowdfunder.dao.ContributeDao;
import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.validator.ContributeValidator;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;


public class ContributeType extends AbstractType {

    public void persist(HttpServletRequest request) {

        try {
            ContributeDao.insertOne(Long.parseLong(request.getParameter("amount")),
                    ((User) request.getAttribute("currentUser")).getId(),
                    new Timestamp(System.currentTimeMillis()),
                    Long.parseLong(request.getParameter("projectId")));

        } catch (Exception e) {
            errors.put("internal", e.getMessage());
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
            ContributeValidator.rightNow(new Timestamp(System.currentTimeMillis()), Long.parseLong(request.getParameter("projectId")));
        } catch (Exception e) {
            errors.put("rightNow", e.getMessage());
        }

        if (!errors.isEmpty())
            result = false;
    }

}

