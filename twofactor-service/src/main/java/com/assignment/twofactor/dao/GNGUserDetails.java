package com.assignment.twofactor.dao;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GNGUserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String id;
	private String name;
	private String password;
	private String emailId;
	private String lastName;
	private String mobile;
	private String country;
	private String userType;
	private String isTwoFaEnabled;
	private String twoFaType;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	public String getIsTwoFaEnabled() {
		return isTwoFaEnabled;
	}
	public void setIsTwoFaEnabled(String isTwoFaEnabled) {
		this.isTwoFaEnabled = isTwoFaEnabled;
	}
	public String getTwoFaType() {
		return twoFaType;
	}
	public void setTwoFaType(String twoFaType) {
		this.twoFaType = twoFaType;
	}
}
