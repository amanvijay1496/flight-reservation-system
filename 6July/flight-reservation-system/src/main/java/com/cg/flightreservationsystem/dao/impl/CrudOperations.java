package com.cg.flightreservationsystem.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.cg.flightreservationsystem.dto.Student;
import com.cg.flightreservationsystem.utility.JPAUtil;

public class CrudOperations {

	public void insertEntity() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Student student = new Student(102, "Amanvj", "aman@gmail.com");
		entityManager.persist(student);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	public void findEntity() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		Student student = entityManager.find(Student.class, 102);
		System.out.println("student firstname :: " + student.getFirstName());
		System.out.println("student email :: " + student.getEmail());
		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
