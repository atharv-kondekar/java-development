package com.sunbeam;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class OrderService {

	private List<Order> orderList;

	public OrderService() {
		this.orderList = new ArrayList<>();
		orderList.add(new Order(1,300000,1));
		orderList.add(new Order(2,450000,2));
		orderList.add(new Order(3,670000,4));
		orderList.add(new Order(4,560000,5));
		orderList.add(new Order(5,90000,2));
		orderList.add(new Order(6,500,3));
		orderList.add(new Order(7,30034,3));
	}

	public List<Order> findById(int id) {
		return orderList.stream()
			.filter(o -> o.getUserID() == id)
			.toList();
	}
}
