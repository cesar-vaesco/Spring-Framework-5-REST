package com.vaescode.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.vaescode.di.scopes.EjemploScopeService;

@SpringBootApplication
public class DependecyInyectionApplication {

	private static final Logger log = LoggerFactory.getLogger(DependecyInyectionApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependecyInyectionApplication.class, args);

		EjemploScopeService ejemploScopeService = context.getBean(EjemploScopeService.class);
		EjemploScopeService ejemploScopeService2 = context.getBean(EjemploScopeService.class);

		log.info("Are bean.equal {} ",ejemploScopeService.equals(ejemploScopeService));
		log.info("Are bean ==  {} ",ejemploScopeService == (ejemploScopeService2));


	}

}
