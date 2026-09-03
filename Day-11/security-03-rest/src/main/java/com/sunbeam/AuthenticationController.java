package com.sunbeam;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

	private AuthenticationManager authenticationManager;
	private JwtUtil jwtUtil;

	public AuthenticationController(AuthenticationManager authenticationManager,JwtUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.jwtUtil=jwtUtil;
	}

	@PostMapping("/authenticate")
	public String authentication(@RequestBody LoginCredentials lc) {
		UsernamePasswordAuthenticationToken authenticationToken
			=new UsernamePasswordAuthenticationToken(lc.getEmail(), lc.getPasswd());

		Authentication authDone = authenticationManager.authenticate(authenticationToken);

		return jwtUtil.createToken(authDone);
	}
}
