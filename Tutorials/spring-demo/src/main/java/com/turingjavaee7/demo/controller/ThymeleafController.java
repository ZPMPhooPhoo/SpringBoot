package com.turingjavaee7.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/view")
public class ThymeleafController {
	@RequestMapping
	String index(Model model)
	{
		log.info("thymeleaf index");
		model.addAttribute("message", "Message From Controller");
		return "view";
	}
}
