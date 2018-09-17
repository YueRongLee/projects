package com.khh.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

//��@�����W�d
public class MemberDAO implements IDao{
	//attribute
	private DataSource dataSource;

	@Override
	public boolean insert(String sql, Object[] args) throws SQLException {
		boolean r=false;
		//1.�P�_DataSource�O�_���`�J
		if(dataSource==null)
		{
			throw new SQLException("DataSource�S���`�J!!");
		}
		//1.�z�LDataSource�h�n�@���s������
		Connection connection=dataSource.getConnection();
		//2.�z�L�s���h�n�@�Ө㦳�y�k�[�c��PreparedStatement
		PreparedStatement st=connection.prepareStatement(sql);
		//3.�]�w�Ѽ�
		int seq=1;
		for (int s=0;s<args.length;s++,seq++)
		{
			st.setObject(seq, args[s]);
			
		}
		//4.����D�d�� �S���d�ߵ��G �a�^�v�T������
		int result=st.executeUpdate();
		if(result>0)
		{
			r=true;
		}
		connection.close();
		return r;
	}

	@Override
	public void setDataSource(DataSource dataSource) {
		this.dataSource=dataSource;
		
	}
	public DataSource getDataSource()
	{
		return dataSource;
	}

}
