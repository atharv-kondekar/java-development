package com.sunbeam.sb;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoConfiguration {
	
	@Bean
	Person p2() {
		return new PersonImpl("Nilesh", 45);
	}
	
	@Bean
	AccountImpl a3() {
		return new AccountImpl(303,"Savings", 30000, p2());
	}
	
	@Bean
	AccountImpl a4() {
		return new AccountImpl(404,"Current",40000,p2());
	}
	
	/*
	-- Mixed Configuration (P1 of XML passes in a5 of Annotation Configuration)
	@Bean
	AccountImpl a5(Person p) {
		return new AccountImpl(505,"Savings",505000,p);
	}
	*/
	
	// 1) BY Name  - Directly write the name
	@Bean
	AccountImpl a6(Person p1) {
		return new AccountImpl(606,"Savings",505000,p1);
	}
	
	// 2) BY Qualifier 
	@Bean
	AccountImpl a7( @Qualifier("p1") Person p) {
		return new AccountImpl(707,"Current",505000,p);
	}
}
