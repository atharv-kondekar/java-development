package com._03staticmethods;

public class EmployeeImpl implements Employee{
	private double sal;

	void setSal(double amount) {
		this.sal=amount;
	}

	@Override
	public double getSal() {
		// TODO Auto-generated method stub
		return this.sal;
	}

}
