package com.sunbeam;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring01Main {

	/*
	public static void main(String[] args) {
		BoxImpl b1 = new BoxImpl(5,6,7);
		int val = b1.calArea();
		System.out.println("Area : "+val);
		
		
		BoxImpl b2 = new BoxImpl(10,7,8);
		int val2 = b2.calVolume();
		System.out.println("Volume : "+val2);
	}
	*/
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("bean.xml");
		
		BoxImpl b1 = (BoxImpl) ctx.getBean("b1");
		int val = b1.calArea();
		System.out.println("Area : "+val);
		
		BoxImpl b2 = (BoxImpl) ctx.getBean("b2");
		int val2 = b2.calVolume();
		System.out.println("Volume : "+val2);
	}
}
