package com.cnbatalha.spring.boot.forum;

import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Configuration {
	
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)		
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.cnbatalha.spring.boot.forum.controller"))
				.paths(PathSelectors.ant("/"))
				.build();
	}
	
}
