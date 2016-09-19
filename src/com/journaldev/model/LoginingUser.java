package com.journaldev.model;

public class LoginingUser {

	private String userLogin;
	private String userPwd;
	
	public LoginingUser(){
		
	}
	
	public LoginingUser (String userLogin, String userPwd){
		this.userLogin = userLogin;
		this.userPwd = userPwd;
	}
	
	public String getUserLogin() {
		return userLogin;
	}
	public void setUserLogin(String userLogin) {
		this.userLogin = userLogin;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	@Override
	public String toString() {
		return "LoginingUser [userLogin=" + userLogin + ", userPwd=" + userPwd
				+ "]";
	}
	
	
}
