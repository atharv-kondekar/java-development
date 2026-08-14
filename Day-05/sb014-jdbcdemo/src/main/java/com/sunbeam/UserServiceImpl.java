package com.sunbeam;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class UserServiceImpl implements UserService{

	private UserDao userDao;
	public UserServiceImpl(UserDao userDao) {
		this.userDao=userDao;
	}

	@Override
	@Transactional
	public User authenticate(String email,String passwd) {
		User user = userDao.findByEmail(email);
		if( user!= null && passwd.equals(user.getPasswd()) )
			return user;

		return null;
	}

}
