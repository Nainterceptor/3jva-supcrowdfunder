package com.supinfo.supcrowdfunder.validator;

import com.supinfo.supcrowdfunder.dao.CategorieDao;

/**
 * Created with IntelliJ IDEA.
 * User: Romain Letrémy
 * Date: 25/11/13
 * Time: 16:47
 * To change this template use File | Settings | File Templates.
 */
public class CategorieValidator {
    public static void name(String name) throws Exception {
        if (name == null || name.trim().length() == 0)
            throw new Exception("validator.categorie.name.empty");
        if (CategorieDao.isNameExist(name))
            throw new Exception("validator.categorie.name.alreadyExist");
    }
}
