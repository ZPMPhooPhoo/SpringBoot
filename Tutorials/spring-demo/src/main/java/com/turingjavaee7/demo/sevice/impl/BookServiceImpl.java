package com.turingjavaee7.demo.sevice.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turingjavaee7.demo.dao.BookDao;
import com.turingjavaee7.demo.model.Book;
import com.turingjavaee7.demo.sevice.BookService;
import com.turingjavaee7.demo.sevice.exception.BusinessLogicException;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookDao bookDao;
	
	@Override
	public List<Book> getAllBook() {
		return this.bookDao.getAllBooks();
	}

	@Override
	public Book getBookById(Long id) {
		return this.bookDao.getBookById(id);
	}

	@Override
	public Book saveBook(Book book) {
		return this.bookDao.saveBook(book);
		
	}

	@Override
	public Book updateBook(Book book) {
		return this.bookDao.updateBook(book);
		
	}

	@Override
	public Book deleteBookById(Long id) throws BusinessLogicException {
		try {
			return this.bookDao.deleteBookById(id);
		} catch (Exception e) {
			throw new BusinessLogicException("Book Not Found");
		}
		
	}
}
