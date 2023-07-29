package com.ht.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.PermissionDao;
import com.ht.pojo.BackGroundUser;
import com.ht.pojo.Permission;
import com.ht.service.PermissionService;
@Service
public class PermissionServiceImpl implements PermissionService{
	@Resource
	PermissionDao per;
	
	public List<Integer> selectlistbybid(String bid){
		return per.selectlistbybid(bid);
	}

	@Override
	public int deluserpermission(Map<String, Object> map) {
		return per.deluserpermission(map);
	}

	@Override
	public int adduserpermission(Map<String, Object> map) {
		return per.adduserpermission(map);
	}

	@Override
	public int delpermissionforuserid(String id) {
		// TODO Auto-generated method stub
		return per.delpermissionforuserid(id);
	}
	
}
