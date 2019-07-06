package com.cg.flightreservationsystem.service.impl;

import java.sql.SQLException;

import com.cg.flightreservationsystem.dao.UserDao;
import com.cg.flightreservationsystem.dao.impl.LoginDaoImpl;
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
		LoginDaoImpl loginDaoImpl = new LoginDaoImpl();
		String paString = loginDaoImpl.findUser(user, role);
//		String password = userDao.findUser(user, role);
		System.out.println("asdfasd");
		System.out.println(paString);
		if (user.getPassword().equals(paString)) {
			return true;
		} else {
			throw new FRSException(ExceptionMessagesUtils.MESSAGE3);
		}

	}

}
