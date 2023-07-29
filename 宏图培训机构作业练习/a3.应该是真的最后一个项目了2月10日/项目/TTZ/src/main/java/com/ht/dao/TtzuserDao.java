package com.ht.dao;

import java.util.List;
import java.util.Map;

import com.ht.pojo.Ttzuser;

public interface TtzuserDao {
	public void Zhuce(Ttzuser tzuser);

	public Ttzuser Login(Map<String, Object> map);

	public List<Ttzuser> selectAllTtzUser();
	
	public List<Ttzuser> selectNewuser();
	// ��ѯ�û���
	public List UserList();

	public int updateTel(Map<String, Object> map);
	
	public int updatenewuser(Map<String, Object> map);

	public int updateZsname(Map<String, Object> map);

	public int updateZpwd(Map<String, Object> map);

	public int updateemail(Map<String, Object> map);

	public int updatepwd(Map<String, Object> map);

	// ����֮��ͨ������õ������
	public int updateTtzBorrowMoney(Map<String, Object> map);
	
	public int selUserMoney();
	public int selUserCount();
	//��ҳ
	public List<Ttzuser> UsrtlistPage(Map<String, Object> map);
	
	public Ttzuser selmyuserid2(String tid);
	
	public int updateSYED(Map<String, Object> map);
	
	public int uploadhead(Map<String, Object> map);
	
	public List<Ttzuser> seluserbyname(String yonghuming);
		//��ѯ�û�
	public List<Ttzuser> selUserForbank(String username);

	// ��֤�û����Ƿ����
	public int YanZhengUsername(String username);
	
}
