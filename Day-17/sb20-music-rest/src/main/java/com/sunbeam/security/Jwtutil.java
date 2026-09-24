package com.sunbeam.security;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import io.swagger.v3.oas.annotations.servers.Server;

@Service
public class Jwtutil {
	private JwtEncoder jwtEncoder;
	private JwtDecoder jwtDecoder;

	public Jwtutil(JwtEncoder jwtEncoder, JwtDecoder jwtDecoder) {
		super();
		this.jwtEncoder = jwtEncoder;
		this.jwtDecoder = jwtDecoder;
	}

	public String createToken(Authentication authentication) {
	    Instant now = Instant.now();

	    List<String> roles = authentication.getAuthorities().stream()
	            .map(GrantedAuthority::getAuthority)
	            .collect(Collectors.toList());

	    JwtClaimsSet claims = JwtClaimsSet.builder()
	            .issuedAt(now)
	            .expiresAt(now.plusSeconds(3600))
	            .subject(authentication.getName())
	            .claim("roles", roles)
	            .build();

	    return this.jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();
	}
}
