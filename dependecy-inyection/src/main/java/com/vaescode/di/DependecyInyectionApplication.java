package com.vaescode.di;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.vaescode.di.atributo.Coche;
import com.vaescode.di.atributo.Motor;

@SpringBootApplication
public class DependecyInyectionApplication {

	public static void main(String[] args) {
		// SpringApplication.run(DependecyInyectionApplication.class, args);
		Motor motor = new Motor("XL1", 1981);

		Coche coche = new Coche("VW", 1986, motor);
		
		System.out.println(coche);
	}

}
