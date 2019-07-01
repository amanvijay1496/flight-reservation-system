package com.cg.flightreservationsystem.service;

import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.FRSException;

public interface UserAuthentication {

	
	public boolean login(UserDTO user, String role) throws FRSException;
}
