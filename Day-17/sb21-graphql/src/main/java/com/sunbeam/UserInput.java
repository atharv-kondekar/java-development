package com.sunbeam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInput {
	private String name;
	private String address;
	private String email;
	private String mobile;
}
