package com.pyramid.web.resource;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import com.pyramid.web.jx.controller.MainController;
import com.pyramid.web.jx.rest.CategorySService;
import com.pyramid.web.jx.rest.LoginSService;
@ApplicationPath("/mypath")
public class webApp extends Application {
	
    public Set<Class<?>> getClasses() {
        final Set<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(CategorySService.class);
        classes.add(LoginSService.class);
        classes.add(MainController.class);
        return classes;
    }

}
