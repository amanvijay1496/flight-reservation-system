package com.cg.flightreservationsystem.utility;

import java.util.Iterator;
import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.InvalidLoginException;
import com.cg.flightreservationsystem.staticdb.Userdb;

public class UserLoginValidation {

	public static void userAuthenticate(UserDTO user) throws InvalidLoginException {
		Userdb userDbObj = new Userdb();
		int index = 0;
		userDbObj.add();
		String username = user.getUsername();
		String password = user.getPassword();
//		while (userDbObj.userList.size() > index) {
//			System.out.print(userDbObj.userList.get(index++).getUsername());
//			System.out.println(userDbObj.userList.get(index++).getPassword());
//
//		}
//		Iterator i=userDbObj.userList.iterator();
//		while(i.hasNext()) {
//			System.out.println(i.next());
//		}

		while (userDbObj.userList.size() > index) {
			if (!username.equals(userDbObj.userList.get(index++).getUsername())) {
				throw new InvalidLoginException("You are not authorized to login");
			}
			if (!password.equals(userDbObj.userList.get(index++).getPassword())) {
				throw new InvalidLoginException("You are not authorized to login");
			}

		}
	}
}
