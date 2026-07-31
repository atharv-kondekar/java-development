package com.example;

public interface IAAccount {
	void deposit(double amount);
	void withDraw(double amount);
	
	// Along with we are writing the Helper methods also
	void setid(int id);
	int getid();
	void setbalance(double balance);
	double getbalance();
}
