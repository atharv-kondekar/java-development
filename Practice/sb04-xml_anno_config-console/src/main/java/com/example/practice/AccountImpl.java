package com.example.practice;

public class AccountImpl implements Account{
	private int accId;
	private String type;
	private double balance;
	private Person accHolder;
	
	public AccountImpl() {
		super();
	}
	public AccountImpl(int accId, String type, double balance, Person accHolder) {
		super();
		this.accId = accId;
		this.type = type;
		this.balance = balance;
		this.accHolder = accHolder;
	}
	public int getAccId() {
		return accId;
	}
	public void setAccId(int accId) {
		this.accId = accId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public Person getAccHolder() {
		return accHolder;
	}
	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}
	@Override
	public String toString() {
		return "AccountImpl [accId=" + accId + ", type=" + type + ", balance=" + balance + ", accHolder=" + accHolder
				+ "]";
	}
	@Override
	public void withDraw(double amount) {
		// TODO Auto-generated method stub
		this.balance-=amount;
	}
	@Override
	public void deposit(double amount) {
		// TODO Auto-generated method stub
		this.balance+=amount;
	}
	
	
}
