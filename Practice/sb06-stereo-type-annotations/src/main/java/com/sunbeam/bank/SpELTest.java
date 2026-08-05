package com.sunbeam.bank;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class SpELTest {
	@Value("#{a1.id}")
	private int accId;

	@Value("#{a1.getType()}")
	private String type;

	@Value("#{a1.balance}")
	private double balance;

	//@Value with SpEL is evaluated only once when the bean is created,
	//not every time you call display().
	public void display() {
		System.out.println("Account id : "+this.accId);
		System.out.println("Account type : "+this.type);
		System.out.println("Account balance : "+this.balance);
	}
}
