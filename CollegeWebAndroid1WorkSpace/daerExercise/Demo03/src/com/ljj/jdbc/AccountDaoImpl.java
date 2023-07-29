package com.ljj.jdbc;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.ljj.dao.Account;
public class AccountDaoImpl implements AccountDao{
	// setter注入
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	// 查询
	// 通过id查询账户数据信息
	public Account findAccountById(int id){
		String sql="select * from account where id=?";
		// 创建一个BeanPropertyRowMapper对象
		RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
		// 将id绑定到sql语句中，并通过rowmapper返回一个object类型的单行记录
		return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
	}
	// 查询所有账户信息
	public List<Account> findAllAccount(){
		String sql="select * from account";
		// 创建一个新的beanpropertyrowmapper对象
		RowMapper<Account> rowMapper = new BeanPropertyRowMapper<Account>(Account.class);
		return this.jdbcTemplate.query(sql, rowMapper);
	}
	public int addAccount(Account account) {
		String sql = "insert into account(username, balance) values(?, ?)";
		// object 数组存储参数
		Object[] obj = new Object[]{account.getUsername(), account.getBalance()};
		// 执行sql语句，返回行数
		int num = this.jdbcTemplate.update(sql, obj);
		return num;
	}
	public int updateAccount(Account account) {
		String sql = "update account set username=?,balance=? where id = ?";
		// object 数组存储参数
		Object[] obj = new Object[]{account.getUsername(), account.getBalance(),account.getId()};
		// 执行sql语句，返回行数
		int num = this.jdbcTemplate.update(sql, obj);
		return num;
	}
	public int deleteAccount(int id) {
		String sql = "delete from account where id = ?";
		// 执行sql语句删除操作，返回行数
		int num = this.jdbcTemplate.update(sql, id);
		return num;
	}
}
