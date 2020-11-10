package com.vaescode.di.oap;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class PointExample {

	@Pointcut("execution(* com.vaescode.di.oap.TargetObject.*(..))")
	public void targetObjectMethods() {}
}
