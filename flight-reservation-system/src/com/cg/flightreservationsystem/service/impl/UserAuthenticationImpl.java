package com.cg.flightreservationsystem.service.impl;

import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.InvalidLoginException;
import com.cg.flightreservationsystem.exception.InvalidStringException;
import com.cg.flightreservationsystem.service.UserAuthentication;
import com.cg.flightreservationsystem.utility.UserLoginValidatorUtils;
import com.cg.flightreservationsystem.utility.UsernameValidatorUtils;

/**
 * Implementation class for UserAuthentication Interface
 * 
 * @author trainee
 *
 */
public class UserAuthenticationImpl implements UserAuthentication {

	/**
	 * Login function to check input is valid or not
	 * @param user
	 * @return boolean
	 * @throws InvalidLoginException, InvalidStringException
	 */
	@Override
	public boolean login(UserDTO user) throws InvalidStringException, InvalidLoginException {

		UsernameValidatorUtils.usernameValidation(user.getUsername());
		UserLoginValidatorUtils.userAuthenticate(user);
		return true;
	}
}
