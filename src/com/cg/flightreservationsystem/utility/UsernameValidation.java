package com.cg.flightreservationsystem.utility;

import com.cg.flightreservationsystem.exception.InvalidStringException;

public class UsernameValidation {

	public static void usernameValidation(String username) throws InvalidStringException {
		if (!username.matches("^[A-Za-z0-9]{3,15}$")) {
			throw new InvalidStringException("Invalid Username");
		}
	}
}
