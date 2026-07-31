package com.example02;

public class MiddlewareMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		// This is the Partial Reflection
		// Because we are creating the Object Here of BankAccount Class 
		BankAccount b = new BankAccount();
		
		 Middleware.invoke(
				b,
				"deposit",
				new Class[] {Double.class},
				new Object[] {5000.00}
			);
		
		
		
		Object result = Middleware.invoke(
				b,
				"checkBalance",
				null,
				null
			);
		System.out.print("\n"+result);
				
	}

}
