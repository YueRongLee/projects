package com.khh.domain;

import java.sql.SQLException;

import javax.sql.DataSource;

public interface IDao {
	//�W���s�W
	public boolean insert(String sql,Object[] args) throws SQLException; //���O�h����
	//�j�����@�ӹ�@���O�����n�`�J���@��DataSource
	public void setDataSource(DataSource dataSource); //�����h����
	
	

}
