package com.sunbeam.sb;


public class AccountImpl implements Account{
	
	private int id;
	private String type;
	private double balance;
	private Person acPerson;
		
	public AccountImpl() {
		super();
	}

	public AccountImpl(int id, String type, double balance, Person acPerson) {
		super();
		this.id = id;
		this.type = type;
		this.balance = balance;
		this.acPerson = acPerson;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the acPerson
	 */
	public Person getAcPerson() {
		return acPerson;
	}

	/**
	 * @param acPerson the acPerson to set
	 */
	public void setAcPerson(Person acPerson) {
		this.acPerson = acPerson;
	}

	@Override
	public String toString() {
		return "AccountImpl [id=" + id + ", type=" + type + ", balance=" + balance + ", acPerson=" + acPerson + "]";
	}
	
	public void deposit(double amount) {
		this.balance+=amount;
	}
	
	public void withdraw (double amount) {
		this.balance -= amount;
	}
}
