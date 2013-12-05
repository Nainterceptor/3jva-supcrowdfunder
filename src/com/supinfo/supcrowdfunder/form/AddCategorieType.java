package com.supinfo.supcrowdfunder.form;

import com.supinfo.supcrowdfunder.dao.CategorieDao;
import com.supinfo.supcrowdfunder.entity.Categorie;
import com.supinfo.supcrowdfunder.validator.CategorieValidator;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: Romain Letrémy
 * Date: 25/11/13
 * Time: 15:26
 * To change this template use File | Settings | File Templates.
 */
public class AddCategorieType extends AbstractType {
    public void persist(HttpServletRequest request) {
        try {
            CategorieDao.insertOne(request.getParameter("name"));
        } catch (Exception e) {
            errors.put("internal", e.getMessage());
        }
    }

    public void persistEdit(Categorie categorie) {
        try {
            CategorieDao.persist(categorie);
        } catch (Exception e) {
            errors.put("internal", e.getMessage());
        }
    }

    public Categorie fill(Categorie categorie, HttpServletRequest request) {
        String name = request.getParameter("name");
        categorie.setName(name);
        return categorie;
    }

    public void validate(HttpServletRequest request) {
        try {
            CategorieValidator.name(request.getParameter("name"));
        } catch (Exception e) {
            errors.put("name", e.getMessage());
        }
        if (!errors.isEmpty())
            result = false;
    }
}
