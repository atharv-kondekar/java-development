package com.sunbeam;

import java.util.List;
import java.util.Optional;

public interface UserDao {
	int save(User user);
	int update(User user);
	int deleteById(int userId);
	List<User> findAll();
	User findByEmail(String email);
	Optional<User> findById(int id);
}
