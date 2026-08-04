package com.sunbeam.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoConfiguration {
	@Bean
	BoxImpl b1() {
		BoxImpl b = new BoxImpl();
		b.setBreadth(2);
		b.setLength(3);
		b.setHeight(4);

		return b;
	}

	@Bean
	BoxImpl b2() {
		return new BoxImpl(4,4,4);
	}

	@Bean
	CustomBeanPostProcessor custom() {
		return new CustomBeanPostProcessor();
	}
}
