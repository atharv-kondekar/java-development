package com.sunbeam;

public interface UserDao {
	int addRecord(User user);
	int updateRecord(User user);
	int deleteUser(int id);
}
