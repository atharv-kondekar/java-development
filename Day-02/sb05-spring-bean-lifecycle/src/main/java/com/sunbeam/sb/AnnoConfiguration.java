package com.sunbeam.sb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AnnoConfiguration {
	
	@Bean
	BoxImpl b1() {
		BoxImpl b1 = new BoxImpl();
		b1.setLength(3);
		b1.setHeight(5);
		b1.setBreadth(5);;
		return b1;
	}
	
	@Bean
	BoxImpl b2() {
		return new BoxImpl(3,3,4);
	}
	
	@Bean
	CustomBeanPostProccessor customBeanPostProccessor() {
		return new CustomBeanPostProccessor();
	}
}
