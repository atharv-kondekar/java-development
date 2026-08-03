package com.sunbeam.practice;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfigMain {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("beans.xml");
		
		BoxImpl b1 = (BoxImpl) ctx.getBean("b1");
		System.out.println("Area : "+b1.calArea());
		
		BoxImpl b2 = (BoxImpl) ctx.getBean("b2");
		System.out.println("Volume : "+b2.calVolume());
		
	}

}
