package com.vaescode.di.oap;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	private static final Logger log = LoggerFactory.getLogger(MyAspect.class);

	//Se indica en la anotación before que todos los métodos de la clase TargetObject van a ser intervenidos
	//sin importar el parametro que reciban
	//Si se quiere solamente ejecutar el aspecto en un método especifico se declararía de la siguiente forma
	//@Before("execution(* com.vaescode.di.oap.TargetObject.nombreDelMetodo(..))")
	//@Before("execution(* com.vaescode.di.oap.TargetObject.*(..))")
	@Before("execution(* com.vaescode.di.oap.TargetObject.foo(..))")
	public void before() {
		log.info("Before advice");
	}
}
