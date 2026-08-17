package com.sunbeam.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunbeam.daos.UserDao;
import com.sunbeam.domain.User;
import com.sunbeam.models.LoginCredentials;

@Service
public class UserService {

	private UserDao userDao;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public User authenticate(LoginCredentials lc) {
		User user = userDao.findByEmail(lc.getEmail());

		if (user != null && lc.getPasswd().equals(user.getPasswd())) {
			return user;
		}

		return null;
	}

	public List<User> getUsers() {
		return userDao.findAll();
	}
}
