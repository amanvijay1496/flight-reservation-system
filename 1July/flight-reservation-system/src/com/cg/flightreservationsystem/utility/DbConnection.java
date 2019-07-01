package com.cg.flightreservationsystem.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	public static Connection getConnection() {
		Connection connection = null;
		if (connection == null) {
			try {
				connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "system", "system");
			} catch (Exception e) {
				System.out.println("Error Occured");
			}

		}

		return connection;
	}
}
