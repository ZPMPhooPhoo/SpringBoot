package com.turingjavaee7.demo.sevice.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExampleBean {
	/*public is important, show is not visible error */
	private static final Logger log = LoggerFactory.getLogger(ExampleBean.class);
	public ExampleBean()
	{
		log.info("Example Bean Created");
	}
	
	@PostConstruct
	public void init()
	{
		log.info("INIT Example Bean");
	}
	
	@PreDestroy
	public void destroy()
	{
		log.info("Predestroy Example Bean");
	}
	
	public void api()
	{
		log.info("API method from example bean");
	}
}
