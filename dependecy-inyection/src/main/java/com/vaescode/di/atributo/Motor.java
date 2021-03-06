package com.vaescode.di.atributo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Motor {

	private String marca;

	private Integer modelo;

	public Motor() {
	}

	/**
	 * @param marca
	 * @param modelo
	
	public Motor(String marca, Integer modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}
	 */

	public String getMarca() {
		return marca;
	}

	@Value("XL1")
	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer setModelo() {
		return modelo;
	}

	@Value("1982")
	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Motor [marca: " + marca + ", modelo: " + modelo + "]";
	}

}
