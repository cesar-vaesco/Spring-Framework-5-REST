package com.vaescode.di.lifecycle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class VaescodeBeanPostProcessor implements BeanPostProcessor {

	private static final Logger log = LoggerFactory.getLogger(VaescodeBeanPostProcessor.class);

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		log.info("Antes de inicializar{}", beanName);

		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		log.info("Después de inicializar{}", beanName);
		return bean;
	}

}
