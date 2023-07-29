package com.ht.yfbc.dao;

import java.util.List;

import com.ht.yfbc.pojo.Permissions;
/**
 * selPermissionsList:查询所有授权表信息<br/>
 * selPermissionsNameByUserId:根据userid查询对应的授权
 * @author 刘宗龙
 *
 */
public interface PermissionsDao {
	public List<Permissions> selPermissionsList();
	public String selPermissionsByUserId(String userid);
}
