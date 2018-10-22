package com.khh.domain;
//Javabean
public class Users implements java.io.Serializable{
	private String username;
	private String password;
	//setter and getter
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
	

}
