package com.turingjavaee7.demo.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turingjavaee7.demo.dao.BookDao;
import com.turingjavaee7.demo.model.Book;
import com.turingjavaee7.demo.sevice.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDao bookDao;
	@Override
	public List<Book> getAllBooks() {
		return this.bookDao.getAllBooks();
	}

	@Override
	public Book getBookById(String id) {
		return this.bookDao.getBookById(id);
	}
	
}