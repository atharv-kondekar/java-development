package com.sunbeam.doas;

import java.util.List;

import com.sunbeam.domain.User;

public interface UserDao {
	List<User> findAll();
}
