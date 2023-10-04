package com.egon.guide;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.egon.guide")
@EntityScan(basePackages = "com.egon.guide")
@ComponentScan(basePackages = "com.egon.guide")
public class GuideApplication {

	public static void main(String[] args) {
		SpringApplication.run(GuideApplication.class, args);
	}

}
