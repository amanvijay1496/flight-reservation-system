package com.cg.flightreservationsystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.flightreservationsystem.dao.UserDao;
import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.FRSException;
import com.cg.flightreservationsystem.utility.DbConnection;
import com.cg.flightreservationsystem.utility.DbQuery;
import com.cg.flightreservationsystem.utility.ExceptionMessages;

public class UserDaoImpl implements UserDao {
	Connection connection = DbConnection.getConnection();

	@Override
	public String isLoginValid(UserDTO user, String role) throws FRSException {
		String query = "";
		if (role.equals("Admin")) {
			query = DbQuery.SELECTADMIN;
		} else {
			query = DbQuery.SELECTUSER;
		}
		PreparedStatement preparedSt;
		try {
			preparedSt = connection.prepareStatement(query);
			preparedSt.setString(1, user.getUsername());
			ResultSet resultSet = preparedSt.executeQuery();
			String userData = "";
			while (resultSet.next()) {
				userData = resultSet.getString("password");
				return userData;
			}
		} catch (SQLException e) {
			throw new FRSException(ExceptionMessages.MESSAGE1);
		}

		return null;
	}

}
