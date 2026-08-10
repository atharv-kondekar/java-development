package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Jdbc05Main {
	private static final String DB_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	private static final String DB_USER="root";
	//Write your password here
	private static final String DB_PASS="***********";

	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (Exception e) {
			// TODO: handle exception
			System.exit(1);
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
			connection.setAutoCommit(false);

			// Inputs
			System.out.print("\nEnter Amount That you wnat to tranfer : ");
			double amount = sc.nextDouble();
			System.out.println("\n Enter Sender acc no : ");
			int acc1=sc.nextInt();
			System.out.println("\n Enter Recivers acc no : ");
			int acc2 = sc.nextInt();


			String sql1 = "UPDATE accounts SET balance = balance - ? WHERE id=?";
			PreparedStatement stmt1 = connection.prepareStatement(sql1);
			stmt1.setDouble(1, amount);
			stmt1.setInt(2,acc1);
			int count1 = stmt1.executeUpdate();

			String sql2 = "UPDATE accounts SET balance = balance + ? WHERE id=?";
			PreparedStatement stmt2 = connection.prepareStatement(sql2);
			stmt2.setDouble(1, amount);
			stmt2.setInt(2,acc2);
			int count2 = stmt2.executeUpdate();

			if(count1!=1 || count2 != 1 ) {
				throw new RuntimeException("Execution Failed");
			}else {
				System.out.println("Transaction Successfull :) ");
			}

			connection.commit();

		} catch (Exception e) {

			if (connection != null)
			{
				try { // This Methods Throws Exception
					connection.rollback();
				} catch (SQLException e1) {

					e1.printStackTrace();
				}
			}
			e.printStackTrace();
		}
		finally {

			try { // This Methods Throws Exception
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			sc.close();
		}
	}
}
