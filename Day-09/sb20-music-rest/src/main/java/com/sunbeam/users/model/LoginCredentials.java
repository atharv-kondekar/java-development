package com.sunbeam.users.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor @NoArgsConstructor
@ToString(exclude = {"passwd"})
public class LoginCredentials {
	 private String email;
	 private String passwd;
}
