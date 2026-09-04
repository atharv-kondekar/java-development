package com._02defaultmethods;


public class Main {

	public static void main(String[] args) {
		Manager manager = new Manager();
		manager.setSalary(4000);
		System.out.println("Salary of manager : "+manager.getSalary());
		System.out.println("Incentives of manager : "+manager.calculateIncentives());

		System.out.println("\n");

		Clerk clerk = new Clerk();
		clerk.setSalary(2000);

		System.out.println("Salary of clerk : "+clerk.getSalary());
		System.out.println("Incentives of clerk : "+clerk.calculateIncentives());

	}
}
