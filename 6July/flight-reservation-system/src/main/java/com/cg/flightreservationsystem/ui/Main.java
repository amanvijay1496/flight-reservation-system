package com.cg.flightreservationsystem.ui;

import com.cg.flightreservationsystem.dao.impl.CrudOperations;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hello1");
		CrudOperations crudOperations = new CrudOperations();
//		crudOperations.insertEntity();
		crudOperations.findEntity();
	}
}
