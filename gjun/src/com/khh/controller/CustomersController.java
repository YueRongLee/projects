package com.khh.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

import com.khh.domain.CustomersBean;
import com.opensymphony.xwork2.ActionSupport;

public class CustomersController extends ActionSupport {
	private String customerID="0001";
	private String message; //�x���s�����A��T
	private CustomersBean customers;
	

	public CustomersBean getCustomers() {
		return customers;
	}
	public void setCustomers(CustomersBean customers) {
		this.customers = customers;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	public String customerqryById()
	{
		//1.�غcDataSource(�s���u�t--���@�Ǳ��� url(�s���r��)/username/password/database)
		//2.���JMySQL Driver
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		//�ϥΦs���l�]�w
		datasource.setUrl("jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8");
		datasource.setUsername("root");
		datasource.setPassword("1111");
		String status=null;
		
		//2.��DataSource�n�@���s��(�s������㦳�}��)
		try {
			Connection connection=datasource.getConnection();
			//3.�p��d�� ?�i�H��SQL Injection (�ĥΰѼƬ[�c)
			String sql="select * from customer where customer_id=?";
			//3.2���ͩR�O���� �a�ѼƬ[�c
			PreparedStatement st=connection.prepareStatement(sql);
			//�]�w�Ѽ�
			st.setShort(1, Short.parseShort(customerID));
			
			//4.�p�󲣥͵��G
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				//Ū����Ʀ^�ӦA�� �d�ߵ��G���A?
				customers=new CustomersBean();
				//�`�J��T
				customers.setCustomerID(rs.getShort("customer_id"));
				customers.setFirstName(rs.getString("first_name"));
				customers.setLastName(rs.getString("last_name"));
				customers.setEmail(rs.getString("email"));
				message=String.format("���Ȥ�:%s �����O��!!",customerID);
				connection.close();
				status="ok";
				
			}else
			{
				//�T�����A?
				message=String.format("�d�L�ӫȤ�:%s �����O��!!",customerID);
				connection.close(); //���O�ߧY�����s�� ���^���� Connection Pooling
				status="no";
			}
			//5���G�p������View�h
			//�Ȥ�d��
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
			status="no";
		}
		
		return status;
		
		
	}

	public String getCustomerID() {
		return customerID;
	}

	public void setCustomerID(String customerID) {
		this.customerID = customerID;
	}
	
}