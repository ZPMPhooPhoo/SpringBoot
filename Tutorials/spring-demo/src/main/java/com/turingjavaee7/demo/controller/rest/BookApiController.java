package com.turingjavaee7.demo.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.turingjavaee7.demo.controller.rest.error.ApiErrorResponse;
import com.turingjavaee7.demo.model.Book;
import com.turingjavaee7.demo.sevice.BookService;
import com.turingjavaee7.demo.sevice.exception.BusinessLogicException;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

//@Slf4j
//@Controller
//@RequestMapping("/api/books")
//public class BookApiController {
//
//	@Autowired
//	BookService bookService;
//	
//	@GetMapping
//	@ResponseBody List<Book> getAllBook()
//	{
//		return this.bookService.getAllBook();
//	}
//}


@Slf4j
@RestController
@RequestMapping("/api/books")
public class BookApiController {

	@Autowired
	BookService bookService;
	
	@GetMapping
	List<Book> getAllBook()
	{
		log.info("GET /api/books");
		return this.bookService.getAllBook();
	}
	
	@GetMapping("/{bookId}")
	//Book getBookById(@PathVariable String bookId)
	ResponseEntity<Object> getBookById(@PathVariable Long bookId)
	{
		log.info("GET /api/books/"+bookId);
		Book book = null;
		try {
			book = this.bookService.getBookById(bookId);
			return ResponseEntity.ok(book);
			
		} catch (Exception e) {
			log.error("getBookById "+e.getMessage());
			ApiErrorResponse error = new ApiErrorResponse("1001","No such book with bookId "+ bookId);
			return ResponseEntity.badRequest().body(error);
		}
//		return book;
	}
	
	@PostMapping
	ResponseEntity<Object> saveBook(@RequestBody @Valid Book book, BindingResult result)
	{
		log.info("POST saveBook"+book);
		if(result.hasErrors())
		{
			log.info("Validation Error in creating book "+result);
			return ResponseEntity.badRequest()
					.body(result.getAllErrors());
		}
		else {
			Book savedBook = bookService.saveBook(book);
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(savedBook);
		}
	}
	
	@PutMapping("/{bookId}")
	ResponseEntity<Object> updateBook(@PathVariable String bookId, @RequestBody @Valid Book book, BindingResult result)
	{
		log.info("Put updateBook id "+bookId+"	"+book);
		if(result.hasErrors())
		{
			log.info("Validation Error in updating book "+result);
			return ResponseEntity.badRequest()
					.body(result.getAllErrors());
		}
		else
		{
			Book updateBook = bookService.updateBook(book);
			return ResponseEntity.ok().body(updateBook);
		}
	}
	
	@DeleteMapping("/{bookId}")
	ResponseEntity<Object> deleteBook(@PathVariable Long bookId)
	{
		log.info("Delete book id "+bookId+"  ");
		Book deletedBook;
		try {
			deletedBook = bookService.deleteBookById(bookId);
			return ResponseEntity.ok().body(deletedBook);
		} catch (BusinessLogicException e) {
			
			return ResponseEntity.badRequest().body(e);
		}
	}
}
