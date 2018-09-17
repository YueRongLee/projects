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
	private String message; //掌握連接狀態資訊
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
		//1.建構DataSource(連接工廠--給一些條件 url(連接字串)/username/password/database)
		//2.載入MySQL Driver
		BasicDataSource datasource=new BasicDataSource();
		datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		//使用存取子設定
		datasource.setUrl("jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8");
		datasource.setUsername("root");
		datasource.setPassword("1111");
		String status=null;
		
		//2.跟DataSource要一條連接(連接物件具有開啟)
		try {
			Connection connection=datasource.getConnection();
			//3.如何查詢 ?可以防SQL Injection (採用參數架構)
			String sql="select * from customer where customer_id=?";
			//3.2產生命令物件 帶參數架構
			PreparedStatement st=connection.prepareStatement(sql);
			//設定參數
			st.setShort(1, Short.parseShort(customerID));
			
			//4.如何產生結果
			ResultSet rs=st.executeQuery();
			if(rs.next())
			{
				//讀取資料回來再關 查詢結果狀態?
				customers=new CustomersBean();
				//注入資訊
				customers.setCustomerID(rs.getShort("customer_id"));
				customers.setFirstName(rs.getString("first_name"));
				customers.setLastName(rs.getString("last_name"));
				customers.setEmail(rs.getString("email"));
				message=String.format("找到客戶:%s 相關記錄!!",customerID);
				connection.close();
				status="ok";
				
			}else
			{
				//訊息狀態?
				message=String.format("查無該客戶:%s 相關記錄!!",customerID);
				connection.close(); //不是立即關閉連接 收回集區 Connection Pooling
				status="no";
			}
			//5結果如何持續到View去
			//客戶查詢
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