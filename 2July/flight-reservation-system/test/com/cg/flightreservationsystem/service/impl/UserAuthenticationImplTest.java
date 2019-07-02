package com.cg.flightreservationsystem.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.FRSException;

public class UserAuthenticationImplTest {

	UserAuthenticationImpl userAuth = new UserAuthenticationImpl();

	/* Pass test case when user entered correct username and password */
	@Test
	public void testLoginPass() throws FRSException {

		boolean login = userAuth.login(new UserDTO("AMAN", "PASS123"), "Admin");
		assertEquals(true, login);
	}

	/* Test case when user entered wrong username and password */
	@Test(expected = FRSException.class)
	public void testLoginFailed() throws FRSException {

		userAuth.login(new UserDTO("amaasdn", "pasgs"), "Admin");

	}

	/* Test case when user entered username as per the requirement condition */
	@Test
	public void testLoginUsernameIsValid() throws FRSException {
		boolean login = userAuth.login(new UserDTO("AMAN", "PASS123"), "Admin");
		assertEquals(true, login);
	}

	/* Test case when username is empty */
	@Test(expected = FRSException.class)
	public void testLoginUsernameIsEmpty() throws FRSException {
		boolean login = userAuth.login(new UserDTO("", "pass"), "Admin");
		assertEquals(true, login);
	}

	/* Test case when password is empty */
	@Test(expected = FRSException.class)
	public void testLoginPasswordIsEmpty() throws FRSException {
		userAuth.login(new UserDTO("amaasdn", ""), "Admin");
	}
}
