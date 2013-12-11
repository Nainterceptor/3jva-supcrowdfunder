package com.supinfo.supcrowdfunder.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/api")
public class SupCrowdfunderApplication extends Application {
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<>();
        classes.add(CategoryResource.class);
        return classes;
    }
}