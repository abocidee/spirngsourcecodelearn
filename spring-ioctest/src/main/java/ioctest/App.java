package ioctest;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Condition;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
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
	 * 改Class名,将class名改为首字母大写
	 */
	@Test
	public  void testInspector(){
	String name =	Introspector.decapitalize("LuNongYun");
		System.out.println(name);
	}

	@Test
	public void testGetBeanInfo(){
		try {
			BeanInfo beanInfo = Introspector.getBeanInfo(ConfigB.class);
			System.out.println(beanInfo);
		} catch (IntrospectionException e) {
			e.printStackTrace();
		}

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
