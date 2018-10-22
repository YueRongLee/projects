package com.khh.service;

import java.sql.SQLException;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.google.gson.Gson;
import com.khh.domain.Customers;
import com.khh.domain.CustomersDAO;
import com.khh.domain.IDao;
import com.khh.domain.Message;
import com.khh.domain.MySQLCustomers;
@Path("/customers")
public class CustomersService {
	@Path("/cust")
	@GET
	@Produces("application/json")
	public String getCustomers()
	{
		//�غc�Ȥ᪫��
		Customers customers=new Customers();
		customers.setCustomerID("0001");
		customers.setCompanyName("���K�����{�Ҥ���");
		customers.setAddress("�������s����");
		customers.setCountry("���إ���");
		//�p��N����ǦC�Ʀ�Json �r��??
		Gson gson=new Gson();
		String jsonString=gson.toJson(customers);
		return jsonString;
	}
	
	//�̷ӫȤ�s���d��(�浧�d��)
	@Path("/custid/{id}/rawdata")
	@GET
	@Produces("application/json")
	public String customersNyId(@PathParam("id")short customerid)
	{
		String msg=null;
		//�غc�s����Ʈw�s�����󪺤u�t �����h����
		BasicDataSource dataSource=new BasicDataSource();
		//�]�w�s����Ʈw����
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSource(dataSource); //�z�Lsetter�`�J�̦s���Y
		
		//�غc�ۭq��Dao
		IDao<MySQLCustomers> dao=new CustomersDAO();
		//�`�Jtemplate
		dao.setJdbcTemplate(template);
		MySQLCustomers result;
		try {
			result = dao.select("select customer_id,first_name,last_name,email from customer where customer_id=?",customerid);
			//�ǦC��
			Gson gson=new Gson();
			msg=gson.toJson(result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			Message message=new Message();
			message.setStatuscode(500);
			message.setErrorMessage(e.getMessage());
			Gson gson=new Gson();
			msg=gson.toJson(message);
		}
		
		return msg;
		
		
	}

}
