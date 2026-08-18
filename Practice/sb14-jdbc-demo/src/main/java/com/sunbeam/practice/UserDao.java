package com.sunbeam.practice;

import java.lang.classfile.ClassFile.Option;
import java.util.List;
import java.util.Optional;

public interface UserDao {
	int saveRecord(User user);
	int updateRecord(User user);
	List<User> findAllUsers();
	User findByEmail(String email);
	Optional<User> findById(int id);
}
