package com.vaescode.di.autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Figure{

	
	
	//@Value("${circle.radius:1}") También es posible declarar una propiedad con un valor por default 
	@Value("${circle.radius}")
	private double radius;

	@Override
	public double calculadoraArea() {

		return Math.PI * Math.pow(radius, 2);
	}

}
