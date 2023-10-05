package com.turingjavaee7.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.turingjavaee7.demo.model.Book;
import com.turingjavaee7.demo.sevice.BookService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/books")
public class BookController {
	private final Logger log = LoggerFactory.getLogger(BookController.class);
	@Autowired
	BookService bookService;
	
	@GetMapping
	String getAllBooks(Model model)
	{
		List<Book> books = this.bookService.getAllBooks();
		for(Book book : books)
		{
			log.info("Book "+book);
		}
		model.addAttribute("Book " +books);
		return "book";
	}
	
	@GetMapping("/{id}")
	String getBookById(@PathVariable String id)
	{
		Book book = this.bookService.getBookById(id);
		return "book";
	}
}
