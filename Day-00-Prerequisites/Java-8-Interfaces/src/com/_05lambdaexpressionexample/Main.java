package com._05lambdaexpressionexample;

public class Main {

	public static void main(String[] args) {
		//1.
		SayHello hello = ()->{
			System.out.println("Hello Bro");
		};
		hello.greetings();

		//2.
		Printer print = (msg)->{
			System.out.println(msg);
		};
		print.printMessage("Have A good Day ");

		//3.
		Calculator calculator = (a,b)->a+b;
		System.out.println(calculator.add(1, 3));

		//4.
		MultiLineCalculator multiLineCalculator =
				(a,b)->{
					int res = a+b;
					System.out.println("Calculating...");
					return res;
				};
		System.out.println(multiLineCalculator.add(1, 4));

		//5.
		NumberCheck numberCheck = (num)->num%2==0;
		System.out.println(numberCheck.isPrime(30));

		//6.
		Square square = (num)->num*num;
		System.out.println( square.findSquare(4));

		//7.
		StringOperation stringOperation =
				(str)->str.toUpperCase();
		System.out.println( stringOperation.process("atharv"));

	}
}








