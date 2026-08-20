package com.sunbeam.users.domain;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor @NoArgsConstructor
@Data
@ToString(exclude = {"passwd"})
public class User {
	private int id;
	private String name;
	private String email;
	@JsonIgnore
	private String passwd;

	@JsonProperty("address")
	private String addr;
	private Date birth;
	private String role;
}
