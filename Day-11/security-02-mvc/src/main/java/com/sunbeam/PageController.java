package com.sunbeam;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;


@Controller
public class PageController {

	@RequestMapping("/admin/hello")
	public String adminHello(Principal p) {
		System.out.println("Admin Page : \n"+p);
		return "admin";
	}

	@RequestMapping("/user/hello")
	public String userHello(HttpServletRequest request) {
		Principal principal = request.getUserPrincipal();
		System.out.println("\nUser page : \n"+principal);
		return "user";
	}
}
