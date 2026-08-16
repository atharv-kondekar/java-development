package com.sunbeam;

import java.sql.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sunbeam.daos.UserDao;
import com.sunbeam.domain.User;

@SpringBootApplication
public class Sb15MusicMvcApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Sb15MusicMvcApplication.class, args);
	}

	private UserDao userDao;
	public Sb15MusicMvcApplication(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub

//		User user1 = new User(0,"Atharv","atharv@gmail.com",
//				"atharv@123","Ichalakranji",Date.valueOf("2005-07-07"),"ROLE_CUSTOMER");
//		int count1=userDao.save(user1);
//		System.out.println(count1+" Rows Affected");

//		User user2 = new User(5,"Atharv","atharv@gmail.com", "atharv@123","Pune",Date.valueOf("2005-07-07"),
//				"ROlE_CUSTOMER");
//		int count2 = userDao.update(user2);
//		System.out.println(count2+" Rows affected");

//		List<User> users = userDao.findAll();
//		if(users != null) {
//			for (User user : users) {
//				System.out.println(user);
//			}
//		}
//		else {
//			System.out.println("No Users found :(");
//		}

//		String email = "atharv@gmail.com";
//		User user =(User) userDao.findByEmail(email);
//
//		if(user != null) {
//			System.out.println(user);
//		}else {
//			System.out.println("Not Found :(");
//		}

//		Optional<User> user = userDao.findById(4);
//		if (Optional.empty() != null) {
//			System.out.println(user);
//		}
//		else {
//			System.out.println("User not found :(");
//		}
	}

}
