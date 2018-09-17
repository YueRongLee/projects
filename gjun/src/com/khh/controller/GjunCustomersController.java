package com.khh.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.khh.domain.CustomersBean;
import com.opensymphony.xwork2.ActionSupport;

public class GjunCustomersController extends ActionSupport {
	private String firstName;
	//設定Spring Factory
	private ApplicationContext factory=new ClassPathXmlApplicationContext("applicationContext.xml");
	private CustomersBean customer;
	private String message;

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}
	//查詢特定firstName的客戶
	public String custQryByName() throws SQLException
	{
		String flag="failure";
		//使用工廠去要DataSource
		BasicDataSource dataSource=factory.getBean("datasource",BasicDataSource.class);
		//1.建構JdbcTemplate
		JdbcTemplate dao=new JdbcTemplate();
		//注入DataSource形成(DI-依賴注入)
		dao.setDataSource(dataSource);
		//進行查詢產生單筆變成物件
		try{
		String sql="select * from customer where first_name=?";
		customer=dao.queryForObject(sql,new Object[]{firstName},
				//實做一個介面 產生一個匿名類別 同時建構成物件 傳進去位址
				new RowMapper<CustomersBean>(){

					@Override
					public CustomersBean mapRow(ResultSet result, int arg1) throws SQLException {
						// TODO Auto-generated method stub
						//準備將查詢結果(對到相對記錄)封裝成客戶物件
						CustomersBean bean=new CustomersBean();
						bean.setFirstName(result.getString("first_name"));
						bean.setLastName(result.getString("last_name"));
						bean.setCustomerID(result.getShort("customer_id"));
						bean.setEmail(result.getString("email"));
						
						return bean;
					}
			
				}
				);
				//查詢有紀錄
			flag="success";
			message="找到記錄!!";
		
		}catch(Exception ex)
		{
			flag="failure";
			message="查無記錄!!";
		}
		return flag;
	}//method


	public CustomersBean getCustomer() {
		return customer;
	}


	public void setCustomer(CustomersBean customer) {
		this.customer = customer;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}
	
	
}