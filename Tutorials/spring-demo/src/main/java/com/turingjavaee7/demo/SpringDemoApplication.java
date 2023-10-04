package com.turingjavaee7.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.turingjavaee7.demo.model.ShoppingCart;
import com.turingjavaee7.demo.sevice.impl.ArithmeticServiceImpl;
import com.turingjavaee7.demo.sevice.impl.ExampleBean;
import com.turingjavaee7.demo.sevice.impl.HelloMessageGenerator;

@SpringBootApplication
public class SpringDemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDemoApplication.class, args);
	}
}
