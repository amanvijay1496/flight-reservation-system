package com.cg.flightreservationsystem.dao.impl;

import java.sql.SQLException;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.flightreservationsystem.dto.AdminDTO;
import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.FRSException;
import com.cg.flightreservationsystem.utility.JPAUtil;

public class LoginDaoImpl {

	public String findUser(UserDTO user, String role) throws FRSException, SQLException {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		AdminDTO adminDTO = null;
		UserDTO userDTO = null;
		if (role.equals("Admin")) {
			adminDTO = entityManager.find(AdminDTO.class, user.getUsername());
		} else {
			userDTO = entityManager.find(UserDTO.class, user.getUsername());
		}
		System.out.println(userDTO.getPassword());
		return userDTO.getPassword();

	}
}
