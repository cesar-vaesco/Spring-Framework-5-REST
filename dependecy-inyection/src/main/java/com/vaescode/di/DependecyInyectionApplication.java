package com.vaescode.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;

import com.vaescode.di.autowired.AreaCalculadoraService;
import com.vaescode.di.scopes.EjemploScopeService;

@SpringBootApplication
public class DependecyInyectionApplication {

	private static final Logger log = LoggerFactory.getLogger(DependecyInyectionApplication.class);

	/*Para el ejemplo se usa la clase String
	 * 
	 * La clase String no se puede modificar, pero es posible agregarle contenido a través de 
	 * la anotación @Bean, en el caso del ejemplo se ha agregado un método
	 * */
	@Bean
	public String getApplication() {
		return ": VAESCODE";
	}
	

	
	public static void main(String[] args) {
		/*https://docs.spring.io/spring-framework/docs/3.0.x/reference/expressions.html*/
		ExpressionParser parser = new SpelExpressionParser();
		Expression expression = parser.parseExpression("20 <= 0"); 
		log.info("Result {}", expression.getValue());

	}

}
