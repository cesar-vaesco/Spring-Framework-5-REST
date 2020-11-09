package com.vaescode.di.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExplicitBean {

private static final Logger log = LoggerFactory.getLogger(ExplicitBean.class);

	// Se ejecutan después de la inyección de dependencias.
	public void init() {
		log.info("Init method");
	}

	//Se ejecutaran antes de que se destruya el bean
	//Estos métodos no se ejecutaran para beans prototype
	public void destroy() {
		log.info("Destroy method");
	}
	
}
