package com.sunbeam.bank;

import java.beans.ConstructorProperties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan//("com.sunbeam.bank")
//By Default detects beans in the Current package & it's sub package
@Configuration
public class BankConfig {
	//All are Beans related to the bank classes are Configured Here

	@Bean
	AccountImpl a1() {
		return new AccountImpl(101,"Savings",10000);
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

	@ConfigurationProperties("a2")
	@Bean
	AccountImpl a2() {
		return new AccountImpl();
	}

	@ConfigurationProperties("a3")
	@Bean
	AccountImpl a3() {
		return new AccountImpl();
	}

	@ConfigurationProperties(prefix = "newacc")
	@Bean
	AccountImpl aNewacc() {
		return new AccountImpl();
	}

}
