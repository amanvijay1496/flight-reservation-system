package com.cg.flightreservationsystem.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admin")
public class AdminDTO {

	@Id
	private String username;
	private String password;
	
	public AdminDTO() {
		
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "AdminDTO [username=" + username + ", password=" + password + "]";
	}
	
}
