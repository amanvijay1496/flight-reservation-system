package com.cg.flightreservationsystem.service;

import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.InvalidLoginException;
import com.cg.flightreservationsystem.exception.InvalidStringException;

public interface UserAuthentication {

	public boolean login(UserDTO user) throws InvalidStringException, InvalidLoginException;
}
