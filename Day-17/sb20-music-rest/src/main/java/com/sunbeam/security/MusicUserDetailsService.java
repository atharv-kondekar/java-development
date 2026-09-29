package com.sunbeam.security;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.sunbeam.users.dao.UserDao;
import com.sunbeam.users.domain.User;

@Service
public class MusicUserDetailsService implements UserDetailsService{

	private UserDao userDao;

	public MusicUserDetailsService(UserDao userDao) {
		this.userDao = userDao;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		Optional<User> optUser = userDao.findByEmail(username);
		if(optUser.isPresent()) {
			User user = optUser.get();
			return new MusicUserDetails(user);
		}

		throw new UsernameNotFoundException("Invalid user");

	}

}
