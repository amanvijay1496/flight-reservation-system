package com.cg.flightreservationsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flightreservationsystem.dao.LoginDao;
import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.FRSException;
import com.cg.flightreservationsystem.service.UserAuthentication;
import com.cg.flightreservationsystem.utility.ExceptionMessagesUtils;
import com.cg.flightreservationsystem.utility.UsernameValidUtils;

/**
 * Implementation class for UserAuthentication Interface
 * 
 * @author Aman
 *
 */
@Service
public class UserAuthenticationImpl implements UserAuthentication {
	@Autowired
	private LoginDao loginDao;

	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	/**
	 * Login function to check input is valid or not
	 * 
	 * @param user, role
	 * @return boolean
	 * @throws FRSException
	 * @throws Exception
	 */
	public boolean login(UserDTO user, String role) throws FRSException {

		UsernameValidUtils.usernameValidation(user.getUsername());

		boolean result = loginDao.findUser(user, role);
		if (!result) {
			throw new FRSException(ExceptionMessagesUtils.MESSAGE3);

		} else
			return true;

	}

}
