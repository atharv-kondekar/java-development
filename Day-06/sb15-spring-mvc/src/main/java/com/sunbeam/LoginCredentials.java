package com.sunbeam;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Setter @Getter @ToString(exclude = {"passwd"})
public class LoginCredentials {
	private String email;
	private String passwd;
}
