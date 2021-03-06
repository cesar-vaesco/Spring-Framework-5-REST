package com.vaescode.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.vaescode.di.oap.TargetObject;

@SpringBootApplication
public class DependecyInyectionApplication {

	private static final Logger log = LoggerFactory.getLogger(DependecyInyectionApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependecyInyectionApplication.class, args);

		TargetObject object = context.getBean(TargetObject.class);

		object.hello("Hello world");
		object.foo();
	}
}
