package com.example;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AccountProxyhandler implements InvocationHandler {
	
	private IAAccount target; 
	
	public AccountProxyhandler(IAAccount target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		//Pre-Processing
		if(method.getName().equals("deposit") || method.getName().equals("withDraw")) {
			double amount = (Double) args[0];
			
			if(amount <= 0.0)
				throw new RuntimeException("Invalid Amount");
		}
		
		//call business logic 
		Object[] result = (Object[]) method.invoke(target, args);
		
		
		//Post-Processing
		System.out.println(method.getName()+ " on account "+target.getid());
		return result;
	}
	
	public static IAAccount getAccountProxy(IAAccount acc) {
		AccountProxyhandler acchandler = new AccountProxyhandler(acc);
		
		IAAccount proxy = (IAAccount) 
				Proxy.newProxyInstance(AccountImpl.class.getClassLoader(), 
				new Class[] {IAAccount.class},
				acchandler);
		return proxy;
	}

}
