package com.example;

import java.sql.Statement;
import java.util.Scanner;
import java.security.interfaces.RSAKey;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Demo03Main {
	public static final String DB_DRIVER  = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	public static final String DB_USER = "root";
	//Write your password here
	public static final String DB_PASSWORD = "*******";

	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated constructor stub

		try (Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD))
		{
			String sql = "SELECT * FROM Students WHERE mark > ?";
			try(PreparedStatement stmt = connection.prepareStatement(sql))
			{
				Scanner sc = new Scanner(System.in);
				System.out.println("Enter marks : ");
				double mark = sc.nextDouble();

				stmt.setDouble(1,mark);

				try(ResultSet rs = stmt.executeQuery())
				{
					while (rs.next()) {
						int roll = rs.getInt("roll");
						double marks = rs.getDouble("mark");
						String name = rs.getString("name");

						System.out.println("Name : "+name+", Roll : "+roll+", marks : "+marks);
					}
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
