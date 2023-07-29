package com.ljj.jdbc;

import java.util.List;

import com.ljj.dao.Account;

public interface AccountDao {
	public int addAccount(Account account);
	
	public int updateAccount(Account account);
	
	public int deleteAccount(int id);
	
	public Account findAccountById(int id);
	
	public List<Account> findAllAccount();
}
