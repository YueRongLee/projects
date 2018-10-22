package com.khh.domain;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

public class CustomersDAO implements IDao<MySQLCustomers> {
	//attribute
	private JdbcTemplate jdbcTemplate;

	@Override
	public MySQLCustomers select(String sql, Object... args) {
		//使用jdbcTemplate進行單筆記錄查詢
		MySQLCustomers customers=jdbcTemplate.queryForObject(sql, args,
				//查詢後的callback 整理你要的結果
				//建構一個匿名類別的物件outer$1
				new RowMapper<MySQLCustomers>(){

					@Override
					public MySQLCustomers mapRow(ResultSet result, int arg1) throws SQLException {
						// TODO Auto-generated method stub
						//有結果直接對應第一筆
						//建構客戶物件
						MySQLCustomers customers=new MySQLCustomers();
						customers.setCustomerID(result.getShort("customer_id"));
						customers.setFirstName(result.getString("first_name"));
						customers.setLastName(result.getString("last_name"));
						customers.setEmail(result.getString("email"));
						return customers;
					}
			
		}
				);
		return customers;
		
	}

	@Override
	public List<MySQLCustomers> selectMany(String sql, Object... args) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate=jdbcTemplate; //內含DataSource
		
	}

}
