package com._05lambdaexpression;

import java.util.Arrays;
import java.util.Comparator;

class Employee{
	private int empNo;
	private int sal;


	public Employee(int empNo, int sal) {
		super();
		this.empNo = empNo;
		this.sal = sal;
	}


	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}


	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public int getEmpNo() {
		return empNo;
	}

    @Override
    public String toString() {
        return "Employee [empNo=" + empNo + "]";
    }

}

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee e1 = new Employee(34,40000);
		Employee e2 = new Employee(23,50000);
		Employee []employees = {e1,e2};

		// 1. Anonymous Inner Class
		Arrays.sort( employees ,new Comparator<Employee>() {
			@Override
			public int compare(Employee e1, Employee e2) {
				return e1.getEmpNo() - e2.getEmpNo();
			}
		});
		System.out.println( Arrays.toString(employees));

		// 2. Lambda Expression - multi-linear
		Arrays.sort( employees , (Employee emp1,Employee emp2) -> {
			int diff = emp1.getEmpNo() - emp2.getEmpNo();
			return diff;
		});
		System.out.println( Arrays.toString(employees));

		// 3. Lambda Expression - multi-linear - Argument type inferred
		Arrays.sort( employees , (emp1,emp2)->{
			int diff = emp1.getSal() - emp2.getSal();
			return diff;
		});
		System.out.println( Arrays.toString(employees));

		// 4. Lambda Expression - sinle-linear -with block
		Arrays.sort( employees , (emp1,emp2) -> {
			return emp1.getSal() - emp2.getSal();
		});
		System.out.println( Arrays.toString(employees));

		// 5. Lambda Expression - sinle-linear
		Arrays.sort( employees , (emp1,emp2) -> emp1.getSal() - emp2.getSal());
	}

}
