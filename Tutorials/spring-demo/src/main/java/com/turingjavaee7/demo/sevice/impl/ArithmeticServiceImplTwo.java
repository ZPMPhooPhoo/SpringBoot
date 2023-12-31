package com.turingjavaee7.demo.sevice.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.turingjavaee7.demo.sevice.ArithmeticService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@Qualifier("arithTwo")
public class ArithmeticServiceImplTwo implements ArithmeticService{
	private static final Logger log = LoggerFactory.getLogger(ArithmeticServiceImplTwo.class);
	ArithmeticServiceImplTwo()
	{
		log.info("Arithmetic Service Impl 2 Created");
	}
	@Override
	public int add(int a, int b) {
		log.info("Using Arithmetic Version 2");
		return a+b;
	}
}
