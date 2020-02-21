package com.assignment.authentication.gng.user;

import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String name;
	private String lastName;
	private String mobile;
	private String country;
	private String userType;
	private String isTwoFaEnabled;
	private String twoFaType;

	public CustomUser(GNGUserDetails gngUserDetails) {
		super(gngUserDetails.getEmailId(), gngUserDetails.getPassword(), gngUserDetails.getGrantedAuthoritiesList());
		this.id = gngUserDetails.getId();
		this.name = gngUserDetails.getName();
		this.lastName = gngUserDetails.getLastName();
		this.mobile = gngUserDetails.getMobile();
		this.country = gngUserDetails.getCountry();
		this.userType = gngUserDetails.getUserType();
		this.isTwoFaEnabled = gngUserDetails.getIsTwoFaEnabled();
		this.twoFaType = gngUserDetails.getTwoFaType();
	}

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
