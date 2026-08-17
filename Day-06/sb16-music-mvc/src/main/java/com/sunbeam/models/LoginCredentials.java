package com.sunbeam.models;

import lombok.Data;
import lombok.ToString;

@Data
@ToString(exclude = { "passwd" })
public class LoginCredentials {
	private String email;
	private String passwd;
}
