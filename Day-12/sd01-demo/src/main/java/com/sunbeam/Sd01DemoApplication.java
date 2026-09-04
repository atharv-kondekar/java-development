package com.sunbeam;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sd01DemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Sd01DemoApplication.class, args);
	}

	private UserRepository userRepository;

	public Sd01DemoApplication(UserRepository userRepository) {
		this.userRepository = userRepository;
	}


	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);

		// 1. Find by Id
/*
		System.out.print("Enter id :");
		int id = sc.nextInt();
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			System.out.println("\n"+user.get());
		}else {
			System.out.println("user Not Found");
		}
*/
		// 2.Insert Record
/*
		User newUser = new User(0, "tony","tony@gmail.com","$2a$10$H6L6xXwrkiU/RFHFoUgK5uva6MuI7c3hwpbt1oPHGGaz8KfcsQoqq",
				"london",LocalDate.of(1975,1,1), "ROLE_CUSTOMER", 0);
		newUser = userRepository.save(newUser);
		System.out.println("User saved "+newUser);
*/
		// 3.Update User
/*
		User newUser = new User(29, "tony","tony@gmail.com","$2a$10$H6L6xXwrkiU/RFHFoUgK5uva6MuI7c3hwpbt1oPHGGaz8KfcsQoqq",
				"london",LocalDate.of(1975,2,2), "ROLE_CUSTOMER", 0);
		newUser = userRepository.save(newUser);
		System.out.println("User updated :  "+newUser);
*/
		// 4. Delete user
/*
		System.out.print("Enter user id : ");
		int id = sc.nextInt();
		if( userRepository.existsById(id)) {
			userRepository.deleteById(id);
			System.out.println("user is deletd with id: "+id);
		}else {
			System.out.println("User not found");
		}
*/

		// --> Custom Query Method Implementation
//		System.out.println("Enter Email : ");
//		String email = sc.nextLine();
//		User user = userRepository.findByEmail(email);
//		if(user!=null) {
//			System.out.println("User found : "+user);
//		}else {
//			System.out.println("User not found ");
//		}

//		System.out.println("Enter addr : ");
//		String addr = sc.nextLine();
//		List<User> users = userRepository.findByAddr(addr);
//		for (User user2 : users) {
//			System.out.println(user2);
//		}
//		System.out.println("\n\n");
//		List<User> userList  = userRepository.findByAddrContaining(addr);
//		for (User user2 : userList) {
//			System.out.println(user2);
//		}

//		List<User> users = userRepository.findDistinctPeopleByAddr("Pune");
//		for (User user : users) {
//			System.out.println(user);
//		}
//
//		List<User> users = userRepository.findByNameIgnoreCase("aTHARV");
//		for (User user : users) {
//			System.out.println(user);
//		}

//		List<User> users = userRepository.findByAddrOrderByNameDesc("Pune");
//		for (User user : users) {
//			System.out.println(user);
//		}

//		List<User> users = userRepository.findByBirthBetween(LocalDate.of(1950,01, 01),
//				LocalDate.of(2000, 12, 31));
//		for (User user : users) {
//			System.out.println(user);
//		}
//
//		List<User> users = userRepository.findTop3ByAddrContaining("Pune");
//		for (User user : users) {
//			System.out.println(user);
//		}

		List<User> users = userRepository.findByRoleIgnoreCase("role_customer");
		for (User user : users) {
			System.out.println(user);
		}

	}
}
