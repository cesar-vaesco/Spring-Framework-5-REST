package com.vaescode.di.lifecycle.lazy;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class BeanB {

	//El bean  "b" carga el bean "a" aunque este tenga carga perezosa "lazy"
	//(Se carga hasta que se crea una instancia de este) 
	//Ambos beans se cargan como eager(lazy = false)
	@Autowired
	private BeanA bean;

	private static final Logger log = LoggerFactory.getLogger(BeanB.class);

	@PostConstruct
	public void init() {
		log.info("Init bean b");

	}
}
