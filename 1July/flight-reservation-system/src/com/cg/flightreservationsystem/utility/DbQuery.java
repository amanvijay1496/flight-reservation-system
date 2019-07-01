package com.cg.flightreservationsystem.utility;

public class DbQuery {

	public static final String SELECTUSER = "select password from userdata where username=?";
	public static final String SELECTADMIN = "select password from admin where username=?";
}
