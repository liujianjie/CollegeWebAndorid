package com.ljj.jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import com.ljj.dao.Account;
public class AccountDaoImpl implements AccountDao{
	// setterע��
	private JdbcTemplate jdbcTemplate;
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
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
