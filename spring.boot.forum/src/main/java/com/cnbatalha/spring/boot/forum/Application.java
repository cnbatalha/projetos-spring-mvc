package com.cnbatalha.spring.boot.forum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

//@ConfigurationPropertiesScan(basePackageClasses = { Swagger2Configuration.class })

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
