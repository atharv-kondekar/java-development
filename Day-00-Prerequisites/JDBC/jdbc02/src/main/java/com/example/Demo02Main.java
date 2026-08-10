package com.example;

import java.sql.Statement;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;

public class Demo02Main {
	public static final String DB_DRIVER  = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	public static final String DB_USER = "root";
	//Write your password here
	public static final String DB_PASSWORD = "******";

	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (Exception e) {
			e.printStackTrace();
			System.exit(1);
			// TODO: handle exception
		}
	}

	public static void main(String[] args) {

		try (Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD))
		{
			try(Statement stmt = connection.createStatement())
			{
				Scanner sc = new Scanner(System.in);

				System.out.println("Enter name : ");
				String name = sc.next();
				System.out.println("Enter roll no : ");
				int roll = sc.nextInt();
				System.out.println("Enter marks : ");
				double mark = sc.nextDouble();

				String sql = "INSERT INTO Students VALUES ("+roll+",'"+name+"',"+mark+")";
				int count = stmt.executeUpdate(sql);

				System.out.println("Rows Inserted : "+count);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
