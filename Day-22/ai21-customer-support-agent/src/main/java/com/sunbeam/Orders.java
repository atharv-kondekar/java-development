package com.sunbeam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Orders {
	private int id;
	private int customerId;
	private String product;
	private double amount;
	private String status;
}
