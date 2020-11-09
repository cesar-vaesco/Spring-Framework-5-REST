package com.vaescode.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import com.vaescode.di.lifecycle.ExplicitBean;
import com.vaescode.di.lifecycle.LifeCycleBean;

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
	
	@Bean(initMethod = "init", destroyMethod = "destroy")
	public ExplicitBean getBean() {
		return new ExplicitBean();
	}
	
	public static void main(String[] args) {
		ConfigurableApplicationContext context =  SpringApplication.run(DependecyInyectionApplication.class, args); 
		
		LifeCycleBean bean = context.getBean(LifeCycleBean.class);
		
	}

}
