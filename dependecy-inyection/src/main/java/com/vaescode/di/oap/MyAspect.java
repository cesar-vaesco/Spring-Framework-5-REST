package com.vaescode.di.oap;

import java.lang.reflect.Modifier;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyAspect {

	private static final Logger log = LoggerFactory.getLogger(MyAspect.class);

	@Before("PointExample.targetObjectMethods()")
	public void before(JoinPoint joinPoint) {
		log.info("Method name: {}", joinPoint.getSignature().getName());
		log.info("Object type: {}", joinPoint.getSignature().getDeclaringType());
		log.info("Is public?: {}", Modifier.isPublic(joinPoint.getSignature().getModifiers()));		
		log.info("Modifiers: {}", joinPoint.getSignature().getModifiers());
		log.info("Arguments: {} ", joinPoint.getArgs());

		log.info("Before advice");
		
		log.info("El orden en que el aspecto se va a mostrar es según el orden declarado en la anotación Order donde 0 sera el de primer orden");
	}
	
	

}
