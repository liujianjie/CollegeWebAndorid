package com.ht.service;

import java.util.List;
import java.util.Map;

import com.ht.pojo.BackGroundUser;

public interface BackgroundUserService {
	// ��ȡ�û���¼��Ϣ
	public BackGroundUser getBackGroudUser(Map<String, String> map);

	// ��ȡ�û��б�
	public Map<String, Object> selbackuserlist(Integer cpage);

	// ��ȡ�����û���Ϣ ���¼���Ƿֿ��ĺ�
	public BackGroundUser selBackGroudUser(String b_id);

	// �޸ĵ����û�
	public int updBackGroundUser(BackGroundUser bkuser);

	// ��ӵ����û�
	public int addBackGroundUser(BackGroundUser bkuser);

	// ɾ��
	public int delBackGroundUser(String id);

	public List<BackGroundUser> selbackuserlistAll();

	// ��֤�û����Ƿ����
	public int YanZhengBackUsername(String b_username);
}
