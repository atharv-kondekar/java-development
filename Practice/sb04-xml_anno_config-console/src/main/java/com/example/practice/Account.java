package com.example.practice;

public interface Account {
	void setAccId(int accId);
	void setType(String type);
	void setBalance(double balance);
	void setAccHolder(Person accHolder);
	
	int getAccId();
	String getType();
	double getBalance();
	Person getAccHolder();
	
	void withDraw(double amount);
	void deposit(double amount);
}
