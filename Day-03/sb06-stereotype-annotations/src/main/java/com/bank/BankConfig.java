package com.bank;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class BankConfig {
	//All Beans related to the com.bank are configured here

	@Bean
	AccountImpl acc() {
		return new AccountImpl(101,"Savings",10000);
	}

	@ConfigurationProperties("a1")
	@Bean
	AccountImpl a1() {
		return new AccountImpl();
	}

	@ConfigurationProperties("a2")
	@Bean
	AccountImpl a2() {
		return new AccountImpl();
	}

	@ConfigurationProperties("p1")
	@Bean
	Person p1() {
		return new PersonImpl();
	}

	@ConfigurationProperties("p2")
	@Bean
	Person p2() {
		return new PersonImpl();
	}

	@ConfigurationProperties("newacc")
	@Bean
	Account aNewAcc() {
		return new AccountImpl();
	}
}
