package com.cg.flightreservationsystem.dao;

import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.FRSException;

public interface UserDao {

	String isLoginValid(UserDTO user, String role) throws FRSException;

}
