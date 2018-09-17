package com.khh.domain;

import java.sql.SQLException;

import javax.sql.DataSource;

public interface IDao {
	//規劃新增
	public boolean insert(String sql,Object[] args) throws SQLException; //類別多型化
	//強迫那一個實作類別必須要注入那一個DataSource
	public void setDataSource(DataSource dataSource); //介面多型化
	
	

}
