package com.sunbeam;

import org.springframework.security.core.userdetails.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.intercept.AuthorizationFilter;

import jakarta.annotation.security.RolesAllowed;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		UserDetails admin = User.builder()
				.username("Admin")
				.password("Admin@123")
				.passwordEncoder(passwd-> passwordEncoder.encode(passwd))
				.roles("ADMIN")
				.build();

		UserDetails user = User.builder()
				.username("User")
				.password("User@123")
				.passwordEncoder(passwd -> passwordEncoder.encode(passwd))
				.roles("USER")
				.build();

		UserDetails test = User.builder()
				.username("test")
				.password("test@123")
				.passwordEncoder(passwd -> passwordEncoder.encode(passwd))
				.roles("ADMIN","USER")
				.build();

		return new InMemoryUserDetailsManager(admin,test,user);

	}

	@Bean
	AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService
			, PasswordEncoder passwordEncoder) {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder);

		return authenticationProvider;
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationProvider authenticationProvider) {
		return new ProviderManager(authenticationProvider);
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
		//Disable CSRF
		httpSecurity.csrf( csrf-> csrf.disable());

		//Authorization filter configuration
		httpSecurity.authorizeHttpRequests( req->
				req
					.requestMatchers("/login").permitAll()
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.requestMatchers("/user/**").hasRole("USER")
					.anyRequest().authenticated()
				);

		//Log in form config
		httpSecurity.formLogin(Customizer.withDefaults());

		// build security chain
		DefaultSecurityFilterChain chain = httpSecurity.build();

		return chain;
	}
}
