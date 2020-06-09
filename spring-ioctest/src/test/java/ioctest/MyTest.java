package ioctest;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

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
}
