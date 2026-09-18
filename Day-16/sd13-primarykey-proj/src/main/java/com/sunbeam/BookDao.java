package com.sunbeam;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Types;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

@Repository
public class BookDao {
	private DataSource dataSource;
	//@Autowired
	public BookDao(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public Double getBookPrice(int id) {
		try (Connection connection = dataSource.getConnection()) {

		    System.out.println("connection done.......");

		    try (CallableStatement stmt =
		            connection.prepareCall("{CALL getBookPrice(?, ?)}")) {

		        System.out.println("Call Done.....");

		        stmt.setInt(1, id);
		        stmt.registerOutParameter(2, Types.DOUBLE);

		        stmt.execute();

		        System.out.println("OUT VALUE = " + stmt.getObject(2));

		        double price = stmt.getDouble(2);

		        System.out.println("Price = " + price);

		        return price;
		    }

		} catch (Exception e) {
		    e.printStackTrace();
		}

		return 0.0;
	}
}
