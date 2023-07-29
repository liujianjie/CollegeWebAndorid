package com.ljj.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ljj.dao.Account;
public class AccountDaoImpl implements AccountDao{
	// setterע��
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	// ��ѯ
	// ͨ��id��ѯ�˻�������Ϣ
	public Account findAccountById(int id){
		String sql="select * from account where id=?";
		// ����һ��BeanPropertyRowMapper����
		RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
		// ��id�󶨵�sql����У���ͨ��rowmapper����һ��object���͵ĵ��м�¼
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}
	// ��ѯ�����˻���Ϣ
	public List<Account> findAllAccount(){
		String sql="select * from account";
		// ����һ���µ�beanpropertyrowmapper����
		RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	public int addAccount(Account account) {
		String sql = "insert into account(username, balance) values(?, ?)";
		// object ����洢����
		Object[] obj = new Object[]{account.getUsername(), account.getBalance()};
		// ִ��sql��䣬��������
		int num = this.jdbcTemplate.update(sql, obj);
		return num;
	}
	public int updateAccount(Account account) {
		String sql = "update account set username=?,balance=? where id = ?";
		// object ����洢����
		Object[] obj = new Object[]{account.getUsername(), account.getBalance(),account.getId()};
		// ִ��sql��䣬��������
		int num = this.jdbcTemplate.update(sql, obj);
		return num;
	}
	public int deleteAccount(int id) {
		String sql = "delete from account where id = ?";
		// ִ��sql���ɾ����������������
		int num = this.jdbcTemplate.update(sql, id);
		return num;
	}
}
