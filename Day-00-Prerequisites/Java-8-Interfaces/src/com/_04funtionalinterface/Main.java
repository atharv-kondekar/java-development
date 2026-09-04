package com._04funtionalinterface;

@FunctionalInterface
interface Foo{
	void foo();
}

@FunctionalInterface
interface FooBar{
	void foo();
	default void bar() {
		 System.out.println("bar");
	}
}

@FunctionalInterface
interface Foobar2{
	void foo();
	static void bar() {
		 System.out.println("bar");
	}
}

//Compile Time Error
//@FunctionalInterface
//interface Foobar3{
//	void foo();
//	void bar();
//}

// Compile time error
//@FunctionalInterface
//interface Foobar2{
//	static/default void foo() {
//
//	}
//	static/default void bar() {
//		 System.out.println("bar");
//	}
//}

public interface Main {

	public static void main(String[] args) {

	}
}
