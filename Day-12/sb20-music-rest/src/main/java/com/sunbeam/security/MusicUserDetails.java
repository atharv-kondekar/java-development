package com.sunbeam.security;

import java.util.Collection;
import java.util.stream.Stream;

import javax.management.relation.Role;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.sunbeam.users.domain.User;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MusicUserDetails implements UserDetails{

	private User user;

	public MusicUserDetails(User user) {
		this.user = user;
	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return Stream.of(user.getRole())
				.map( role -> new SimpleGrantedAuthority(role))
				.toList();
	}

	@Override
	public @Nullable String getPassword() {
		return  user.getPasswd();
	}

	@Override
	public String getUsername() {
		return user.getEmail();
	}
}
