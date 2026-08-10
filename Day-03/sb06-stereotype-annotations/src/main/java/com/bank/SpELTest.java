package com.bank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpELTest {
	@Value("#{acc.getId()}")
	private int accId;

	@Value("#{acc.balance}")
	private double amount;

	@Value("#{acc.type}")
	private String type;

	public void display() {
		System.out.println("Account Id : "+this.accId);
		System.out.println("Account Type : "+this.type);
		System.out.println("Account balance : "+this.amount);
	}
}
