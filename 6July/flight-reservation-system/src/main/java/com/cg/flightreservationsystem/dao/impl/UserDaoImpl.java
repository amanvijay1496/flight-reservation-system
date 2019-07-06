package com.cg.flightreservationsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.flightreservationsystem.dao.UserDao;
import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.FRSException;
import com.cg.flightreservationsystem.utility.DbConnectionUtils;
import com.cg.flightreservationsystem.utility.DbQueryUtils;
import com.cg.flightreservationsystem.utility.ExceptionMessagesUtils;

/**
 * Implementation class for Dao Layer
 * 
 * @author trainee
 *
 */
public class UserDaoImpl implements UserDao {

	Connection connection;

	/**
	 * findUser funtion to get data from database
	 * 
	 * @param user, role
	 * @return String
	 * @throws FRSException
	 * @throws SQLException
	 */

	public String findUser(UserDTO user, String role) throws FRSException, SQLException {
		// Step 1: Open a connection to the database
		Connection connection = DbConnectionUtils.getConnection();
		String query;
		if (role.equals("Admin")) {
			query = DbQueryUtils.SELECTADMIN;
		} else {
			query = DbQueryUtils.SELECTUSER;
		}
		// Step 2: Create a statement object to perform a query.
		PreparedStatement preparedSt = null;
		try {
			preparedSt = connection.prepareStatement(query);
			preparedSt.setString(1, user.getUsername());
			// Step 3: Execute the statement object and return a query resultset.
			ResultSet resultSet = preparedSt.executeQuery();
			String userData;
			// Step 4: Process the resultset.
			while (resultSet.next()) {
				userData = resultSet.getString("password");
				return userData;
			}
			// Step 5: Close the resultset
			resultSet.close();
		} catch (SQLException e) {
			throw new FRSException(ExceptionMessagesUtils.MESSAGE1);
		} finally {
			// Step 6: Close the statement objects and connection
			preparedSt.close();
			connection.close();
		}

		return null;
	}

}
