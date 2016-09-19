package com.journaldev.model;

public class RegistrationUser {
	private String userName;
	private String userEmail;
	private String userCountry;
	private String userPwd;
	
	
	public RegistrationUser() {
		super();
		
	}
	public RegistrationUser(String userName, String userEmail,
			String userCountry, String userPwd) {
		super();
		this.userName = userName;
		this.userEmail = userEmail;
		this.userCountry = userCountry;
		this.userPwd = userPwd;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEMail() {
		return userEmail;
	}
	public void setUserEMail(String userEMail) {
		this.userEmail = userEMail;
	}
	public String getUserCountry() {
		return userCountry;
	}
	public void setUserCountry(String userCountry) {
		this.userCountry = userCountry;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	@Override
	public String toString() {
		return "RegistrationUser [userName=" + userName + ", userEMail="
				+ userEmail + ", userCountry=" + userCountry + ", userPwd="
				+ userPwd + "]";
	}
}
