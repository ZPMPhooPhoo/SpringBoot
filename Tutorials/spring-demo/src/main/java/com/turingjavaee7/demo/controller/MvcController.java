package com.turingjavaee7.demo.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.turingjavaee7.demo.model.Book;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/mvc")
public class MvcController {
	private final Logger log = LoggerFactory.getLogger(MvcController.class);
	@GetMapping("/hello")
	String hello(Model model)
	{
		log.info("Get Mapping Hello");
		model.addAttribute("message", "Hello From Spring Message");
		return "hello";
	}
	
	@PostMapping("/hello")
	String PostHello(Model model)
	{
		log.info("Post Mapping Hello");
		model.addAttribute("message", "Hello From Spring Message");
		return "hello";
	}
	
	@GetMapping("/books/{id}")
	String booksById(Model model,@PathVariable String id)
	{
		model.addAttribute("message", "Book id "+id);
		return "hello";
	}
	
	@GetMapping("/books/search")
	String bookSearch(Model model, @RequestParam(name="title", required=false, defaultValue="") String title)
	{
		log.info("book search title="+ title);
		model.addAttribute("message", "Book Title "+title);
		return "hello";
	}
	
	@GetMapping("/books/session")
	String session(HttpSession session, 
			Principal user,
			@CookieValue("JSESSIONID") String sessionId,
			@RequestHeader("Accept-Encoding") String encoding)
	{
		log.info("sessionid " + sessionId);
		log.info("Authenticated user " + user);
		session.setAttribute("message", "Put by session");
		return "hello";
	}
	
	@GetMapping("/books/getSession")
	String getSession(Model model,
			@SessionAttribute String message,
			HttpSession session)
	{
		log.info("session attribute " + message);
		model.addAttribute("message", session.getAttribute("message"));
		return "hello";
	}
	
	@GetMapping("/books/api/1")
	@ResponseBody
	Book getBook()
	{
		return new Book(1L, "title-1", "author-1");
	}
	
	@GetMapping("/books/api2")
	ResponseEntity<Book> getBook2()
	{
		return ResponseEntity.ok(new Book(2L, "title-2", "author-2"));
	}
	
	@GetMapping("/books/request")
	String servletRequest(HttpServletRequest servletRequest, HttpServletResponse servletResponse)
	{
		Enumeration<String> headers = servletRequest.getHeaderNames();
		Iterator<String> iterator = headers.asIterator();
		while(iterator.hasNext())
		{
			String header = iterator.next();
			log.info("Header "+header + "=> "+servletRequest.getHeader(header));
		}
		log.info("Path " + servletRequest.getRequestURI()); 
		servletResponse.setContentType("application/text");
		servletResponse.addHeader("Authorization", "Key");
		try {
			servletResponse.getOutputStream().write("Hello World".getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "hello";
	}
}
