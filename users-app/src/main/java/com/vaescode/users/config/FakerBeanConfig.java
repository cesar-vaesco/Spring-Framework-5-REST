package com.vaescode.users.config;

import org.springframework.context.annotation.Configuration;

import com.github.javafaker.Faker;

@Configuration
public class FakerBeanConfig {
	
	public Faker getFaker() {
		return new Faker();
	}
	
	/*
	 * Configurar FAker de esta forma permite poder instanciar beans de la
	 * clase Faker sin utilizar el operador new
	 * */

}
