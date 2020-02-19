package ioctest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.beans.Introspector;

public class App {
	@Test
	public  void testAutowired(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ioctest");
		SimpleMovieLister simpleMovieLister=  applicationContext.getBean(SimpleMovieLister.class);
		System.out.println(simpleMovieLister);

	}

	@Test
	public  void testBeandefinition(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ioctest");
		MovieRecommender movieRecommender=  applicationContext.getBean(MovieRecommender.class);
		System.out.println(movieRecommender);

	}

	@Test
	public  void testQualifier(){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ioctest");
		MovieRecommender movieRecommender=  applicationContext.getBean(MovieRecommender.class);
		System.out.println(movieRecommender);

	}

	/**
	 * 改Class名
	 */
	@Test
	public  void testInspector(){
	String name =	Introspector.decapitalize("LuNongYun");

	}

	/**
	 * 改Class名
	 */
	@Test
	public  void testIRegister(){

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(MovieRecommender.class);
		ctx.register(MovieConfiguration.class);
		ctx.refresh();
		MovieRecommender myService = ctx.getBean(MovieRecommender.class);

	}

	@Test
	public  void testLifeCycle(){

		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.register(MovieRecommender.class);
		ctx.register(MovieConfiguration.class);
		ctx.refresh();
		MovieRecommender myService = ctx.getBean(MovieRecommender.class);

	}

	@Test
	public void testImport(){
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ConfigB.class);

		// now both beans A and B will be available...
		A a = ctx.getBean(A.class);
		B b = ctx.getBean(B.class);
	}
}
