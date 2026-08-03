package com.sunbeam.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoConfiguration {

	// Setter Based DI (Setter + default Constructor)
	@Bean
	BoxImpl b1() {
		BoxImpl b =  new BoxImpl();
		b.setLength(4);
		b.setHeight(3);
		b.setBreadth(6);
		
		return b;
	}
	
	//Constructor based DI (Parameterized Constructor)
	@Bean
	BoxImpl b2() {
		return new BoxImpl(7,8,9);
	}
	
}
