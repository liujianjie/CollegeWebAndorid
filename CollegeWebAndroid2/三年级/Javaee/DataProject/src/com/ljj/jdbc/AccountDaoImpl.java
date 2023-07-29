package com.ljj.jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import com.ljj.dao.Account;
public class AccountDaoImpl implements AccountDao{
	// setter注入
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
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
