package com.supinfo.supcrowdfunder.form;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Gaël Demette
 * Date: 22/11/13
 * Time: 01:05
 */
public abstract class AbstractType {
    protected Boolean result = true;
    protected Map<String, String> errors = new HashMap<String, String>();

    public Map<String, String> getErrors() {
        return errors;
    }

    public Boolean getResult() {
        return result;
    }

    public abstract void validate(HttpServletRequest request) throws Exception;
}
