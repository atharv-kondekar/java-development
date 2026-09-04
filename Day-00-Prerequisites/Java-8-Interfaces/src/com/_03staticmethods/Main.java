package com._03staticmethods;

public class Main {

	public static void main(String[] args) {
		EmployeeImpl e1 = new EmployeeImpl();
		e1.setSal(2000);
		EmployeeImpl e2 = new EmployeeImpl();
		e2.setSal(2000);
		EmployeeImpl e3 = new EmployeeImpl();
		e3.setSal(2000);
		EmployeeImpl e4 = new EmployeeImpl();
		e4.setSal(2000);

		Employee employees[] = {e1,e2,e3,e4};

		double totalSal = Employee.calcTotalSalary(employees);
		System.out.println("total sal : "+totalSal);
	}
}
