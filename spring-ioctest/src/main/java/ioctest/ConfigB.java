package ioctest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Import(ConfigA.class)
//src/main/java 为根目录
@PropertySource("classpath:/ioctest/app.properties")
public class ConfigB {
    @Value("${name}")
	private String name;
	@Bean
	public B b() {
		System.out.println(name);
		return new B();
	}
}