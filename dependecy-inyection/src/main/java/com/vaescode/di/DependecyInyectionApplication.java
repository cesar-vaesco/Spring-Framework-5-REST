package com.vaescode.di;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.vaescode.di.atributo.Coche;
import com.vaescode.di.qualifiers.Animal;
import com.vaescode.di.qualifiers.Avion;
import com.vaescode.di.qualifiers.Pajaro;
import com.vaescode.di.qualifiers.Perro;

@SpringBootApplication
public class DependecyInyectionApplication {

	private static final Logger log = LoggerFactory.getLogger(DependecyInyectionApplication.class);

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(DependecyInyectionApplication.class, args);

		Perro perro = context.getBean(Perro.class);
		Pajaro pajaro = context.getBean(Pajaro.class);
		Avion avion = context.getBean(Avion.class);
		Animal animal = context.getBean("perrito",Animal.class);

		
		log.info("Objeto: {} ",perro.toString());
		log.info("Objeto pajaro: nombre: {}, edad: {}", pajaro.getNombre(), pajaro.getEdad());
		log.info("Objeto animal: nombre: {}, edad: {}", animal.getNombre(), animal.getEdad());
		
		
		avion.volar();

	}

}
