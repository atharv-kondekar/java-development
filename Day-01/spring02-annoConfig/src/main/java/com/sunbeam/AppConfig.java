package com.sunbeam;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;

@Configuration
public class AppConfig {
	
	/*
		Important: Which DI is used ?
		Ans : LAways Go For "Parameterized Constructor DI"
	*/
	
	@Bean
	BoxImpl b1() {
		// Setter Based Dependency Injection
		// setter + parameterless constructor
		BoxImpl b = new BoxImpl();
		b.setBreadth(5);
		b.setHeight(4);
		b.setLength(6);
		
		return b;
	}
	
	@Bean 
	BoxImpl b2() {
		//Constructor Based Dependency Injection
		// Only need "Parameterized Constructor"
		BoxImpl b = new BoxImpl(3,4,5);
		return b;
	}
}
