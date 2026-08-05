package com.sunbeam.bank;

public interface Person {
	void setName(String name);
	void setEmail(String email);
	void setAge(int age);

	int getAge();
	String getName();
	String getEmail();
}
