package com.ht.dao;

import java.util.List;
import java.util.Map;

import com.ht.pojo.BackGroundUser;
import com.ht.pojo.Permission;

public interface PermissionDao {
	public List<Integer> selectlistbybid(String bid);
	
	//删除用户的权限 两个条件 权限和id
	public int deluserpermission(Map<String,Object> map);
	
	//增加权限
	public int adduserpermission(Map<String,Object> map);
	
	//删除权限 用户id
	public int delpermissionforuserid(String id);
}
