package com.khh.action;
//夠資格當作一個Controller (沒有繼承誰 也沒有實作interface)
//JavaBean
public class HelloController {
	private String message;
	//method as Action
	public String helloWorld()
	{
		//處理過程...
		message="Hello World!";
		return "hello";
	}
	//setXxx() getXxx() 去頭(set get)->xxx匈牙利命名法 稱呼為Property
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
}
