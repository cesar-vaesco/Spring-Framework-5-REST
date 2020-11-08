package com.vaescode.di.autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Square implements Figure {

	@Value("2.5")
	private double radius;

	@Override
	public double calculadoraArea() {

		return Math.PI * Math.pow(radius, 2);
	}

}
