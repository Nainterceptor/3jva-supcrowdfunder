package com.supinfo.supcrowdfunder.validator;

import com.supinfo.supcrowdfunder.dao.UserDao;
import com.supinfo.supcrowdfunder.entity.Categorie;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Fireaxe
 * Date: 25/11/13
 * Time: 16:40
 * To change this template use File | Settings | File Templates.
 */
public class ProjectValidator {
    public static void name(String name) throws Exception {
        if (name == null || name.trim().length() == 0)
            throw new Exception("validator.project.name.empty");
        if (name.trim().length() > 150)
            throw new Exception("validator.project.name.tooLong");
    }

    public static void details(String details) throws Exception {
        if (details == null || details.trim().length() == 0)
            throw new Exception("validator.project.details.empty");
    }

    public static void categories(Categorie categories) throws Exception {
        if (categories == null)
            throw new Exception("validator.project.categorie.empty");
    }

    public static void needCredits(Long needCredits) throws Exception {
        if (needCredits == null || needCredits <=0)
            throw new Exception("validator.project.needCredits.empty");
    }

    public static void userId(Long userId) throws Exception {
        if (userId == null || UserDao.findOne(userId) == null)
            throw new Exception("validator.project.userId.empty");
    }

    public static void term(Timestamp term) throws Exception {
        if (term == null)
            throw new Exception("validator.project.date.empty");
        if (term.before(new Timestamp(System.currentTimeMillis()-60000)))
            throw new Exception("validator.project.date.late");
    }
}
