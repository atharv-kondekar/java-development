package com.sunbeam.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sunbeam.doas.UserDao;
import com.sunbeam.domain.User;

@Service
public class UserService {
	private UserDao userDao;

	public UserService(UserDao userDao) {
		this.userDao=userDao;
	}

	public List<User> findAllUsers() {
		return userDao.findAll();
	}
}
