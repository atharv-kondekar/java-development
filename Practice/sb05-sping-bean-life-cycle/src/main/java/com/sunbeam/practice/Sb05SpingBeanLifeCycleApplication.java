package com.sunbeam.practice;

import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

@SpringBootApplication
public class Sb05SpingBeanLifeCycleApplication implements CommandLineRunner
,ApplicationContextAware{

	public static void main(String[] args) {
		SpringApplication.run(Sb05SpingBeanLifeCycleApplication.class, args);
	}

	private ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello Spring boot ");

		System.out.println("\n----- For b1 Bean ----- ");
		Box b1 =(Box) ctx.getBean("b1");
		System.out.println(b1);

		System.out.println("\n----- For b2 Bean ----- ");
		Box b2 = (Box) ctx.getBean("b2");
		System.out.println(b2);
	}
}
