package com.khh.controller;

import com.khh.domain.Users;

//POJO(Plain Old Java Object) as Javabean(保持空參數建構子)
public class LoginController{
	//Javabean
	private Users users;
	private String username;
	private String password;
	//訊息
	private String message;
	
	public LoginController()
	{
		
	}
	//設計一個方法(控制流程) 沒有控制直接派送一個login頁面
	//Method 在MVC 通稱為action
	public String renderLogin()
	{
		//沒有處理
		return "success";
	}
	//處理登入頁面進行資料驗證action
	public String loginValid()
	{
		//1.如何擷取表單內容? 使用JavaBean
		//2.進行資料庫會員驗證(Model) 保留(Spring framework DAO設計模式)
		//假邏輯
		if(this.username.equals("eric"))
		{
			//驗證不通過
			message="驗證失敗!!"; //進入request setAttribute("message",messae)
			return "failure";
		}else{
			//通過
			message="驗證成功!!";
			this.users=new Users();
			this.users.setUsername(this.username);
			this.users.setPassword(this.password);
			return "success";
			}
	}
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	//setter and getter method 兩個去頭set/get 留下後面名字回歸匈牙利命名法 Property as <tag name="xxxx"
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
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
