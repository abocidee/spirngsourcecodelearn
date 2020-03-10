package com.alu.springtest;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class SpringApplication {

	public static void run() {
		Tomcat tomcat = new Tomcat();
		tomcat.setPort(8898);
		tomcat.addWebapp("/","/Users/abocide/Downloads/spring-framework-5.0.x/spring-mvc-tests/src/main/resources");
		try {
			tomcat.start();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
		tomcat.getServer().await();
	}
}
