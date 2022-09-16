package com.slave.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reguser")
public class LogUser {

	@Id
	private int id;
	
	@Column(nullable = false, length = 45)
	private String username;
	
	@Column(nullable = false, length = 45)
	private String password;

	
	
	public LogUser() {
		super();
	}

	public LogUser(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

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

	@Override
	public String toString() {
		return "LogUser [username=" + username + ", password=" + password + "]";
	}
	
	
}
