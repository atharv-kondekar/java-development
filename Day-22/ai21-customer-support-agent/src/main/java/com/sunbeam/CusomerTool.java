package com.sunbeam;

import java.util.List;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.ai.tool.annotation.ToolParam;
import org.springframework.stereotype.Component;

@Component
public class CusomerTool {

	private final List<Customer> customers =
			List.of(
				new Customer(1,"Om","om@example.com","1234567890"),
				new Customer(2,"ved","ved@example.com","1234567899"),
				new Customer(3,"sid","sid@example.com","1234567843"),
				new Customer(4,"sam","sam@example.com","1234567850"),
				new Customer(5,"bob","bob@example.com","1234567843")
			);

	@Tool(description =  "Get the cutomer information using the Given Cutomer id.")
	public String getCustomerInfo(@ToolParam(description = "Customer id") int custId) {
	 	Customer cust =  customers.stream()
			.filter( c -> c.getId() == custId)
			.findFirst()
			.orElse(null);

	 	return " "+cust;
	}
}
