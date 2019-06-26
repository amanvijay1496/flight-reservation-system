package com.cg.flightreservationsystem.service.impl;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.InvalidLoginException;
import com.cg.flightreservationsystem.exception.InvalidStringException;

public class UserAuthenticationImplTest {

	UserAuthenticationImpl userAuth = new UserAuthenticationImpl();

	/* Pass test case when user entered correct username and password */
	@Test
	public void testLoginPass() throws InvalidLoginException, InvalidStringException {

		boolean login = userAuth.login(new UserDTO("aman", "pass"));
		assertEquals(true, login);
	}

	/* Test case when user entered wrong username and password */
	@Test(expected = InvalidLoginException.class)
	public void testLoginFailed() throws InvalidLoginException, InvalidStringException {

		userAuth.login(new UserDTO("amaasdn", "pasgs"));

	}

	/* Test case when user entered username as per the requirement condition */
	@Test
	public void testLoginUsernameIsValid() throws InvalidStringException, InvalidLoginException {
		boolean login = userAuth.login(new UserDTO("aman", "pass"));
		assertEquals(true, login);
	}

	/* Test case when username is empty */
	@Test(expected = InvalidStringException.class)
	public void testLoginUsernameIsEmpty() throws InvalidStringException, InvalidLoginException {
		boolean login = userAuth.login(new UserDTO("", "pass"));
		assertEquals(true, login);
	}

	/* Test case when password is empty */
	@Test(expected = InvalidLoginException.class)
	public void testLoginPasswordIsEmpty() throws InvalidLoginException, InvalidStringException {
		userAuth.login(new UserDTO("amaasdn", ""));
	}
}
