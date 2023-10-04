package com.turingjavaee7.demo.sevice.impl;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.turingjavaee7.demo.controller.HomeController;
import com.turingjavaee7.demo.sevice.ArithmeticService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Primary
public class ArithmeticServiceImpl implements ArithmeticService{
	private static final Logger log = LoggerFactory.getLogger(ArithmeticServiceImpl.class);
	
	public ArithmeticServiceImpl() {
		log.info("Arithmetic Service Impl Created");
	}
	
	@Override
	public int add(int a, int b) {
		return a+b;
	}
}
