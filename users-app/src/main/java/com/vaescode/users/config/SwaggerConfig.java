/**
 * 
 */
package com.vaescode.users.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author thece
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
	return new Docket(DocumentationType.SWAGGER_2)
			.apiInfo(getApiInfo())
	.select().apis(RequestHandlerSelectors.basePackage("com.vaescode.users.controllers"))
	.paths(PathSelectors.any()).build();
	}

	private ApiInfo getApiInfo() {
		// TODO Auto-generated method stub
		return new ApiInfoBuilder()
				.title("Vaescode Api")
				.version("1.0")
				.license("Apache 2.0")
				.contact(new Contact("@vargas_dev", "https://twitter.com/vargas_dev", "cesarvargasescorcia@gmail.com"))
				.build();
	}

}
