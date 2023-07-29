package com.ht.dao;

import java.util.List;
import java.util.Map;

import com.ht.pojo.BackGroundUser;

public interface BackgroundUserDao {
	//��ȡ�û���¼��Ϣ
	public BackGroundUser getBackGroudUser(Map<String,String> map);
	
	//��ȡ�û��б�
	public List<BackGroundUser> selbackuserlist(Map<String,Object> map);
	
	
	public List<BackGroundUser> selbackuserlistAll();
	
	//��ȡ�û��б��С
	public int selbackuserlistsize();
	
	//��ȡ�����û���Ϣ ���¼���Ƿֿ��ĺ�
	public BackGroundUser selBackGroudUser(String b_id);
	
	//�޸ĵ����û�
	public int updBackGroundUser(BackGroundUser bkuser);
	
	//��ӵ����û�
	public int addBackGroundUser(BackGroundUser bkuser);
	
	//ɾ��
	public int delBackGroundUser(String id);

	// ��֤�û����Ƿ����
	public int YanZhengBackUsername(String b_username);
}
