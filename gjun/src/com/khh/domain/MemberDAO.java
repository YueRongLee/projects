package com.khh.domain;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.sql.DataSource;

//實作介面規範
public class MemberDAO implements IDao{
	//attribute
	private DataSource dataSource;

	@Override
	public boolean insert(String sql, Object[] args) throws SQLException {
		boolean r=false;
		//1.判斷DataSource是否有注入
		if(dataSource==null)
		{
			throw new SQLException("DataSource沒有注入!!");
		}
		//1.透過DataSource去要一條連接物件
		Connection connection=dataSource.getConnection();
		//2.透過連接去要一個具有語法架構的PreparedStatement
		PreparedStatement st=connection.prepareStatement(sql);
		//3.設定參數
		int seq=1;
		for (int s=0;s<args.length;s++,seq++)
		{
			st.setObject(seq, args[s]);
			
		}
		//4.執行非查詢 沒有查詢結果 帶回影響紀錄數
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
