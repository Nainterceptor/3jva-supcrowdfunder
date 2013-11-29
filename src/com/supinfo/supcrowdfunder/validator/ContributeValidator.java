package com.supinfo.supcrowdfunder.validator;

import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: Robin
 * Date: 27/11/13
 * Time: 00:08
 * To change this template use File | Settings | File Templates.
 */

public class ContributeValidator {
    public static void amount(Long amount) throws Exception {
        if (amount == null)
            throw new Exception("validator.contribute.amount.empty");
    }

    public static void userId(Long userId) throws Exception {
        if (userId == null)
            throw new Exception("validator.contribute.userId.empty");
    }

    public static void projectId(Long projectId) throws Exception {
        if (projectId == null)
            throw new Exception("validator.contribute.projectId.empty");
    }

    public static void rightNow(Timestamp rightNow) throws Exception {
        if (rightNow == null)
            throw new Exception("validator.contribute.date.empty");
    }
}


