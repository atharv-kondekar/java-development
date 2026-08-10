package com.bank;

public interface Person {
	void setName(String name);
	void setAge(int age);
	void setEmail(String email);

	String getEmail();
	int getAge();
	String getName();
}
