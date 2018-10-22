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
		//�ϥ�jdbcTemplate�i��浧�O���d��
		MySQLCustomers customers=jdbcTemplate.queryForObject(sql, args,
				//�d�᪺߫callback ��z�A�n�����G
				//�غc�@�ӰΦW���O������outer$1
				new RowMapper<MySQLCustomers>(){

					@Override
					public MySQLCustomers mapRow(ResultSet result, int arg1) throws SQLException {
						// TODO Auto-generated method stub
						//�����G���������Ĥ@��
						//�غc�Ȥ᪫��
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
		this.jdbcTemplate=jdbcTemplate; //���tDataSource
		
	}

}
