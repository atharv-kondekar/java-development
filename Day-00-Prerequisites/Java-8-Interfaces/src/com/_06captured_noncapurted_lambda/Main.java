package com._06captured_noncapurted_lambda;

@FunctionalInterface
interface Calculator{
	int add(int a,int b);
}

public class Main {
	public static void main(String[] args) {

		//Non-capturing Lambda
		Calculator calculator1  = (a,b)-> a+b;
		System.out.println(calculator1.add(2,3));

		//Capturing Lambda
		int x =20;
		Calculator calculator2 = (a,b)-> a+b+x;
		System.out.println(calculator2.add(3, 4));
	}

}
