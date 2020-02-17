package ioctest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {

	public static  void main(String[] args){
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext("ioctest");
		SimpleMovieLister simpleMovieLister=  applicationContext.getBean(SimpleMovieLister.class);
		System.out.println(simpleMovieLister);

	}
}
