package com.example;

import java.lang.reflect.Proxy;

public class ProxyMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AccountImpl acc = new AccountImpl();
		acc.setid(101);
		acc.setbalance(20000.00);
		
		IAAccount proxy = AccountProxyhandler.getAccountProxy(acc); 
		proxy.deposit(2000);
		//proxy.getbalance();
	}

}
