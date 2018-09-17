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
	//�]�wSpring Factory
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
	//�d�߯S�wfirstName���Ȥ�
	public String custQryByName() throws SQLException
	{
		String flag="failure";
		//�ϥΤu�t�h�nDataSource
		BasicDataSource dataSource=factory.getBean("datasource",BasicDataSource.class);
		//1.�غcJdbcTemplate
		JdbcTemplate dao=new JdbcTemplate();
		//�`�JDataSource�Φ�(DI-�̿�`�J)
		dao.setDataSource(dataSource);
		//�i��d�߲��ͳ浧�ܦ�����
		try{
		String sql="select * from customer where first_name=?";
		customer=dao.queryForObject(sql,new Object[]{firstName},
				//�갵�@�Ӥ��� ���ͤ@�ӰΦW���O �P�ɫغc������ �Ƕi�h��}
				new RowMapper<CustomersBean>(){

					@Override
					public CustomersBean mapRow(ResultSet result, int arg1) throws SQLException {
						// TODO Auto-generated method stub
						//�ǳƱN�d�ߵ��G(���۹�O��)�ʸ˦��Ȥ᪫��
						CustomersBean bean=new CustomersBean();
						bean.setFirstName(result.getString("first_name"));
						bean.setLastName(result.getString("last_name"));
						bean.setCustomerID(result.getShort("customer_id"));
						bean.setEmail(result.getString("email"));
						
						return bean;
					}
			
				}
				);
				//�d�ߦ�����
			flag="success";
			message="���O��!!";
		
		}catch(Exception ex)
		{
			flag="failure";
			message="�d�L�O��!!";
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