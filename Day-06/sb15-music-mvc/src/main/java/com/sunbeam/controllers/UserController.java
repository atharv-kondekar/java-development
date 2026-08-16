package com.sunbeam.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sunbeam.domain.User;
import com.sunbeam.models.LoginCredentials;
import com.sunbeam.services.UserService;

@Controller
public class UserController {
	private UserService userService;

	public UserController(UserService userService) {
		this.userService=userService;
	}

	@RequestMapping("/login")
	public String authenticateUser(LoginCredentials lc) {

		User user = userService.authenticate(lc);

		if(user!=null) {
			if(user.getRole().equals("ROLE_ADMIN")) {
				return "forward:/usermanagment";
			}
			else {
				return "forward:/album";
			}
		}
		else {
			return "failed";
		}
	}

	@RequestMapping("/usermanagment")
	public String StringgetAllUsers(Model model) {
		List<User> userList = userService.getUsers();
		model.addAttribute("userList", userList);
		return "users";
	}
}
