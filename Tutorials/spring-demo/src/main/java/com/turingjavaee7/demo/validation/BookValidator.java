package com.turingjavaee7.demo.validation;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.turingjavaee7.demo.model.Book;

public class BookValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Book.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "id", "required", new Object[] {"id"});
		ValidationUtils.rejectIfEmpty(errors, "title", "required", new Object[] {"title"});
		ValidationUtils.rejectIfEmpty(errors, "author", "required", new Object[] {"author"});
		
		Book book = (Book)target;
		if(!book.getTitle().isEmpty())
		{
		String firstChar = book.getTitle().charAt(0)+"";
		if(!firstChar.toUpperCase().equals(firstChar))
		{
			errors.rejectValue("title", "uppercase");
		}
		}
	}

}
