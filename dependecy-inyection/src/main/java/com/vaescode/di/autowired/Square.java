package com.vaescode.di.autowired;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Square implements Figure {

	/*También es posible declarar una propiedad con un valor por default en caso de que el valor no 
	 * sea declarado en el archivo de configuración*/
	@Value("${square.side:5}")
	private double side;

	@Override
	public double calculadoraArea() {
		return side * side;
	}
}
