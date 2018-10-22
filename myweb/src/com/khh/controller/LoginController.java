package com.khh.controller;

import com.khh.domain.Users;

//POJO(Plain Old Java Object) as Javabean(�O���ŰѼƫغc�l)
public class LoginController{
	//Javabean
	private Users users;
	private String username;
	private String password;
	//�T��
	private String message;
	
	public LoginController()
	{
		
	}
	//�]�p�@�Ӥ�k(����y�{) �S����������e�@��login����
	//Method �bMVC �q�٬�action
	public String renderLogin()
	{
		//�S���B�z
		return "success";
	}
	//�B�z�n�J�����i��������action
	public String loginValid()
	{
		//1.�p���^����椺�e? �ϥ�JavaBean
		//2.�i���Ʈw�|������(Model) �O�d(Spring framework DAO�]�p�Ҧ�)
		//���޿�
		if(this.username.equals("eric"))
		{
			//���Ҥ��q�L
			message="���ҥ���!!"; //�i�Jrequest setAttribute("message",messae)
			return "failure";
		}else{
			//�q�L
			message="���Ҧ��\!!";
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
	//setter and getter method ��ӥh�Yset/get �d�U�᭱�W�r�^�k�I���Q�R�W�k Property as <tag name="xxxx"
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
