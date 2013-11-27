package com.supinfo.supcrowdfunder.validator;

import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Robin
 * Date: 27/11/13
 * Time: 00:08
 * To change this template use File | Settings | File Templates.
 */

//Attention il faudra remplacer les validot.x.x et le rajouter dans le .properties

public class ContributeValidator {
    public static void amount(Long amount) throws Exception {
        if (amount == null)
            throw new Exception("validator.project.needCredits.empty");
    }


    public static void user(String user) throws Exception {
        if (user == null || user.trim().length() == 0)
            throw new Exception("validator.project.name.empty");
        if (user.trim().length() > 150)
            throw new Exception("validator.project.name.tooLong");
    }

    public static void rightNow(Date rightNow) throws Exception {
    }
}


