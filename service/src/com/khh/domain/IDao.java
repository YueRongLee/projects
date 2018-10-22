package com.khh.domain;

import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

//Generic
public interface IDao<T> {
	//�d�߳W�d
	//�]�w�@�Ӭd�߳浧������kselect 
	//�ǻ��Ѽ� ���@�q�d�߱ԭzSQL�y�k ���X�Ӭd��key �ĥΤ��T�w�ƶq���Ѽ�
	//���O�O? int String.....�q��Object
	public T select(String sql,Object...args) throws SQLException;
	public List<T> selectMany(String sql,Object...args) throws SQLException;
	//��@�o�@�Ӥ��������O�����j���`�J�@�Ө̦s������
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate);

}
