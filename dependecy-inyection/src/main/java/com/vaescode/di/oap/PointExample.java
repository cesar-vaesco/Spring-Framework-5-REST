package com.vaescode.di.oap;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class PointExample {

	//@Pointcut("execution(* com.vaescode.di.oap.TargetObject.*(..))")
	@Pointcut("within(com.vaescode.di.oap.*)")
	public void targetObjectMethods() {}
}
