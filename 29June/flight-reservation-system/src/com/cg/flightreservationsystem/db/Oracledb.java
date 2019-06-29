package com.cg.flightreservationsystem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Oracledb {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uname = "system";
		String passwd = "system";
//		String query = "select user_name from usertable";
		String query = "insert into usertable values(103, 'Amanvj', 'pass1234')";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection connection = DriverManager.getConnection(url, uname, passwd);
		Statement statement = connection.createStatement();
//		ResultSet resultSet = statement.executeQuery(query);
		int count  = statement.executeUpdate(query);
		String userData;
//		while(resultSet.next()) {
//			userData = resultSet.getString("user_name");
//			System.out.println(userData);
//		}
		System.out.println(count + "rows affected");
		
		System.out.println(connection);
		statement.close();
		connection.close();
		

	}
	

}

