package com.vaescode.di.autowired;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AreaCalculadoraService {

	private static final Logger log = LoggerFactory.getLogger(AreaCalculadoraService.class);

	@Autowired
	private List<Figure> figures;

	public double calcularAreas() {
		double area = 0;
		
		for (Figure figure : figures) {
			area += figure.calculadoraArea();
			log.info("Area: {}", area);

		}
		return area; 

		//return figures.stream().mapToDouble(f-> f.calculadoraArea()).sum();
	}
}
