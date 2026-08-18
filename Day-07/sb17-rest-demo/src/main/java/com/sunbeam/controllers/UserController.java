package com.sunbeam.controllers;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sunbeam.domain.User;
import com.sunbeam.services.UserService;

@Controller
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService=userService;
	}

	@GetMapping("/hello")
	public @ResponseBody String hello() {
		return "Hello world";
	}

	@GetMapping("/hi")
	public @ResponseBody String hi( @RequestParam("user") String user) {
		return "Hi "+user;
	}

	@GetMapping("/user")
	public @ResponseBody User user() {
		return new User(8,"Om","om@gmail.com","om@123","Pune",Date.valueOf("2005-03-07"),"Owmer");
	}

	@GetMapping("/test")
	public @ResponseBody Map<String,Object> test(){
		Map<String,Object> map = new HashMap<>();
		map.put("product","Iphone");
		map.put("id", 12344);
		map.put("Price",150000.3422);

		return map;
	}

	@GetMapping("/users")
	public @ResponseBody List<User> allUser(){
		return userService.findAllUsers();
	}
}
