package com.cg.flightreservationsystem.db;

import java.util.HashSet;
import java.util.Set;

import com.cg.flightreservationsystem.dto.UserDTO;

/**
 * Static DB Class
 * 
 * @author trainee
 *
 */
public class Userdb {

	public static Set<UserDTO> userSet = new HashSet<UserDTO>();
	/**
	 * Method to add entries in Set
	 */
	public void add() {
		userSet.add(new UserDTO("aman", "pass"));
		userSet.add(new UserDTO("vijay", "pass123"));
		userSet.add(new UserDTO("naman", "pass1234"));
		userSet.add(new UserDTO("Aman121", "pass12345"));
		userSet.add(new UserDTO("Amanvijay", "pass987"));
	}

	@Override
	public String toString() {
		return "Userdb [userList=" + userSet + "]";
	}
}
