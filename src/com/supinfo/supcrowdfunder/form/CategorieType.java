package com.supinfo.supcrowdfunder.form;

import com.supinfo.supcrowdfunder.dao.CategorieDao;
import com.supinfo.supcrowdfunder.entity.Categorie;

import javax.servlet.http.HttpServletRequest;

/**
* Created with IntelliJ IDEA.
* User: RomainStudent
* Date: 27/11/13
* Time: 18:31
* To change this template use File | Settings | File Templates.
*/
public class CategorieType extends AbstractType {
    public void persist(Categorie categorie) {
        try {
            CategorieDao.persist(categorie);
        } catch (Exception e) {
            errors.put("internal", e.getMessage());
            result = false;
        }
    }

    public void validate(HttpServletRequest request) {



        if (!errors.isEmpty())
            result = false;
    }
}
