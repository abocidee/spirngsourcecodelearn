package ioctest;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MovieConfiguration {

	@Bean
	@Qualifier(value = "action")
	public MovieCatalog firstMovieCatalog( ) { return new MovieCatalog(); }

	@Bean()
	@Qualifier(value = "comedy")
	public MovieCatalog secondMovieCatalog() { return new MovieCatalog(); }

	// ...
	@Bean(initMethod = "init")
	public BeanOne beanOne() {
		return new BeanOne();
	}

	@Bean(destroyMethod = "cleanup")
	public BeanTwo beanTwo() {
		return new BeanTwo();
	}
}