package com._05lambdaexpressionexample;

public interface FunctionalInterfaces {

}

@FunctionalInterface
interface SayHello{
	void greetings();
}

@FunctionalInterface
interface Printer{
	void printMessage(String message);
}

@FunctionalInterface
interface Calculator{
	int add(int a,int b);
}

@FunctionalInterface
interface MultiLineCalculator{
	int add(int a,int b);
}

@FunctionalInterface
interface NumberCheck{
	boolean isPrime(int a);
}

@FunctionalInterface
interface Square{
	int findSquare(int num);
}

@FunctionalInterface
interface StringOperation{
	String process(String str);
}










