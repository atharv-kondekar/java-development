package com.sunbeam.sb;

import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
public class Sb04SpringBeanLifecycleApplication implements CommandLineRunner , ApplicationContextAware{

	public static void main(String[] args) {
		SpringApplication.run(Sb04SpringBeanLifecycleApplication.class, args);
	}
	
	private ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
	}
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("\n\nHello Spring Boot ");
		
		Box b1 =(Box) ctx.getBean("b1");
		System.out.println("b1 : "+b1);
		
		Box b2 =(Box) ctx.getBean("b2");
		System.out.println("b2 : "+b2);
	}
}
