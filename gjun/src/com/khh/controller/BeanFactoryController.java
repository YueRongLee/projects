package com.khh.controller;

import java.sql.Connection;
import java.sql.SQLException;

import javax.activation.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.khh.domain.CustomersBean;

public class BeanFactoryController {
	//Javabean 
	private CustomersBean customers;
	private String message;
	//Bean Factory設定一個Bean 工廠結合應用
	//介面多型化 產生一個Bean工廠結合應用系統資源
		private ApplicationContext factory=
				new ClassPathXmlApplicationContext("applicationContext.xml"); //外掛合約
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getCustomers()
	{
		//透過工廠去要一個customers物件
		customers=factory.getBean("customers",CustomersBean.class);
		//要DataSource (Connection連接工廠) xxx.class 載入那一個中繼資料
		BasicDataSource dataSource=factory.getBean("datasource",BasicDataSource.class);
		Connection connection;
		try {
			//透過DataSource去生產一個連接物件(連到資料庫)
			connection = dataSource.getConnection();
			if(!connection.isClosed())
			{
				message="資料庫連接成功";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
		}
		
		
		return "ok";
	}
	public void setCustomers(CustomersBean customers) {
		this.customers = customers;
	}
	
	

}
