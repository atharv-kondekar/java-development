package com.example.practice;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoConfiguration {
	
	@Bean
	PersonImpl p2()	{
		return new PersonImpl("Nilesh", 45);
	}
	
	@Bean
	AccountImpl a3() {
		return new AccountImpl(301,"Savings",30000,p2());
	}
	
	@Bean 
	AccountImpl a4() {
		return new AccountImpl(302,"Current",3000000,p2());
	}
	
	/*
	-->> I want p1 as person in a5 , BUt it is in the "beans.xml"
	@Bean
	AccountImpl a5(Person p) {
		return new AccountImpl(505,"Savings",300000, p);
	}
	*/
	
	// Now there are two ways to solve this Error
	
	//1. By the id of class in beans.xml
	@Bean
	AccountImpl a6(Person p1) {
		return new AccountImpl(606,"Savings",345346, p1);
	}
	
	//2. Using Qualifier
	@Bean
	AccountImpl a7( @Qualifier("p1") Person p ) {
		return new AccountImpl(707,"Current",567544,p);
	}
}
