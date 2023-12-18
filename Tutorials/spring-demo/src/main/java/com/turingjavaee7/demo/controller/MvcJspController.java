package com.turingjavaee7.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/jsp")
public class MvcJspController {
	@GetMapping
	String index()
	{
		return "hello.jsp";
	}
}
