package com.vaescode.di.qualifiers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Perro extends Animal {

	public Perro(@Value("Rocky") String nombre, @Value("1") Integer edad) {
		super(nombre, edad);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Perro -> Nombre: " + getNombre() + ", Edad: " + getEdad() + " año";
	}

}
