package com.cg.flightreservationsystem.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cg.flightreservationsystem.dao.LoginDao;
import com.cg.flightreservationsystem.dto.AdminDTO;
import com.cg.flightreservationsystem.dto.UserDTO;
import com.cg.flightreservationsystem.exception.FRSException;

@Repository
@Transactional
public class LoginDaoImpl implements LoginDao{
	@PersistenceContext
	private EntityManager entityManager;

	public boolean findUser(UserDTO user, String role) throws FRSException {
		AdminDTO adminDTO = null;
		UserDTO userDTO = null;
		if (role.equals("Admin")) {
			adminDTO = entityManager.find(AdminDTO.class, user.getUsername());
		} else {
			userDTO = entityManager.find(UserDTO.class, user.getUsername());
		}
		if (userDTO != null || adminDTO != null) {
			return true;
		}
		return false;

	}
}
