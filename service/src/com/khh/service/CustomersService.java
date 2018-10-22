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
		//建構客戶物件
		Customers customers=new Customers();
		customers.setCustomerID("0001");
		customers.setCompanyName("巨匠高雄認證中心");
		customers.setAddress("高雄市新興區");
		customers.setCountry("中華民國");
		//如何將物件序列化成Json 字串??
		Gson gson=new Gson();
		String jsonString=gson.toJson(customers);
		return jsonString;
	}
	
	//依照客戶編號查詢(單筆查詢)
	@Path("/custid/{id}/rawdata")
	@GET
	@Produces("application/json")
	public String customersNyId(@PathParam("id")short customerid)
	{
		String msg=null;
		//建構連接資料庫連接物件的工廠 介面多型化
		BasicDataSource dataSource=new BasicDataSource();
		//設定連接資料庫條件
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/sakila?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8");
		dataSource.setUsername("root");
		dataSource.setPassword("1234");
		JdbcTemplate template=new JdbcTemplate();
		template.setDataSource(dataSource); //透過setter注入依存關係
		
		//建構自訂的Dao
		IDao<MySQLCustomers> dao=new CustomersDAO();
		//注入template
		dao.setJdbcTemplate(template);
		MySQLCustomers result;
		try {
			result = dao.select("select customer_id,first_name,last_name,email from customer where customer_id=?",customerid);
			//序列化
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
