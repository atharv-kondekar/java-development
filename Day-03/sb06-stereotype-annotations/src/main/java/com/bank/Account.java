package com.bank;

public interface Account {
	void setId(int id);
	void setBalance(double balance);
	void setType(String type);

	int getId();
	double getBalance();
	String getType();

	void withdraw(double amount);
	void deposit(double amount);
}
