package com.sunbeam.practice;

import java.sql.Date;
import java.sql.JDBCType;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sb14JdbcDemoApplication implements CommandLineRunner {

	private UserDao userDao;

	public Sb14JdbcDemoApplication(UserDao userDao) {
		this.userDao=userDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(Sb14JdbcDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//		User user1 = new User(0,"sid@gmail.com","sid@123",
//				"Sangali",Date.valueOf("2006-05-27"),"Customer","Siddhant");
//		int count1 = userDao.saveRecord(user1);
//		System.out.println(count1+" Rows Affected");

//		User user2 =new User(7,"sid@gmail.com","sid@123",
//				"Pune",Date.valueOf("2006-05-27"),"Developer","Siddhant");
//		int count2 = userDao.updateRecord(user2);
//		System.out.println(count2+" Rows Affected");

//		List<User> users = userDao.findAllUsers();
//		for (User user : users) {
//			System.out.println(user);
//		}

		String email = "atharv@gmail.com";
		User user = userDao.findByEmail(email);
		if(user!= null) {
			System.out.println(user);
		}else {
			System.out.println("User not Found :( ");
		}

		int id = 7;
		Optional<User> user2 = userDao.findById(id);
		if( Optional.empty() != null) {
			System.out.println(user2);
		}else {
			System.out.println("User not Found :( ");
		}
	}
}
