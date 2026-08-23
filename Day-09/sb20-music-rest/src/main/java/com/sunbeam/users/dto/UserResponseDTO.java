package com.sunbeam.users.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor @NoArgsConstructor
// I don't Want to show the password in the "Response to User"
public class UserResponseDTO {
		private int id;
		private String name;
		private String email;
		private String address;
		private Date birth;
		private String role;
}
