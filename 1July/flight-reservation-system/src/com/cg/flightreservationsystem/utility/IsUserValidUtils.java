package com.cg.flightreservationsystem.utility;

import java.util.Set;

import com.cg.flightreservationsystem.db.Userdb;
import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.FRSException;

/**
 * Utility Method for Login Validation
 * 
 * @author trainee
 *
 */
public class IsUserValidUtils {
	/**
	 * Method to check user is authenticate or not
	 * @param user
	 * @return boolean
	 * @throws FRSException
	 */
	public static boolean userAuthenticate(UserDTO user) throws FRSException {
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
			throw new FRSException(ExceptionMessages.MESSAGE3);
		} else {
			return true;
		}

	}
}
