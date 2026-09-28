package com.sunbeam;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

	private final OrderService orderService;
	private final UserService userService;

	UserController(UserService userService, OrderService orderService) {
		this.userService = userService;
		this.orderService = orderService;
	}

	@QueryMapping
	User user(@Argument int id) {
		User user =  userService.findById(id);
		return user;
	}

	@QueryMapping(name ="users")
	List<User> findAllUsers(){
		return userService.fidnAll();
	}

	@SchemaMapping
	List<Order> orders(User user){
		return orderService.findById(user.getId());
	}
}
