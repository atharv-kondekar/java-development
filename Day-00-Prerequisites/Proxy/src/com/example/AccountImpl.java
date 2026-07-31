package com.example;

public class AccountImpl implements IAAccount {
	
	private int id;
	private double balance;
	
	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		this.balance+=amount;
	}

	@Override
	public void withDraw(double amount) {
		// TODO Auto-generated method stub
		if(this.balance<amount)
			throw new RuntimeException("Insufficient balance");
		this.balance-=amount;
	}

	@Override
	public void setid(int id) {
		// TODO Auto-generated method stub
		this.id=id;
	}

	@Override
	public int getid() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void setbalance(double balance) {
		// TODO Auto-generated method stub
		this.balance=balance;
	}

	@Override
	public double getbalance() {
		// TODO Auto-generated method stub
		return this.balance;
	}

}
