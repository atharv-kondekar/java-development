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

	private final MeetingRepository meetingRepository;
	private final AddressRepository addressRepository;
	private final DeptRepository deptRepository;
	private final EmpRepository empRepository;

	//@Autowired
	Sd04JpaRelationsApplication(EmpRepository empRepository, DeptRepository deptRepository, AddressRepository addressRepository, MeetingRepository meetingRepository) {
		this.empRepository = empRepository;
		this.deptRepository = deptRepository;
		this.addressRepository = addressRepository;
		this.meetingRepository = meetingRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(Sd04JpaRelationsApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		Optional<Address> addOptional=addressRepository.findById(3);
//		if (addOptional.isPresent()) {
//			Address address = addOptional.get() ;
//			System.out.println(address);
//			System.out.println("\t"+address.getEmp());
//		}

//		Address a = new Address(0,"Karad","Satara", null);
//		Dept d = new Dept(40, null, null);
//		Emp emp = new Emp(6,"Prashant",4,d,a);
//		a.setEmp(emp);
//		empRepository.save(emp);


//		Optional<Meeting> om = meetingRepository.findById(300);
//		if(om.isPresent()) {
//			Meeting m = om.get();
//			System.out.println("Found " + m);
//			for(Emp e : m.getEmpList())
//				System.out.println("	-> " + e);
//		}
//		else
//			System.out.println("Meeting Not Found.");
//
//		System.out.println("-------------------------------------------------------------------");

		Optional<Emp> oe = empRepository.findById(3);
		if(oe.isPresent()) {
			Emp e = oe.get();
			System.out.println("Found " + e);
			for (Meeting m : e.getMeetingList())
				System.out.println("	-> " + m);
		}
		else
			System.out.println("Employee Not Found");
	}
}
