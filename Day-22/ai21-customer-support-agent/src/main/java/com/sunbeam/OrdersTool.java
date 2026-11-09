package com.sunbeam;

import java.util.List;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class OrdersTool {
	private final List<Orders> orders =
		List.of(
			new Orders(101, 1, "Laptop", 75000, "SHIPPED"),
			new Orders(102, 2, "Headphones", 5000, "DELIVERED"),
			new Orders(103, 3, "Keyboard", 3000, "PROCESSING"),
			new Orders(104, 1, "Monitor", 15000, "DELIVERED"),
			new Orders(105, 4, "Mouse", 1500, "CANCELLED")
		);

	@Tool(description = "Find the order using the given order id")
	public String customerOrder(@ToolParam(description = "Given Order id") int orderId) {
		Orders order = orders.stream()
			.filter( o -> o.getId() == orderId)
			.findFirst()
			.orElse(null);

		return " "+ order;
	}

	@Tool(description = "Find the order status using the given order id")
	public String getOrderStatus(@ToolParam(description =  "Given order id") int orderId) {
		String status =  orders.stream()
			.filter( c -> c.getId() == orderId)
			.map( order -> order.getStatus())
			.findFirst()
			.orElse("Order Not Found");

		return status;
	}

	@Tool(description = "Refund the order to given bank account id.")
	public String refundOrder(int orderId,String bankAccId) {
		Orders order =  orders.stream()
			.filter( c -> c.getId() == orderId)

			.findFirst()
			.orElse(null);

		if (order == null) return "Order not Found";

		if (!"DELIVERED".equals(order.getStatus()))
			return "Order cannot be refunded. Current status: " + order.getStatus();

		// do actual db tx here to initiate the refund

		return "Refund initiated for order "
					+ orderId
					+ " to bank account "
					+ bankAccId
					+ " for amount "
					+ order.getAmount();
	}
}
