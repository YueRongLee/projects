package com.khh.action;
//������@�@��Controller (�S���~�ӽ� �]�S����@interface)
//JavaBean
public class HelloController {
	private String message;
	//method as Action
	public String helloWorld()
	{
		//�B�z�L�{...
		message="Hello World!";
		return "hello";
	}
	//setXxx() getXxx() �h�Y(set get)->xxx�I���Q�R�W�k �٩I��Property
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
