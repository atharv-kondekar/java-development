package com.sunbeam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
/*
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

		List<EmpDTO> list1 = empRepository.findAllEmps();
		list1.stream()
			.forEach( ele -> System.out.println(ele));
		System.out.println();

		List<EmpDTO> list2 = empRepository.findAllEmps2();
		list2.stream()
			.forEach( ele -> System.out.println(ele));
		System.out.println();
	}
*/
/*
	@Transactional // L1 Cache & Hibernate Entity Life-cycle
	public void run(String... args) throws Exception {

//		Optional<Dept> dept = deptRepository.findById(10);
//		if(dept.isPresent()) {
//			Emp emp = new Emp(6,"Atharv",null ,dept.get());
//			emp=empRepository.save(emp);
//			System.out.println("Saved : "+emp);
//		}

		Optional<Emp> oe1 = empRepository.findById(1);
		if( oe1.isPresent() ) {
			Emp emp = oe1.get();
			emp.setEname("AmitK");
			// We didn't Write the .save() method here
			// But Write the @Transactional on the Top of the Method , If you don't then it updated in the DB
			System.out.println("Updated Successfully");
		}else {
			System.out.println("Emp not found for the Updation ");
		}
		System.out.println();

		int empId = 6;
		if (empRepository.existsById(6)) {
			empRepository.deleteById(empId);
			System.out.println("Deleted Successfully");
		}else {
			System.out.println("Emp is not found for the Deletion");
		}
		System.out.println();

		Optional<Emp> emp1 = empRepository.findById(1);
		if (emp1.isPresent())
			System.out.println("Emp 1 : "+emp1.get());
		Optional<Emp> emp2 = empRepository.findById(1);
		if (emp2.isPresent())
			System.out.println("Emp 2 : "+emp2.get());
	}
*/
	//@Transactional
	// Working Behind save() method ---- Internally Calls JPA , 1.persist / 2.merge()
	// --- first checks record is present or not ------
	//	1. if not then performs INSERT Operation  ======>>> persist()

//	public void run(String... args) throws Exception {
//		Dept dept1 = new Dept(50,"SEC", null);
//		dept1 = deptRepository.save(dept1);
//		System.out.println("Saved !!");
//
//	}

	//  2. if yes then performs Update Operation  ======>>> merge()
//	public void run(String... args) throws Exception {
//		Dept dept2 = new Dept(40,"SALES",null);
//		dept2=deptRepository.save(dept2);
//		System.out.println("Updated !!!!");
//	}
/*
	@Override
	public void run(String... args) throws Exception {
		// when dept is deleted, corresponding emps should also be deleted.
		//	for this, in Dept class -->
		//			@OneToMany(mappedBy="dept", cascade = {CascadeType.REMOVE})
		//			List<Emp> empList;
		int deptId = 40;
		Optional<Dept> od = deptRepository.findById(deptId);
		if(od.isPresent()) {
			Dept d = od.get();
			deptRepository.delete(d);
			System.out.println("Dept Deleted: " + d);
		}
		else
			System.out.println("Dept Not Found.");
	}
*/
	@Override
	public void run(String... args) throws Exception {
		// when dept is saved, corresponding emps should also be saved.
		//	for this, in Dept class -->
		//           @OneToMany(mappedBy="dept", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
		//			 List<Emp> empList;
		Dept d = new Dept(70, "TRAINING", new ArrayList<>());
		Emp e1 = new Emp(8, "Trainer1", null, d); // Emp knows in which Dept he/she is
		Emp e2 = new Emp(9, "Trainer2", null, d); // Emp knows in which Dept he/she is
		d.getEmpList().add(e1); // Dept knows Emp e1 added in it
		d.getEmpList().add(e2); // Dept knows Emp e2 added in it
		deptRepository.save(d); // trying to save "Dept" -- will it save "Emp"s too?

	}
}
