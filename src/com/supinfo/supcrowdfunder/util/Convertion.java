package com.supinfo.supcrowdfunder.util;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Robin
 * Date: 29/11/13
 * Time: 03:40
 * To change this template use File | Settings | File Templates.
 */
public class Convertion {
    protected String dateformat;
    protected Date hours = new Date(System.currentTimeMillis());;
    public Timestamp conversionDate (String date){

        dateformat=date+" "+hours.toString().substring(hours.toString().indexOf(":")-2,hours.toString().lastIndexOf(":")+3);
        return Timestamp.valueOf(dateformat);

    }
}
