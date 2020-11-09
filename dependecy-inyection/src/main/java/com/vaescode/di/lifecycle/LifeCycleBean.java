package com.vaescode.di.lifecycle;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Scope("prototype") -- @PreDestroy n se ejecuta para bean de ambito prototype
@Lazy
public class LifeCycleBean implements BeanNameAware, InitializingBean, DisposableBean {

	private static final Logger log = LoggerFactory.getLogger(LifeCycleBean.class);

	/*
	 * Se ejecuta durante la construcción del bean
	 */
	@Override
	public void setBeanName(String name) {
		log.info("Bean name aware {}", name);

	}

	// Se ejecutan después de la inyección de dependencias.
	@PostConstruct
	public void init() {
		log.info("Post construc");
	}

	// Se ejecutaran antes de que se destruya el bean
	// Estos métodos no se ejecutaran para beans prototype
	// Solo se ejecutan cuando se termina la virtual machine de forma normal
	@PreDestroy
	public void destroyBean() {
		log.info("Pre destroy");

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		log.info("After properties set method");

	}

	@Override
	public void destroy() throws Exception {
		log.info("Destroy method");

	}
}
