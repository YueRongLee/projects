package com.khh.controller;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.khh.domain.IDao;
import com.khh.domain.MemberDAO;
import com.khh.domain.RegisterBean;

//支援註冊 或者登入驗證
public class RegisterController {
	//Spring bean 工廠
	private ApplicationContext factory=new ClassPathXmlApplicationContext("applicationContext.xml");
	private String message;
	private DataSource dataSource;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	//結合Form bean(Javabean)欄位很多??
	private RegisterBean form=new RegisterBean();
	
	//鋪成一個註冊畫面的action
	public String regirsterForm()
	{
		//回旗標派送一個表單頁面xxx.jsp
		form.setUserName("張三豐");
		return "register";
	}
	
	//儲存註冊資料
	public String registerSave()
	{
		//1.去跟工廠要一個DataSource
		//BasicDataSource dataSource=factory.getBean("datasource",BasicDataSource.class);
		//2.建構一個可新增會員資料的DAO
		IDao dao=factory.getBean("memberDao",IDao.class);
		dataSource=((MemberDAO)dao).getDataSource();
		//IDao dao=new MemberDAO(); //將來要換成跟工廠要
		//3.兩個物件要互動(哥倆好
		//dao.setDataSource(dataSource);
		String sql="insert into member(username,password,name,email,companyname) values(?,?,?,?,?)";
		try {
			boolean r=dao.insert(sql, new Object[]{
					form.getUserName(),
					form.getPassword(),
					form.getName(),
					form.getEmail(),
					form.getCompanyName()});
			if(r)
			{
				message="新增記錄成功!!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
		}
		//4.執行新增
		//使用form bean進行資料儲存
		
		//儲存資料在哪裡? 如何擷取瀏覽器表單欄位輸入???
		return "success";
		
	}
	//form setter and getter
	public RegisterBean getForm() {
		return form;
	}

	public void setForm(RegisterBean form) {
		this.form = form;
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	

}
