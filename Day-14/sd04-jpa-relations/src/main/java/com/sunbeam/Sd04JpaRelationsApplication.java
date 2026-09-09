package com.sunbeam;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class Sd04JpaRelationsApplication implements CommandLineRunner{

	private final DeptRepository deptRepository;
	private final EmpRepository empRepository;

	//@Autowired
	Sd04JpaRelationsApplication(EmpRepository empRepository, DeptRepository deptRepository) {
		this.empRepository = empRepository;
		this.deptRepository = deptRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Sd04JpaRelationsApplication.class, args);
	}

	@Override
	//@Transactional //Solution 1: for the Lazy Loading
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		List<Emp> empList = empRepository.findAll();
		empList.stream()
			.forEach(emp -> System.out.println(emp));
		System.out.println();

		List<Dept> deptList = deptRepository.findAllEmps();
		for (Dept dept : deptList) {
			System.out.println("\nFound : "+dept);
			for ( Emp emp : dept.getEmpList())
				System.out.println("        - "+emp);
		}
		System.out.println();

		deptList = deptRepository.findAll();
		for (Dept dept : deptList) {
			System.out.println("\nFound : "+dept);
			for ( Emp emp : dept.getEmpList())
				System.out.println("        - "+emp);
		}
		System.out.println();
	}
}
