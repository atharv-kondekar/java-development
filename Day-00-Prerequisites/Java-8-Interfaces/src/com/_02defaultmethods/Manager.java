package com._02defaultmethods;

class Manager implements Emp{

	public void setSalary(double salary) {
		this.salary = salary;
	}

	private double salary;

	public double getSalary() {
		return this.salary;
	}

	// Custom implementation of the Default method
	public double calculateIncentives() {
		return getSalary()*0.2;
	}
}
