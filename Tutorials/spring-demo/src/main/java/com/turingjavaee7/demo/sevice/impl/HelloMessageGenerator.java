package com.turingjavaee7.demo.sevice.impl;

import org.springframework.web.context.annotation.RequestScope;

public class HelloMessageGenerator {
	String message;
	public void setMessage(String message)
	{
		this.message = message;
	}
	public String getMessage()
	{
		return this.message;
	}
}
