package com.turingjavaee7.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.turingjavaee7.demo.model.ShoppingCart;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/restapi")
public class ApiController {
	
	@GetMapping
	ShoppingCart getShoppingCart()
	{
		log.info("API Controller");
		ShoppingCart cart = new ShoppingCart();
		cart.addToCart("Item One");
		cart.addToCart("Item Two");
		return cart;
	}
}
