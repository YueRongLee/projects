package com.khh.domain;
//Javabean 
public class RegisterBean implements java.io.Serializable {
	//封裝性Attribute
	private String userName;
	private String password;
	private String email;
	private String name;
	private String companyName;
	
	//..
	public RegisterBean()
	{
		
	}
	//Property 物件.xxx=值
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	

}
