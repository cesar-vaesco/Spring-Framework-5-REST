package com.vaescode.di.oap;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class PointExample {

	//@Pointcut("execution(* com.vaescode.di.oap.TargetObject.*(..))")
	//@Pointcut("within(com.vaescode.di.oap.TargetObject*)")
	//DEntro del mismo paquete se peude declarar de la siguiente forma:
	//@Pointcut("within(TargetObject)")
	@Pointcut("@annotation(VaescodeAnotation)")
	public void targetObjectMethods() {}
}
