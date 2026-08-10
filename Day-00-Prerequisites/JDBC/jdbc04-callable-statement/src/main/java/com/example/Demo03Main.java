package com.example;

import java.sql.Statement;
import java.sql.Types;
import java.util.Scanner;
import java.security.interfaces.RSAKey;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Demo03Main
{
	public static final String DB_DRIVER  = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	public static final String DB_USER = "root";
	//Write your password here
	public static final String DB_PASSWORD = "***********";

	static {
		try {
			Class.forName(DB_DRIVER);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			System.exit(1);
		}
	}

	public static void main(String[] args)
	{
		try (Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD))
		{
			String sql = "CALL sp_getMakrs(?,?)";

			try(CallableStatement  stmt = connection.prepareCall(sql)){
				Scanner sc = new Scanner(System.in);

				System.out.print("Enter roll : ");
				int roll = sc.nextInt();
				stmt.setInt(1,roll);
				stmt.registerOutParameter(2, Types.DOUBLE);

				stmt.execute();
				System.out.println("Marks : "+stmt.getDouble(2));
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	// TODO Auto-generated constructor stub

			/* StoreProcedure for (IN)
			try (Connection connection = DriverManager.getConnection(DB_URL,DB_USER,DB_PASSWORD))
			{
				String sql = "CALL sp_getStrudents(?)";

				try(CallableStatement  stmt = connection.prepareCall(sql)){
					Scanner sc = new Scanner(System.in);

					System.out.print("Enter marks : ");
					double marks = sc.nextDouble();
					stmt.setDouble(1, marks);

					try(ResultSet rs = stmt.executeQuery()){
						while(rs.next()) {
							int roll = rs.getInt("roll");
							double mark = rs.getDouble("mark");
							String name = rs.getString("Name");

							System.out.println("Name : " + name +
					                   ", Roll : " + roll +
					                   ", Marks : " + mark);
						}
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			*/
}
