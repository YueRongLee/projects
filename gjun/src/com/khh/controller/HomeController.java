package com.khh.controller;
//POJO(Plain Old Java Object) 沒有負擔
public class HomeController{
	
	//自由發揮的method 配合action應對的方法
	//原則上空參數的 回應一個字串 是回給struts.xml 的action 中result 往下走依據
	public String home()
	{
		//流程...
		return "success"; //成功 往下走首頁
	}

}
