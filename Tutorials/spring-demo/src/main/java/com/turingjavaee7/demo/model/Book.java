package com.turingjavaee7.demo.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book {
	public Book(String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}
	
	public Book()
	{
	}
	
//	@NotBlank(message = "Id is mandatory")
	@NotBlank(message = "{required.book.id}")
	String id;
	
	@NotBlank(message = "Title is mandatory")
//	@Size(min = 3, max = 100, message = " Title must between 3 and 100 characters")
	@Size(min = 3, max = 100, message = "{size.book.title}")
	String title;
	
	@NotBlank(message = "Author is mandatory")
	String author;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}
	
	
}
