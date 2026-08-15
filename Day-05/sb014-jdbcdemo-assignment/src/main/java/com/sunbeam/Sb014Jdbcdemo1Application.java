package com.sunbeam;

import java.sql.Date;

import javax.sql.RowSet;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Sb014Jdbcdemo1Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Sb014Jdbcdemo1Application.class, args);
	}

	private UserDao userDao;
	public Sb014Jdbcdemo1Application(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void run(String... args) throws Exception {

//		User user = new User(0,"atharv@gmail.com","atharv@123","Ichalakranji",
//				Date.valueOf("2005-07-31"),"Developer","Atharv");
//		int count1 = userDao.addRecord(user);
//		System.out.println(count1+" rows affected");

//		User user = new User(5,"atharv@gmail.com","atharv@1234","Pune",Date.valueOf("2005-07-31")
//				,"Developer","Atharv");
//		int count2 = userDao.updateRecord(user);
//		System.out.println(count2+" rows affected");

		int id = 6;
		int count3 = userDao.deleteUser(id);
		System.out.println(count3+" rows affected");
	}
}
