package com.vaescode.di.autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Figure{

	@Value("2.5")
	private double side;
	
	@Override
	public double calculadoraArea() {
		return side * side;
	}

}
