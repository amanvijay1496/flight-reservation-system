package com.cg.flightreservationsystem.ui;

import java.util.Scanner;

import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.InvalidStringException;
import com.cg.flightreservationsystem.service.UserAuthentication;
import com.cg.flightreservationsystem.service.impl.UserAuthenticationImpl;
import com.cg.flightreservationsystem.utility.UsernameValidation;

public class HomePage {

	public static void main(String[] args) throws InvalidStringException {
		Scanner scannerObj = new Scanner(System.in);
		String choice = "";
		String username = "";
		String password = "";
		boolean loginResult = false;
		UsernameValidation userValidation = new UsernameValidation();
		UserDTO userdto = new UserDTO();
		UserAuthentication userAuthentication = new UserAuthenticationImpl();
		System.out.println("Welcome");
		while (true) {
			System.out.println("Enter 1 to Login as User");
			System.out.println("Enter 2 to Login as Admin");
			System.out.println("Enter 3 to Exit");
			choice = scannerObj.next();
			switch (choice) {
			case "1":
				System.out.println("Hello Member");
				System.out.println("Enter Your Username");
				username = scannerObj.next();
				userdto.setUsername(username);
				System.out.println("Enter Your Password");
				password = scannerObj.next();
				userdto.setPassword(password);
				try {
					loginResult = userAuthentication.login(userdto);
					System.out.println("Logged In Successful");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				
				break;
			case "2":
				System.out.println("Enter Your Username");
				username = scannerObj.next();
				System.out.println("Enter Your Password");
				password = scannerObj.next();
				break;
			case "3":
				System.exit(0);
				break;
			default:
				System.out.println("Please enter valid values");
				break;
			}

		}
	}

}
