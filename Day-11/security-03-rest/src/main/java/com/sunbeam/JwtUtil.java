package com.sunbeam;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Service;

import com.nimbusds.jwt.JWTClaimsSet;

@Service
public class JwtUtil {
	private JwtEncoder jwtEncoder;
	private JwtDecoder jwtDecoder;

	public JwtUtil(JwtEncoder jwtEncoder, JwtDecoder jwtDecoder) {
		this.jwtEncoder = jwtEncoder;
		this.jwtDecoder = jwtDecoder;
	}

	public String createToken (Authentication authentication) {
		Instant now = Instant.now();

		List<String> roles = authentication.getAuthorities().stream()
				.map(auth->auth.getAuthority())
				.collect(Collectors.toList());

		// JWT Payload
		JwtClaimsSet claims = JwtClaimsSet.builder()
				.issuedAt(now)
				.expiresAt(now.plusSeconds(3600))//1hr
				.subject(authentication.getName())
				.claim("roles", roles)
				.build();

		return jwtEncoder.encode( JwtEncoderParameters.from(claims)).getTokenValue();
	}
}
