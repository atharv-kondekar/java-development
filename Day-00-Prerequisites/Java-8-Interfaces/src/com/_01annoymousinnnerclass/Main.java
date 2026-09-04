package com._01annoymousinnnerclass;

class UpiPayment implements Payment{

	@Override
	public void pay(double amount) {
		 System.out.println("UPI payment: ₹" + amount);
	}

	@Override
	public void refund(double amount) {
		 System.out.println("UPI refund: ₹" + amount);
	}

}

public class Main {

	public static void main(String[] args) {
		// 1. Normal implementation
		System.err.println("1. Normal implementation ");
		UpiPayment upiPayment = new UpiPayment();
		upiPayment.pay(2000);
		upiPayment.refund(400);

		System.err.println("\n2. Annoymous Inner Class Impl ");
		
		Payment payment = new Payment() {
			@Override
			public void refund(double amount) {
				System.out.println("Annoymous Inner Class UPI payment : ₹" + amount);
			}
			@Override
			public void pay(double amount) {
				System.out.println("Annoymous Inner Class UPI refund : ₹" + amount);
			}
		};

		payment.pay(300);
		payment.refund(300);
	}

}
