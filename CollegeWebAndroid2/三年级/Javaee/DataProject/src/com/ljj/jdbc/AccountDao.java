package com.ljj.jdbc;

import com.ljj.dao.Account;

public interface AccountDao {
	public int addAccount(Account account);
	
	public int updateAccount(Account account);
	
	public int deleteAccount(int id);
}
