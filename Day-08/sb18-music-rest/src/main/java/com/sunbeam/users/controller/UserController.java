package com.sunbeam.users.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.users.domain.User;
import com.sunbeam.users.service.UserService;
import com.sunbeam.utils.ApiResponse;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@GetMapping
	public ApiResponse<List<User>> findAllUsers(){
		return ApiResponse.sucees( userService.findAllUsers() );
	}
}
