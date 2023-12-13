package com.turingjavaee7.demo.sevice;

import java.util.List;

import com.turingjavaee7.demo.model.*;
import com.turingjavaee7.demo.sevice.exception.BusinessLogicException;

public interface BookService {
	List<Book> getAllBook();
	Book getBookById(String id);
	Book saveBook(Book book);
	Book updateBook(Book book);
	Book deleteBookById(String id)throws BusinessLogicException;
}
