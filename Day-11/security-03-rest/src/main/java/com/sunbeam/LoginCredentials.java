package com.sunbeam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor @AllArgsConstructor
@ToString(exclude = {"passwd"})
public class LoginCredentials {
	private String email;
	private String passwd;
}
