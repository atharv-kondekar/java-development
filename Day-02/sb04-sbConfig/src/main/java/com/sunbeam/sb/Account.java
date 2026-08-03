package com.sunbeam.sb;

public interface Account {
	void setId(int id);
	void setType(String type);
	void setBalance(double balance);
	void setAcPerson(Person acPerson);
	
	int getId();
	String getType();
	double getBalance();
	Person getAcPerson();

	void withdraw(double amount);
	void deposit(double amount);
}
