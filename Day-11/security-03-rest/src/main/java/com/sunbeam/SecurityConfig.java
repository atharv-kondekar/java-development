package com.sunbeam;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.JwtGrantedAuthoritiesConverter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {

		UserDetails admin = User.builder()
				.username("admin@gmail.com")
				.password("admin@123")
				.passwordEncoder(passwd->passwordEncoder.encode(passwd))
				.roles("ADMIN")
				.build();

		UserDetails user = User.builder()
				.username("user@gmail.com")
				.password("user@123")
				.passwordEncoder(passwd->passwordEncoder.encode(passwd))
				.roles("USER")
				.build();

		UserDetails test = User.builder()
				.username("test@gmail.com")
				.password("test@123")
				.passwordEncoder(passwd->passwordEncoder.encode(passwd))
				.roles("ADMIN" , "USER")
				.build();

		return new InMemoryUserDetailsManager(admin,user,test);
	}

	@Bean
	AuthenticationProvider authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder
			passwordEncoder) {

		DaoAuthenticationProvider daoAuthenticationProvider =
				new DaoAuthenticationProvider(userDetailsService);
		daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);

		return daoAuthenticationProvider;
	}

	@Bean
	AuthenticationManager authenticationManager(AuthenticationProvider authenticationProvider) {
		return new ProviderManager(authenticationProvider);
	}

	@Bean
	SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
		httpSecurity.csrf(csrf->csrf.disable());

		httpSecurity.authorizeHttpRequests( req ->
				req
					.requestMatchers("/authenticate").permitAll()
					.requestMatchers("/admin/**").hasRole("ADMIN")
					.requestMatchers("/user/**").hasRole("USER")
					.anyRequest().authenticated()
			);

		httpSecurity.oauth2ResourceServer(
				oauth2->oauth2.jwt(Customizer.withDefaults())
				);

		DefaultSecurityFilterChain defaultSecurityFilterChain = httpSecurity.build();

		return defaultSecurityFilterChain;
	}

	@Bean
	JwtAuthenticationConverter jwtAuthenticationConverter() {

		JwtGrantedAuthoritiesConverter authoritiesConverter = new JwtGrantedAuthoritiesConverter();
		authoritiesConverter.setAuthoritiesClaimName("roles");
		authoritiesConverter.setAuthorityPrefix("");

		JwtAuthenticationConverter jwtAuthenticationConverter =
				new JwtAuthenticationConverter();

		jwtAuthenticationConverter.setJwtGrantedAuthoritiesConverter(authoritiesConverter);

		return jwtAuthenticationConverter;
	}
}
