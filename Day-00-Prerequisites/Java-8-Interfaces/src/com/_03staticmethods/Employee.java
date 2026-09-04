package com._03staticmethods;

public interface Employee {
	double getSal();

	static double calcTotalSalary(Employee [] employees) {
		double total = 0.0;

		for (int i = 0; i < employees.length; i++) {
			total+=employees[i].getSal();
		}

		return total;
	}
}
