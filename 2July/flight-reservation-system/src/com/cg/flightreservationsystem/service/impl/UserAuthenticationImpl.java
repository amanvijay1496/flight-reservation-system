package com.cg.flightreservationsystem.service.impl;

import java.sql.SQLException;

import com.cg.flightreservationsystem.dao.UserDao;
import com.cg.flightreservationsystem.dao.impl.UserDaoImpl;
import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.FRSException;
import com.cg.flightreservationsystem.service.UserAuthentication;
import com.cg.flightreservationsystem.utility.ExceptionMessagesUtils;
import com.cg.flightreservationsystem.utility.IsUsernameValidUtils;

/**
 * Implementation class for UserAuthentication Interface
 * 
 * @author Aman
 *
 */
public class UserAuthenticationImpl implements UserAuthentication {

	/**
	 * Login function to check input is valid or not
	 * 
	 * @param user, role
	 * @return boolean
	 * @throws FRSException
	 * @throws SQLException 
	 * @throws Exception
	 */
	public boolean login(UserDTO user, String role) throws FRSException, SQLException {

		IsUsernameValidUtils.usernameValidation(user.getUsername());
		UserDao userDao = new UserDaoImpl();
		String password = userDao.findUser(user, role);
		if (user.getPassword().equals(password)) {
			return true;
		} else {
			throw new FRSException(ExceptionMessagesUtils.MESSAGE3);
		}

	}

}
