package com.bank;

import org.springframework.beans.factory.annotation.Value;

public class AccountImpl implements Account{
	private int id;
	private String type;
	private double balance;
	// Using SpEL
	@Value("#{fileLoggerImpl}")
	private Logger logger;

	private Person accHolder;

	public Person getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public AccountImpl() {
		super();
	}

	public AccountImpl(int id, String type, double balance) {
		super();
		this.id = id;
		this.type = type;
		this.balance = balance;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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


	@Override
	public String toString() {
		return "AccountImpl [id=" + id + ", type=" + type + ", balance=" + balance + ", accHolder=" + accHolder + "]";
	}

	public void withdraw(double amount) {
		if(logger!=null)
			System.out.println("Withdrew : "+amount);
		this.balance-=amount;
	}

	public void deposit(double amount) {
		if(logger!=null)
			System.out.println("Deposited : "+amount);
		this.balance +=amount;
	}
}
