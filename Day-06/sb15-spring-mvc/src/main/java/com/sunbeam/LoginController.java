package com.sunbeam;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String doLogIn(LoginCredentials lc,Model model) {
		if( lc.getEmail().equals("admin@gmail.com") && lc.getPasswd().equals("admin@123"))
		{
			model.addAttribute("userEmail",lc.getEmail());
			return "welcome";
		}
		return "failed";
	}
}
