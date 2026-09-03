package com.sunbeam;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class ApiController {

	@GetMapping("/admin/hello")
	public String helloAdmin(Principal p) {
		System.out.println("Admin : \n"+p);
		return "Hello , Admin";
	}

	@GetMapping("/user/hello")
	public String helloUser(HttpServletRequest httpServletRequest) {
		Principal principal = httpServletRequest.getUserPrincipal();
		System.out.println("User : \n"+principal);
		return "Hello , User ";
	}
}
