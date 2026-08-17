package com.sunbeam.domain;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString(exclude = { "passwd" })
public class User {
	private int id;
	private String name;
	private String email;
	private String passwd;
	private String addr;
	private Date birth;
	private String role;
}
