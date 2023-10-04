package com.turingjavaee7.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import com.turingjavaee7.demo.sevice.impl.ExampleBean;

import lombok.extern.slf4j.Slf4j;

@Slf4j
//@Component
public class InstantiationTracingBeanPostProcessor implements BeanPostProcessor {
	private static final Logger log = LoggerFactory.getLogger(InstantiationTracingBeanPostProcessor.class);

	// simply return the instantiated bean as-is
	public Object postProcessBeforeInitialization(Object bean, String beanName) {
		return bean; // we could potentially return any object reference here...
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) {
		log.info(">>Bean '" + beanName + "' created : " + bean.toString());
		return bean;
	}
}