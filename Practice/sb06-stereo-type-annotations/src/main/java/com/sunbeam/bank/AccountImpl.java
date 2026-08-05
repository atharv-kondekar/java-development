package com.sunbeam.bank;

import org.springframework.beans.factory.annotation.Value;

// Now this class has to be create the Multiple beans
// So , Don't use @Component
public class AccountImpl implements Account{
	private int id;
	private String type;
	private double balance;
	private Person accHolder;

	//Instead of setting value manually, we set value by SpEL @Value()
	@Value("#{fileLogger}")//This is Field Based DI
	private Logger logger;

	public AccountImpl() {
		super();
	}

	public AccountImpl(int id, String type, double balance) {
		super();
		this.id = id;
		this.type = type;
		this.balance = balance;
		this.logger=null;
		this.accHolder=null;
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

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	@Override
	public String toString() {
		return "AccountImpl [id=" + id + ", type=" + type + ", balance=" + balance + ", accHolder=" + accHolder + "]";
	}

	public void deposit(double amt) {
		if(logger != null)
			logger.log("Deposited "+amt+"RS in account "+this.id);
		this.balance += amt;
	}

	public void withDraw(double amount) {
		if(logger != null)
			logger.log("Withdrew "+amount+"RS from account "+this.id);
		this.balance -=amount;
	}

	public Person getAccHolder() {
		return accHolder;
	}

	public void setAccHolder(Person accHolder) {
		this.accHolder = accHolder;
	}

}
