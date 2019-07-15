package com.cg.flightreservationsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.FRSException;
import com.cg.flightreservationsystem.service.UserAuthentication;
import com.cg.flightreservationsystem.utility.ExceptionMessagesUtils;

@RestController
@RequestMapping(value = "/login")
public class LoginRestController {
	@Autowired
	private UserAuthentication userAuth;

	

	public void setUserAuth(UserAuthentication userAuth) {
		this.userAuth = userAuth;
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, consumes = "application/json")
	public String checkUser(@RequestBody UserDTO user) throws FRSException {

		try {
			userAuth.login(user, "User");
		} catch (Exception e) {
			throw new FRSException("Invalid Credentials, Please try Again");
		}
		return "success";
	}

	@RequestMapping(value = "/admin", method = RequestMethod.POST, consumes = "application/json")
	public String checkAdmin(@RequestBody UserDTO user) throws FRSException {
		System.out.println("hello");

		try {
			userAuth.login(user, "Admin");
		} catch (Exception e) {
			throw new FRSException(ExceptionMessagesUtils.MESSAGE3);
		}
		return "success";
	}

}
