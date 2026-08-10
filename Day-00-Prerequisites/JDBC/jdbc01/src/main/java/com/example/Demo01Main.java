package com.example;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class Demo01Main {
	public static final String DB_Driver = "com.mysql.cj.jdbc.Driver";
	public static final String DB_URL = "jdbc:mysql://localhost:3306/test";
	public static final String DB_User = "root";
	//Write your password here
	public static final String DB_Password = "***********";

	static {
		try {
			Class.forName(DB_Driver);

		} catch (Exception e) {
			System.out.println("Connection not Found");
			System.exit(1);
		}
	}

	public static void main(String[] args) {
		try ( Connection connection = DriverManager.getConnection(DB_URL,DB_User,DB_Password) )
		{
			try( Statement statement = connection.createStatement() )
			{
				String sql = "SELECT * FROM Students";
				try( ResultSet rs = statement.executeQuery(sql))
				{
					while (rs.next()) {
						int rollNo = rs.getInt("roll");
						double marks = rs.getDouble("mark");
						String nameString = rs.getString("name");

						System.out.println("Roll no : "+ rollNo+", marks : "+marks+" , Name : "+nameString);
					}
	//Benefit of writing try-with-resource block , it automatically closes the connection
				} // rs.close();
			}//Statement.close();
		} // connection.close();
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}
