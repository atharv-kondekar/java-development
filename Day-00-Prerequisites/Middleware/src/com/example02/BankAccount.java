package com.example02;

public class BankAccount {
	private  double balance = 10000.7784;
	
	public BankAccount() {
	}

	public void deposit(Double amount){
		System.out.print("Deposited Successfully");
		balance+=amount;
	}
	
	public void withDraw(Double amount) {
		balance -=amount;
	}
	
	public double checkBalance() {
		return balance;
	}
}
