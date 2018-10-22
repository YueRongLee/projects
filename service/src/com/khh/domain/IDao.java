package com.khh.domain;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

//Generic
public interface IDao<T> {
	//查詢規範
	//設定一個查詢單筆紀錄方法select 
	//傳遞參數 有一段查詢敘述SQL語法 有幾個查詢key 採用不確定數量的參數
	//型別是? int String.....通稱Object
	public T select(String sql,Object...args) throws SQLException;
	public List<T> selectMany(String sql,Object...args) throws SQLException;
	//實作這一個介面的類別必須強迫注入一個依存的物件
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate);

}
