package ioctest;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class MyTest {
	/**
	 * 测试反射member 的使用
	 */
	@Test
	public void testMember(){
		System.out.println("hello");

	}

	/**
	 * 测试反射member 的使用
	 */
	@Test
	public void testBeanFactory(){
		BeanFactory beanFactory = new AnnotationConfigApplicationContext("ioctest");
		Object movieFinder = beanFactory.getBean("movieFinder");
		Class<?> type = beanFactory.getType("movieFinder");
		System.out.println(type);
		System.out.println("movie Finder address    "+movieFinder);


	}

	@Test
	public void testXml(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("services.xml");
		A bean = (A)applicationContext.getBean("pet");
		System.out.println(bean);
	}


	@Test
	public void testXml2(){
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("services.xml");
		B bean = (B)applicationContext.getBean("petStore2");
		System.out.println(bean);
	}

	/**
	 * 自己创建bean
	 */
	@Test
	public void testCreateBeanByUser(){
		ApplicationContext applicationContext = new GenericApplicationContext();
		ConfigurableListableBeanFactory beanFactory = ((GenericApplicationContext) applicationContext).getBeanFactory();
		beanFactory.registerSingleton("hello",new B());
		((GenericApplicationContext) applicationContext).refresh();//刷新配置

		System.out.println(applicationContext.getBean("hello"));

	}
}
