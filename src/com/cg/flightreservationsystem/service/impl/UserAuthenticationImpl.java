package com.cg.flightreservationsystem.service.impl;

import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.InvalidLoginException;
import com.cg.flightreservationsystem.exception.InvalidStringException;
import com.cg.flightreservationsystem.service.UserAuthentication;
import com.cg.flightreservationsystem.staticdb.Userdb;
import com.cg.flightreservationsystem.utility.UserLoginValidation;
import com.cg.flightreservationsystem.utility.UsernameValidation;

public class UserAuthenticationImpl implements UserAuthentication{

	String username;
	String password;
	UsernameValidation userValidation = new UsernameValidation();
	
	
	public boolean login(UserDTO user) throws InvalidStringException, InvalidLoginException {
		
		String username = user.getUsername();
		UsernameValidation.usernameValidation(username);
		UserLoginValidation.userAuthenticate(user);
		return true;
	}
}
