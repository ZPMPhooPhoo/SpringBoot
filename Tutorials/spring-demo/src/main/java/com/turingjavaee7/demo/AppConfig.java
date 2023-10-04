package com.turingjavaee7.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.ApplicationScope;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.turingjavaee7.demo.model.ShoppingCart;
import com.turingjavaee7.demo.model.Store;
import com.turingjavaee7.demo.sevice.impl.ExampleBean;
import com.turingjavaee7.demo.sevice.impl.HelloMessageGenerator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class AppConfig {
	private static final Logger log = LoggerFactory.getLogger(SpringDemoApplication.class);
	@Bean
	public ExampleBean exampleBean()
	{
		log.info("Invoke via factory method");
		return new ExampleBean();
	}
	
	@Bean
	@RequestScope
	public HelloMessageGenerator requestScopedBean() {
		log.info("HelloMessageBean created");
		return new HelloMessageGenerator();
	}
	
	@Bean
	@SessionScope
	public ShoppingCart shoppingCart()
	{
		log.info("Shopping Cart created");
		return new ShoppingCart();
	}
	
	@Bean
	@ApplicationScope
	public HelloMessageGenerator appScopedBean() {
		log.info("Application Scope Bean created");
		return new HelloMessageGenerator();
	}
	
	@Bean
	public Store<String> stringStore()
	{
		log.info("String store is created");
		return new Store<String>();
	}
	
	@Bean
	public Store<Integer> integerStore()
	{
		log.info("Integer store is created");
		return new Store<Integer>();
	}
}
