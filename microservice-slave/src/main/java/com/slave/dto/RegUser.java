package com.slave.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "reguser")
public class RegUser {
	
	
	@Id
	// @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false, length = 45)
    private String firstname;
	
	@Column(nullable = false, length = 45)
	private String lastname;
	
	@Column(nullable = false, length = 45)
	private String username;
	
	@Column(nullable = false, length = 45)
	private String password;
	
	@Column(nullable = false, length = 45)
	private String address;
	
	@Column(nullable = false, length = 45)
	private String contactdetails;

	public RegUser() {
		super();
	}

	public RegUser(String firstname, String lastname, String username, String password, String address,
			String contactdetails) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
		this.address = address;
		this.contactdetails = contactdetails;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getContactdetails() {
		return contactdetails;
	}

	public void setContactdetails(String contactdetails) {
		this.contactdetails = contactdetails;
	}

	@Override
	public String toString() {
		return "RegUser [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password="
				+ password + ", address=" + address + ", contactdetails=" + contactdetails + "]";
	}
	
	
}
