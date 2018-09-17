package com.khh.controller;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.khh.domain.IDao;
import com.khh.domain.MemberDAO;
import com.khh.domain.RegisterBean;

//�䴩���U �Ϊ̵n�J����
public class RegisterController {
	//Spring bean �u�t
	private ApplicationContext factory=new ClassPathXmlApplicationContext("applicationContext.xml");
	private String message;
	private DataSource dataSource;
	
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	//���XForm bean(Javabean)���ܦh??
	private RegisterBean form=new RegisterBean();
	
	//�Q���@�ӵ��U�e����action
	public String regirsterForm()
	{
		//�^�X�Ь��e�@�Ӫ�歶��xxx.jsp
		form.setUserName("�i�T��");
		return "register";
	}
	
	//�x�s���U���
	public String registerSave()
	{
		//1.�h��u�t�n�@��DataSource
		//BasicDataSource dataSource=factory.getBean("datasource",BasicDataSource.class);
		//2.�غc�@�ӥi�s�W�|����ƪ�DAO
		IDao dao=factory.getBean("memberDao",IDao.class);
		dataSource=((MemberDAO)dao).getDataSource();
		//IDao dao=new MemberDAO(); //�N�ӭn������u�t�n
		//3.��Ӫ���n����(���Ǧn
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
				message="�s�W�O�����\!!";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			message=e.getMessage();
		}
		//4.����s�W
		//�ϥ�form bean�i�����x�s
		
		//�x�s��Ʀb����? �p���^���s�����������J???
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
