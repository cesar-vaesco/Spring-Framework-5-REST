package com.vaescode.di.oap;

import java.lang.reflect.Modifier;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyAspect {

	private static final Logger log = LoggerFactory.getLogger(MyAspect.class);

	@Before("execution(* com.vaescode.di.oap.TargetObject.hello(..))")
	public void before(JoinPoint joinPoint) {
		log.info("Method name: {}", joinPoint.getSignature().getName());
		log.info("Object type: {}", joinPoint.getSignature().getDeclaringType());
		log.info("Is public?: {}", Modifier.isPublic(joinPoint.getSignature().getModifiers()));		
		log.info("Modifiers: {}", joinPoint.getSignature().getModifiers());
		/*En caso de verificar todos los métodos, os argumentos pasados va a pasar como vacios
		 * Para conocer los métodos en caso de un métod en especifico habra que espeficificar 
		 * en el argumento de @Before*/
		log.info("Arguments: {} ", joinPoint.getArgs());

		log.info("Before advice");
	}
}
