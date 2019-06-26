package com.cg.flightreservationsystem.utility;

import java.util.Set;

import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.InvalidLoginException;
import com.cg.flightreservationsystem.staticdb.Userdb;

/**
 * Utility Method for Login Validation
 * 
 * @author trainee
 *
 */
public class UserLoginValidatorUtils {
	/**
	 * Method to check user is authenticate or not
	 * @param user
	 * @return boolean
	 * @throws InvalidLoginException
	 */
	public static boolean userAuthenticate(UserDTO user) throws InvalidLoginException {
		Userdb userDbObj = new Userdb();
		userDbObj.add();
		Set<UserDTO> userSet = Userdb.userSet;
		boolean flag = true;
		for (UserDTO userObj : userSet) {
			if (userObj.getUsername().equals(user.getUsername())) {
				if (userObj.getPassword().equals(user.getPassword())) {
					flag = true;
					break;

				}

			} else {
				flag = false;
			}

		}
		if (!flag) {
			throw new InvalidLoginException("You are not authorized to login");
		} else {
			return true;
		}

	}
}
