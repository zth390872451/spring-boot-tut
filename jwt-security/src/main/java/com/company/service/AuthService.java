package com.company.service;

import com.company.dos.User;

/**
 * @creator ZTH
 * @modifier ZTH
 * @date 2017-08-05
 */
public interface AuthService {
	User register(User userToAdd);
	String login(String username, String password);
	String refresh(String oldToken);
}
