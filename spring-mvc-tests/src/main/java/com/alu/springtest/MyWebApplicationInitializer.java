package com.alu.springtest;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;


import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;
import java.util.Set;

/**
 * 必需是web项目
 */
@HandlesTypes(A.class)
public class MyWebApplicationInitializer implements ServletContainerInitializer {




	@Override
	public void onStartup(Set<Class<?>> c, ServletContext ctx) throws ServletException {
		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext ac = new AnnotationConfigWebApplicationContext();
		ac.register(AppConfig.class);
		ac.refresh();
		System.out.println("onstartup");
		// Create and register the DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet(ac);
		ServletRegistration.Dynamic registration = ctx.addServlet("app", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/");

		for (Class<?> acls:c){
			System.out.println("----------------------------cs-");
			System.out.println(acls.getName());
		}
	}
}
