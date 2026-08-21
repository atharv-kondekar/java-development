package com.sunbeam.users.controller;

import java.security.PublicKey;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.users.domain.User;
import com.sunbeam.users.dtos.UserRequestDTO;
import com.sunbeam.users.dtos.UserResponseDTO;
import com.sunbeam.users.service.UserService;
import com.sunbeam.utils.ApiResponse;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

//	@GetMapping
//	public ApiResponse<List<User>> findAllUsers(){
//		return ApiResponse.sucees( userService.findAllUsers() );
//	}

	@GetMapping
	public ApiResponse<List<UserResponseDTO>> findAllUsers(){
		return ApiResponse.sucees( userService.findAllUsers());
	}

	@PostMapping
	public ApiResponse<UserResponseDTO> saveUser(@RequestBody UserRequestDTO userRequestDTO){
		UserResponseDTO userResponseDTO = userService.saveData(userRequestDTO);

		if ( userRequestDTO != null) {
			return ApiResponse.sucees(userResponseDTO);
		}
		else {
			return ApiResponse.failure("User could not be Saved");
		}
	}
}
