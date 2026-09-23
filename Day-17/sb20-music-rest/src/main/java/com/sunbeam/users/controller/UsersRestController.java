package com.sunbeam.users.controller;

import com.sunbeam.albums.controller.AlbumController;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sunbeam.security.Jwtutil;
import com.sunbeam.security.MusicUserDetails;
import com.sunbeam.users.dto.LoginCredentialsDTO;
import com.sunbeam.users.dto.UserRequestDTO;
import com.sunbeam.users.dto.UserResponseDTO;
import com.sunbeam.users.service.UserService;
import com.sunbeam.users.utils.ApiResponse;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UsersRestController {

	private final AuthenticationManager authenticationManager;
	private UserService userService;
	private ModelMapper modelMapper;
	private Jwtutil jwtutil;

	public UsersRestController(UserService userService, ModelMapper modelMapper,
			Jwtutil jwtutil, AuthenticationManager authenticationManager) {
		this.userService = userService;
		this.modelMapper = modelMapper;
		this.jwtutil = jwtutil;
		this.authenticationManager = authenticationManager;
	}

	//Exception Handling in the REST API

	// Option 1 : Use the try-catch for every method
	@PostMapping
	public ApiResponse<UserResponseDTO> saveUser(@RequestBody UserRequestDTO userRequestDTO) {
//		try {
			UserResponseDTO userResponseDTO = userService.registerUser(userRequestDTO);
			return ApiResponse.success(userResponseDTO);
//		} catch (Exception e) {
//			return ApiResponse.error("Error : "+e.getMessage());
//		}
	}

	// Option 2 : Handle Exception in controller level - Write for Each @Controller Class
	//@ExceptionHandler//(exception = DataAccessException.class)
/*
	public ApiResponse<?> handelException(Exception e){
		return ApiResponse.error("Error : "+e.getMessage());
	}
*/
	//Option 3 : Write the @ExceptionHandler for all Controller
	// 			 @RestControllerAdvice

	@GetMapping
	public ApiResponse<List<UserResponseDTO>> getAllUsers(){
		return ApiResponse.success( userService.getAllUsers() );
	}

	@PostMapping("/{id}")
	public ApiResponse<UserResponseDTO> findById(@PathVariable int id){
		return ApiResponse.success( userService.findById(id));
	}
//
//	@PatchMapping("/{id}")
//	public ApiResponse<UserResponseDTO> updateEmail(@PathVariable int id, @RequestBody LoginCredentialsDTO lc){
//		return ApiResponse.success( userService.updateEmail(id,lc.getEmail()));
//	}

	@DeleteMapping("/{id}")
	public ApiResponse<UserResponseDTO> deleteUser(@PathVariable int id){
		return ApiResponse.success( userService.deleteById(id));
	}

	@PostMapping("/login")
	public ApiResponse<UserResponseDTO> authenticate(@RequestBody LoginCredentialsDTO lc){
//		UserResponseDTO user = userService.authenticate(lc.getEmail(), lc.getPassword());
//		return ApiResponse.success(user);

		  UsernamePasswordAuthenticationToken authenticationToken =
				new UsernamePasswordAuthenticationToken(lc.getEmail(), lc.getPassword());

		  System.out.println("Before Authentication : \n"+authenticationToken);
		  Authentication authentication = authenticationManager.authenticate(authenticationToken);
		  String token = jwtutil.createToken(authentication);

		  System.out.println("After Authentication : \n"+authentication);

		  MusicUserDetails musicUserDetails = (MusicUserDetails) authentication.getPrincipal();
		  UserResponseDTO responseDTO = modelMapper.map(musicUserDetails.getUser(), UserResponseDTO.class);
		  responseDTO.setToken(token);

		  return ApiResponse.success(responseDTO);
	}
}
