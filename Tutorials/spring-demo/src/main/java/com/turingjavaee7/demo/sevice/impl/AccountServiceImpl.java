package com.turingjavaee7.demo.sevice.impl;

import org.springframework.stereotype.Service;

import com.turingjavaee7.demo.sevice.AccountService;
import com.turingjavaee7.demo.sevice.AuthenticationException;

@Service
public class AccountServiceImpl implements AccountService{

	@Override
	public boolean login(String username, String password) throws AuthenticationException {
//		if(username.equals("admin")&& password.equals("password"))
		if("admin".equals(username)&& "password".equals(password))
		{
			return true;
		}
		else
		{
			throw new AuthenticationException("Invalid username and password");
		}
	}
	
}
