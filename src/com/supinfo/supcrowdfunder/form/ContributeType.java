package com.supinfo.supcrowdfunder.form;

import com.supinfo.supcrowdfunder.dao.ContributeDao;
import com.supinfo.supcrowdfunder.entity.User;
import com.supinfo.supcrowdfunder.validator.ContributeValidator;

import javax.servlet.http.HttpServletRequest;



public class ContributeType extends AbstractType {

    public void persist(HttpServletRequest request) {

        try {
            ContributeDao.insertOne(Long.parseLong(request.getParameter("amount")),
                    ((User) request.getAttribute("currentUser")).getId(),
                    new java.sql.Date(System.currentTimeMillis()),
                    Long.parseLong(request.getParameter("projectId")));

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

//        try {
//            ContributeValidator.userId(((User) request.getAttribute("currentUser")).getId());
//        } catch (Exception e) {
//            errors.put("user", e.getMessage());
//        }

//        try {
//            ContributeValidator.rightNow(Date.valueOf(request.getParameter("rightNow")));
//        } catch (Exception e) {
//            errors.put("rightNow", e.getMessage());
//        }
        if (!errors.isEmpty())
            result = false;
    }

}

