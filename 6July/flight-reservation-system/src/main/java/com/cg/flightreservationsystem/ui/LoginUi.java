package com.cg.flightreservationsystem.ui;

import java.util.Scanner;

import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.service.UserAuthentication;
import com.cg.flightreservationsystem.service.impl.UserAuthenticationImpl;

/**
 * Login Ui Main Class
 * 
 * @author Aman
 *
 */
public class LoginUi {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scannerObj = new Scanner(System.in);
		/**
		 * Variables Declaration
		 */
		String choice="";
		String username;
		String password;
		/** References of Methods and DTO */
		UserDTO userdto = new UserDTO();
		UserAuthentication userAuth = new UserAuthenticationImpl();
		System.out.println("Welcome Guest");
		while (true) {
			System.out.println("Enter 1 to Login as User");
			System.out.println("Enter 2 to login as Admin");
			System.out.println("Enter 3 to Exit");
			choice = scannerObj.next();
			switch (choice) {
			/* Switch Case for Login Operation */
			case "1":
				System.out.println("Hello Member");
				System.out.println("Enter Your Username");
				username = scannerObj.next();
				userdto.setUsername(username);
				System.out.println("Enter Your Password");
				password = scannerObj.next();
				userdto.setPassword(password);
				try {
					userAuth.login(userdto, "User");
					System.out.println("Logged In Successful");
					while (true) {
						System.out.println("Press 1 to logout");
						String userInput = scannerObj.next();
						// Switch Case for Logout
						switch (userInput) {
						case "1":
							System.out.println("Logout Successful :)");
							scannerObj.close();
							System.exit(0);
							break;

						default:
							System.out.println("Enter Valid Input");
							break;
						}
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
					System.out.println(e.getStackTrace());
					
				}

				break;
			case "2":
				System.out.println("Hello Admin");
				System.out.println("Enter Your Username");
				username = scannerObj.next();
				userdto.setUsername(username);
				System.out.println("Enter Your Password");
				password = scannerObj.next();
				userdto.setPassword(password);
				try {
					userAuth.login(userdto, "Admin");
					System.out.println("Logged In Successful");
					while (true) {
						System.out.println("Press 1 to logout");
						String userInput = scannerObj.next();
						// Switch Case for Logout
						switch (userInput) {
						case "1":
							System.out.println("Logout Successful :)");
							scannerObj.close();
							System.exit(0);
							break;

						default:
							System.out.println("Enter Valid Input");
							break;
						}
					}

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}

				break;
			case "3":
				System.out.println("Successful Exit");
				scannerObj.close();
				System.exit(0);
				break;
			default:
				System.out.println("Please enter valid inputs");
				break;
			}

		}
	}

}
