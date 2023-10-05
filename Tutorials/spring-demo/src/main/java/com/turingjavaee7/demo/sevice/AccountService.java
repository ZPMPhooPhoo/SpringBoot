package com.turingjavaee7.demo.sevice;

public interface AccountService {
	boolean login(String username, String password) throws AuthenticationException;
}
