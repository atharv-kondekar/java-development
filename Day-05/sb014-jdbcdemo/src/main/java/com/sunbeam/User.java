package com.sunbeam;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor @AllArgsConstructor
@Getter @Setter @ToString(exclude = {"passwd"})
public class User {
	private int id;
	private String email;
	private String passwd;
	private String addr;
	private Date birth;
	private String role;
	private String name;
}
