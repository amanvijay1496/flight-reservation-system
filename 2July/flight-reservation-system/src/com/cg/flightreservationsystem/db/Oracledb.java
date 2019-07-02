package com.cg.flightreservationsystem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Oracledb {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String uname = "system";
		String passwd = "system";
		String username = "aman";
//		String query = "select user_name from usertable";
		String query = "select password from userdata where username=?";
		Class.forName("oracle.jdbc.OracleDriver");
		Connection connection = DriverManager.getConnection(url, uname, passwd);
		PreparedStatement preparedSt;
		preparedSt = connection.prepareStatement(query);
		preparedSt.setString(1, username);
		ResultSet resultSet = preparedSt.executeQuery();
		System.out.println("amanasdf");
		System.out.println(resultSet);
//		int count  = statement.executeUpdate(query);
		String userData;
		while(resultSet.next()) {
			userData = resultSet.getString("password");
			System.out.println(userData);
		}
		
		System.out.println(connection);
		preparedSt.close();
		connection.close();
		

	}
	

}

