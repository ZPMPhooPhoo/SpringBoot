package com.turingjavaee7.demo.model;

import java.io.Serializable;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Book implements Serializable{
	
	private static final Long  serialVersionUID = 1L;
	
//	@NotBlank(message = "Id is mandatory")
//	@NotBlank(message = "{required.book.id}")
	Long id;
	
	@NotBlank(message = "Title is mandatory")
//	@Size(min = 3, max = 100, message = " Title must between 3 and 100 characters")
	@Size(min = 3, max = 100, message = "{size.book.title}")
	String title;
	
	@NotBlank(message = "Author is mandatory")
	String author;
	
}
