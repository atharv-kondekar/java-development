package com.sunbeam.bank;

import java.util.zip.Inflater;

public interface Account {
	void setId(int id);
	void setType(String type);
	void setBalance(double balance);
	void setLogger(Logger logger);

	int getId();
	String getType();
	double getBalance();
	Logger getLogger();

	void deposit(double amount);
	void withDraw(double amount);

	void setAccHolder(Person accHolder);
	Person getAccHolder();
}
