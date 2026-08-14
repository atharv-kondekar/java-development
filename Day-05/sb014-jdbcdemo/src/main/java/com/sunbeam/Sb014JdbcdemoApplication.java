package com.sunbeam;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sb014JdbcdemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Sb014JdbcdemoApplication.class, args);
	}

	private UserDao userDao;

	Sb014JdbcdemoApplication(UserDao userDao,UserService userService){
		this.userDao=userDao;
		this.userService=userService;
	}

	private UserService userService;

	@Override
	public void run(String... args) throws Exception {
		//Data is added
//		User user1 = new User(0,"james@gmail","james@123","london",new Date(1950-01-01),
//				"Customer", "James Bond");
//		int count1 = userDao.save(user1);
//		System.out.println(count1+" Rows Affected");

//		User user2 = new User(4,"james@gmail","bond@007","london",
//					Date.valueOf("1960-01-01"),"Customer","James Bond");
//		int count2 = userDao.update(user2);
//		System.out.println(count2+" rows affected");

//		int userId = 4 ;
//		int count3 = userDao.deleteById(userId);
//		System.out.println(count3+" rows affected");

//		List<User> userList=userDao.findAll();
//		for (User user : userList) {
//			System.out.println(user);
//		}

//		String email = "atharv@gmail.com";
//		User user = userDao.findByEmail(email);
//
//		if(user !=null) {
//			System.out.println(user);
//		}else {
//			System.out.println("User not present");
//		}
//
//		int id = 4;
//		Optional<User> optUser = userDao.findById(id);
//		if(optUser.isPresent()) {
//			System.out.println(optUser.get());
//		}else {
//			System.out.println("not found");
//		}

		String email = "admin@gmail.com";
		String passwd = "admin@123";

		User user = userService.authenticate(email, passwd);
		if(user != null) {
			System.out.println("Welcome "+user.getName());
		}
		else {
			System.out.println("login Failed");
		}
	}
}
