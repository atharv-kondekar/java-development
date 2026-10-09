package com.sunbeam;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

	private  List<User> userList;

	public UserService() {
		userList =  new ArrayList<>();

		userList.add(new User(1, "Atharv Patil", "atharv.patil@gmail.com",
		        "Shivaji Nagar, Pune, Maharashtra", "9876543210"));

		userList.add(new User(2, "Rohit Deshmukh", "rohit.deshmukh@gmail.com",
		        "Rajarampuri, Kolhapur, Maharashtra", "8765432109"));

		userList.add(new User(3, "Sakshi Jadhav", "sakshi.jadhav@gmail.com",
		        "Tarabai Park, Kolhapur, Maharashtra", "9123456780"));

		userList.add(new User(4, "Omkar Kulkarni", "omkar.kulkarni@gmail.com",
		        "Vishrambaug, Sangli, Maharashtra", "9012345678"));

		userList.add(new User(5, "Pranav Shinde", "pranav.shinde@gmail.com",
		        "MIDC, Ichalkaranji, Maharashtra", "8899776655"));
	}

	public User findById(int id) {

		for (User user : userList) {
			if (user.getId() == id)
				return user;
		}
		return null;
	}

	public List<User> fidnAll() {
		return userList;
	}

	public User addUser(UserInput userInput) {

		int lastId=0;
		if(userList.size() > 0 ) {
			User lastUser = userList.get( userList.size()-1);
			lastId = lastUser.getId();
		}

		userList.add( new User(lastId+1,userInput.getName(),userInput.getEmail(),
				userInput.getAddress(), userInput.getMobile()));

		return userList.get( userList.size()-1);
	}
}
