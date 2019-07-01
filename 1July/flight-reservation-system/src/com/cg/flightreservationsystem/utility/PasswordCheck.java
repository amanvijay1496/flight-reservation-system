package com.cg.flightreservationsystem.utility;

import java.io.Console;

public class PasswordCheck {

	public void passwordExample() {
		Console console = System.console();
		if (console == null) {
			System.out.println("Couldn't get Console instance");
			System.exit(0);
		}

		console.printf("Testing password%n");
		char passwordArray[] = console.readPassword("Enter your secret password: ");
		console.printf("Password entered was: %s%n", new String(passwordArray));

	}

	public static void main(String[] args) {
		new PasswordCheck().passwordExample();
	}
}
