package com.sunbeam;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	private int id;
	private float total;
	private int userID;
	private List<OrderItem> items;
}
