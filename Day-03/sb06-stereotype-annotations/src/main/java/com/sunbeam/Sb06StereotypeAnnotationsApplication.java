package com.sunbeam;

import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.bank.Account;
import com.bank.BankConfig;
import com.bank.ConsoleLoggerImpl;
import com.bank.FileLoggerImpl;
import com.bank.Logger;
import com.bank.Person;
import com.bank.SpELTest;

@Import(BankConfig.class)
//@ComponentScan("com.bank")
@SpringBootApplication
public class Sb06StereotypeAnnotationsApplication implements CommandLineRunner
,ApplicationContextAware{

	public static void main(String[] args) {
		SpringApplication.run(Sb06StereotypeAnnotationsApplication.class, args);
	}

	private ApplicationContext ctx;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx=applicationContext;
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("---- Stereo-Type Annotations Demo ----");

//		Logger l1 = (Logger) ctx.getBean("consoleLoggerImpl");
//		l1.log("Hello Spring 😊");

		Logger l1 = ctx.getBean(ConsoleLoggerImpl.class);
		l1.log("Hello Spring 😊");

		Logger l2 = ctx.getBean(FileLoggerImpl.class);
		l2.log("Hello Spring 😊");

		Logger l3 = ctx.getBean(Logger.class);
		l3.log("Hello Spring 😊");

		System.out.println("\n");

		Account acc = (Account) ctx.getBean("acc");
		System.out.println(acc);
		acc.deposit(1200);
		System.out.println(acc);

		System.out.println();

		SpELTest sp = ctx.getBean(SpELTest.class);
		sp.display();


		System.out.println();

		Person p1 = (Person) ctx.getBean("p1");
		System.out.println(p1);

		Person p2 = (Person) ctx.getBean("p2");
		System.out.println(p2);

		System.out.println();

		Account a1 =(Account) ctx.getBean("a1");
		System.out.println(a1);

		Account a2 = (Account) ctx.getBean("a2");
		System.out.println(a2);

		System.out.println();

		Account aNewAcc = (Account) ctx.getBean("aNewAcc");
		System.out.println(aNewAcc);
	}
}










