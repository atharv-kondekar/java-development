package com.sunbeam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

	private List<Order> orderList;

	public OrderService() {
		this.orderList = new ArrayList<>();

		orderList.add(new Order(1, 45000, 1,
		        List.of(
		                new OrderItem(1, "iPhone 15", 45000)
		        )));

		orderList.add(new Order(2, 78000, 2,
		        List.of(
		                new OrderItem(2, "Samsung Galaxy S25", 55000),
		                new OrderItem(3, "Galaxy Buds", 23000)
		        )));

		orderList.add(new Order(3, 32000, 3,
		        List.of(
		                new OrderItem(4, "Dell Monitor", 18000),
		                new OrderItem(5, "Mechanical Keyboard", 8000),
		                new OrderItem(6, "Wireless Mouse", 6000)
		        )));

		orderList.add(new Order(4, 96500, 4,
		        List.of(
		                new OrderItem(7, "HP Victus Laptop", 85000),
		                new OrderItem(8, "Laptop Backpack", 3500),
		                new OrderItem(9, "Wireless Mouse", 8000)
		        )));

		orderList.add(new Order(5, 28500, 5,
		        List.of(
		                new OrderItem(10, "OnePlus Nord", 25000),
		                new OrderItem(11, "OnePlus Earbuds", 3500)
		        )));
	}

	public List<Order> findById(int id) {
		return orderList.stream()
			.filter(o -> o.getUserID() == id)
			.toList();
	}
}
