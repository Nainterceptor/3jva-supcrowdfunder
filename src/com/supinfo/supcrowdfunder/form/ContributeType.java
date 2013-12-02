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
            ContributeValidator.amount(Long.parseLong(request.getParameter("amount")));
        } catch (Exception e) {
            errors.put("amount", "validator.contribute.amount.empty");
        }

        if (!errors.isEmpty())
            result = false;
    }

}

