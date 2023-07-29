package com.ht.dao;

import java.util.List;
import java.util.Map;

import com.ht.pojo.Ttzuser;

public interface TtzuserDao {
	public void Zhuce(Ttzuser tzuser);

	public Ttzuser Login(Map<String, Object> map);

	public List<Ttzuser> selectAllTtzUser();
	
	public List<Ttzuser> selectNewuser();
	// 查询用户表
	public List UserList();

	public int updateTel(Map<String, Object> map);
	
	public int updatenewuser(Map<String, Object> map);

	public int updateZsname(Map<String, Object> map);

	public int updateZpwd(Map<String, Object> map);

	public int updateemail(Map<String, Object> map);

	public int updatepwd(Map<String, Object> map);

	// 满标之后通过复审得到借款金额
	public int updateTtzBorrowMoney(Map<String, Object> map);
	
	public int selUserMoney();
	public int selUserCount();
	//分页
	public List<Ttzuser> UsrtlistPage(Map<String, Object> map);
	
	public Ttzuser selmyuserid2(String tid);
	
	public int updateSYED(Map<String, Object> map);
	
	public int uploadhead(Map<String, Object> map);
	
	public List<Ttzuser> seluserbyname(String yonghuming);
		//查询用户
	public List<Ttzuser> selUserForbank(String username);

	// 验证用户名是否存在
	public int YanZhengUsername(String username);
	
}
