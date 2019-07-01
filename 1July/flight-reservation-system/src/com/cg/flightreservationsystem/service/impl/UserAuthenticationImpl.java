package com.cg.flightreservationsystem.service.impl;

import com.cg.flightreservationsystem.dao.UserDao;
import com.cg.flightreservationsystem.dao.impl.UserDaoImpl;
import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.FRSException;
import com.cg.flightreservationsystem.service.UserAuthentication;
import com.cg.flightreservationsystem.utility.ExceptionMessages;
import com.cg.flightreservationsystem.utility.IsUsernameValidUtils;

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
	 * @throws FRSException 
	 * @throws Exception 
	 */
	public boolean login(UserDTO user, String role) throws FRSException {

		IsUsernameValidUtils.usernameValidation(user.getUsername());
		UserDao userDao = new UserDaoImpl();
		String password = userDao.isLoginValid(user, role);
		if(user.getPassword().equals(password)) {
			return true;
		}
		else {
			throw new FRSException(ExceptionMessages.MESSAGE3); 
		}
		
		
//		IsUserValidUtils.userAuthenticate(password);
//		return true;
	}
	
}
