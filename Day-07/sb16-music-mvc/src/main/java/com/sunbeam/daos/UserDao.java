package com.sunbeam.daos;

import java.util.List;
import java.util.Optional;

import com.sunbeam.domain.User;

public interface UserDao {
	int save(User user);

	int update(User user);

	int deleteById(int id);

	List<User> findAll();

	User findByEmail(String email);

	Optional<User> findById(int id);
}
