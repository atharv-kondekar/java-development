package com.sunbeam.security;


import java.util.List;

import org.springframework.boot.security.oauth2.server.resource.autoconfigure.OAuth2ResourceServerProperties.Jwt;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.nimbusds.jwt.JWT;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	AuthenticationProvider authenticationProvider(MusicUserDetailsService musicUserDetailsService ,
			PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider daoAuthenticationProvider =
				new DaoAuthenticationProvider(musicUserDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);

		return daoAuthenticationProvider;
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationProvider authenticationProvider) {
		return new ProviderManager(authenticationProvider);
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
		httpSecurity.csrf(csrf -> csrf.disable());

		httpSecurity.authorizeHttpRequests( req ->
				req
				.requestMatchers(HttpMethod.POST,"/albums").hasAnyRole("ADMIN")
				.requestMatchers( HttpMethod.GET,"/users").hasAnyRole("ADMIN")
				.requestMatchers(HttpMethod.POST,"/users").permitAll()
				.requestMatchers(HttpMethod.DELETE,"/users/**").hasAnyRole("ADMIN")
				.requestMatchers("/users/login").permitAll()
				//For Swagger
				.requestMatchers("/swagger**/**", "/v3/api-docs", "/v3/api-docs/**").permitAll()
				.anyRequest().authenticated()
			);

		httpSecurity.oauth2ResourceServer( oauth2 ->
			oauth2.jwt(Customizer.withDefaults())
		);

		httpSecurity.cors(Customizer.withDefaults());

		DefaultSecurityFilterChain chain = httpSecurity.build();
		return chain;
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();

		corsConfiguration.setAllowedOrigins( List.of("*") );
		corsConfiguration.setAllowedMethods( List.of("*") );
		corsConfiguration.setAllowedHeaders( List.of("*") );

		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource
			= new UrlBasedCorsConfigurationSource();
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);

		return urlBasedCorsConfigurationSource;
	}
}
