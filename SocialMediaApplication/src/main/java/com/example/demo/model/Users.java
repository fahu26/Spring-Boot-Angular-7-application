package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "users", schema = "fahim")
@Entity
public class Users {
	
	@Id
	@Column
	private String username;
	
	@Column
	private String password;
	
	@Column
	private String email;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Users(String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	public Users(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public Users() {
		
	}
	
}
