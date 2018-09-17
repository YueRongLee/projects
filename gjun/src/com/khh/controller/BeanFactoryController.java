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
	//Bean Factory�]�w�@��Bean �u�t���X����
	//�����h���� ���ͤ@��Bean�u�t���X���Ψt�θ귽
		private ApplicationContext factory=
				new ClassPathXmlApplicationContext("applicationContext.xml"); //�~���X��
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getCustomers()
	{
		//�z�L�u�t�h�n�@��customers����
		customers=factory.getBean("customers",CustomersBean.class);
		//�nDataSource (Connection�s���u�t) xxx.class ���J���@�Ӥ��~���
		BasicDataSource dataSource=factory.getBean("datasource",BasicDataSource.class);
		Connection connection;
		try {
			//�z�LDataSource�h�Ͳ��@�ӳs������(�s���Ʈw)
			connection = dataSource.getConnection();
			if(!connection.isClosed())
			{
				message="��Ʈw�s�����\";
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
