package com.ht.service;

import java.util.List;
import java.util.Map;

import com.ht.pojo.BackGroundUser;
import com.ht.pojo.Permission;

public interface PermissionService {
	public List<Integer> selectlistbybid(String bid);
	//ɾ��Ȩ�� �������� Ȩ�޺�id
	public int deluserpermission(Map<String,Object> map);
	
	//����Ȩ��
	public int adduserpermission(Map<String,Object> map);
	//ɾ��Ȩ�� �û�id
	public int delpermissionforuserid(String id);
}
