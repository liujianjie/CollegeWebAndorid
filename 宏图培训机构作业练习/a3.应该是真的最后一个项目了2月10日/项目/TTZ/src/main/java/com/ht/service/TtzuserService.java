package com.ht.service;

import java.util.List;
import java.util.Map;

import com.ht.pojo.Ttzuser;

public interface TtzuserService {
	public void Zhuce(Ttzuser ttzuser);

	public Ttzuser Login(String username, String pwd);

	public List<Ttzuser> selectAllTtzUser();

	// 查询用户表
	public List UserList();

	public int updateTel(String tel, String tid);

	public int updateZsname(String zsname, String pcard, String tid);

	public int updateZpwd(String zpwd, String tid);

	public int updateemail(String email, String tid);

	public int updatepwd(String pwd, String tid);

	// 满标之后通过复审得到借款金额
	public int updateTtzBorrowMoney(Map<String, Object> map);

	public List<Ttzuser> selectNewuser();

	public int updatenewuser(String shren, String tid);

	public int selUserMoney();

	public int selUserCount();

	// 分页
	public List<Ttzuser> UsrtlistPage(Map<String, Object> map);

	public Ttzuser selmyuserid2(String tid);

	public int updateSYED(String userid, Integer xinyong);

	public int uploadhead(String head, String tid);

	public List<Ttzuser> seluserbyname(String yonghuming);

	// 查询用户
	public List<Ttzuser> selUserForbank(String username);

	// 验证用户名是否存在
	public int YanZhengUsername(String username);

}
