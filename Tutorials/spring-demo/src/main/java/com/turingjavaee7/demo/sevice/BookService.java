package com.turingjavaee7.demo.sevice;

import java.util.List;

import com.turingjavaee7.demo.model.*;

public interface BookService {
	List<Book> getAllBook();
	Book getBookById(String id);
	void saveBook(Book book);
}
