package com.sunbeam.users.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.sunbeam.users.dao.UserDao;
import com.sunbeam.users.domain.User;
import com.sunbeam.users.model.LoginCreadentials;

@Service
public class UserService {

	private UserDao userDao;

	public UserService(UserDao userDao) {
		this.userDao = userDao;
	}

	public List<User> findAllUsers() {
		return userDao.findAll();
	}

	public User findById(int id) {
		return userDao.findUserById(id);
	}

	public User findByEmail(String email) {
		Optional<User> opUser= userDao.findByEmail(email);
		return opUser.isEmpty()?null:opUser.get();
	}

	public int saveData(User user) {
		return userDao.save(user);
	}

	public int updateUser(User user) {
		return userDao.updateById(user);
	}

	public int updateEmail (String email,int id) {
		return userDao.updateEmail(email, id);
	}

	public int deleteUserById(int id) {
		return userDao.deleteUser(id);
	}

	public User authenticate(LoginCreadentials lc) {
		Optional<User> opUser = userDao.findByEmail( lc.getEmail() );

		if(opUser.isEmpty()) {
			return null;
		}
		else {
			User user = opUser.get();

			if(user!=null && user.getPasswd().equals(lc.getPasswd())) {
				return user;
			}
			return null;
		}
	}

}
