package com.turingjavaee7.demo.sevice.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.turingjavaee7.demo.sevice.PrototypeService;

import lombok.extern.slf4j.Slf4j;

@Service
//@Scope("protoype")
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Slf4j
public class PrototypeBean implements PrototypeService{
	private static final Logger log = LoggerFactory.getLogger(PrototypeBean.class);
	public PrototypeBean()
	{
		log.info("Prototypebean created " + this);
	}
	
	public void api()
	{
		log.info("API called");
	}
}
