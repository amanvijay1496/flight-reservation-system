package com.cg.flightreservationsystem.dao;

import java.sql.SQLException;

import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.FRSException;

public interface UserDao {

	String findUser(UserDTO user, String role) throws FRSException, SQLException;

}
