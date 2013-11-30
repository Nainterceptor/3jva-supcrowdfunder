package com.supinfo.supcrowdfunder.util;

/**
 * Created with IntelliJ IDEA.
 * User: Robin
 * Date: 29/11/13
 * Time: 17:19
 * To change this template use File | Settings | File Templates.
 */
public class Statistic {
    public static Short percentage (Long num, Long den){
        return (short) ((num*100)/den);
    }
}
