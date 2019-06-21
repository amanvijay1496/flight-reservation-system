package com.cg.flightreservationsystem.staticdb;

import java.util.ArrayList;
import java.util.List;

import com.cg.flightreservationsystem.dto.UserDTO;

public class Userdb {

	public  List<UserDTO> userList = new ArrayList<UserDTO>();
	public void add( ) {
		userList.add(new UserDTO("aman", "pass"));
		userList.add(new UserDTO("vijay", "pass123"));
		userList.add(new UserDTO("naman", "pass1234"));
		userList.add(new UserDTO("Aman121", "pass12345"));
		userList.add(new UserDTO("Amanvijay", "pass987"));
	}
	public void view() {
		//for (UserDTO userDTO : userList) {
			System.out.println(userList);
			
		}
	
	
//	@Override
//	public String toString() {
//		// TODO Auto-generated method stub
//		return "aman";
//	}
		//int index = 0;         
		
//		while (userList.size() > index)
//		{
//		   System.out.println(userList.get(index++).getUsername());
//		}
	
	
}
