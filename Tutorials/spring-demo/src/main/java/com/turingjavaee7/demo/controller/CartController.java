package com.turingjavaee7.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.turingjavaee7.demo.model.ShoppingCart;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/shop")
public class CartController {
	private final Logger log = LoggerFactory.getLogger(CartController.class);
	@Autowired
	ShoppingCart shoppingCart;
	
	@GetMapping("/addToCart")
	public String getRequestScopeMessage(@RequestParam String item)
	{
		this.shoppingCart.addToCart(item);
		for(String it : this.shoppingCart.getItems())
		{
			log.info("Item > "+ it);
		}
		return "shoppingCart";
	}
}
