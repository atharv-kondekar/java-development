package com.subeam;

import java.util.Iterator;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Sd12SelfRefApplication implements CommandLineRunner {

	private final EmployeeRepo employeeRepo;

	Sd12SelfRefApplication(EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo;
	}

	public static void main(String[] args) {
		SpringApplication.run(Sd12SelfRefApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {

		int id = 4;
		Optional<Employee> optionalEmp = employeeRepo.findById(id);
		if (optionalEmp.isPresent()) {
			Employee employee = optionalEmp.get();

			System.out.println("Employee :- "+employee);
			System.out.println("             Manager -> :  "+employee.getManager());

			for(Employee sb : employee.getEmployees()) {
				System.out.println("                    Under "+ sb.getManager().getEname()+" : "+sb);
			}
		}else {
			System.out.println("Employee Not Found");
		}
	}
}
