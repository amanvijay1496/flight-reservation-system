package com.cg.flightreservationsystem.utility;

import com.cg.flightreservationsystem.exception.InvalidStringException;

public class IsUsernameValidUtils {
	/**
	 * Boolean function to check whether username is valid string or not
	 * 
	 * @param username
	 * @return boolean
	 * @throws InvalidStringException
	 */
	public static boolean usernameValidation(String username) throws InvalidStringException {
		// Regex for String: username should be alphanumeric with 3 to 15 character
		// length
		if (!username.matches("^[A-Za-z0-9]{3,15}$")) {
			throw new InvalidStringException("Invalid Username");
		} else {
			return true;
		}
	}
}
