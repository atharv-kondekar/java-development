package com._02defaultmethods;

public interface Emp{

	double getSalary();

	// Default Implementation
	default double calculateIncentives() {
		return 0.0;
	}
}