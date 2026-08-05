package com.sunbeam.practice;
import com.sunbeam.bank.Logger;
import com.sunbeam.bank.Person;
import com.sunbeam.bank.SpELTest;

import org.springframework.beans.BeansException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.expression.spel.standard.SpelCompiler;

import com.sunbeam.bank.Account;
import com.sunbeam.bank.BankConfig;
import com.sunbeam.bank.ConsoleLogger;
import com.sunbeam.bank.FileLogger;


@Import(BankConfig.class) // This one is Recommended
//@ComponentScan("com.sunbeam.bank")
@SpringBootApplication
public class Sb06StereoTypeAnnotationsApplication implements CommandLineRunner
,ApplicationContextAware{

	public static void main(String[] args) {
		SpringApplication.run(Sb06StereoTypeAnnotationsApplication.class, args);
	}

	private ApplicationContext ctx;
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.ctx = applicationContext;
	}

	@Override
	public void run(String... args) throws Exception {

//By Default,for stereo type anns,
//		Bean name is same as className(in camel case),But You can change it
// @Component("console") changes Bean id/name
//		Logger l1 = (Logger) ctx.getBean("consoleLogger");
//		l1.log("Hello Spring Boot");

		Logger l1 = ctx.getBean(ConsoleLogger.class);
		l1.log("Hello Spring Boot");

		Logger l2 = ctx.getBean(FileLogger.class);
		l2.log("Hello , Spring Boot ");

		// It Will give you exception
		// Solve it by the @Primay on the Any Class
		Logger l3 = (Logger) ctx.getBean(Logger.class);
		l3.log("Hi I am L3 Bean");

		System.out.println();

		Account a1 = (Account) ctx.getBean("a1");
		//a1.setLogger(l2); // Manually setting a logger in account
		System.out.println(a1);
		System.out.println("Before Deposit : "+a1);
		a1.deposit(4000);
		System.out.println("Before Deposit : "+a1);
		//Balance = 14000.0 RS
		System.out.println();

		SpELTest sp = ctx.getBean(SpELTest.class);
		sp.display(); //Balance = 10000.0 RS

	// WHy ? Ans
	/*	  -> @Value with SpEL is evaluated only once when the bean is created,
		     not every time you call display().
		*/

		System.out.println();

		Person p1 = (Person) ctx.getBean("p1");
		System.out.println(p1);

		Person p2 = (Person) ctx.getBean("p2");
		System.out.println(p2);

		System.out.println();

		Account a2 =(Account) ctx.getBean("a2");
		System.out.println(a2);

		Account a3 = (Account) ctx.getBean("a3");
		System.out.println(a3);

		System.out.println();

		Account aNewacc = (Account) ctx.getBean("aNewacc");
		System.out.println(aNewacc);
	}


}
