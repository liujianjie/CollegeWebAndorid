package com.ht.yfbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.PermissionsDao;
import com.ht.yfbc.pojo.Permissions;
import com.ht.yfbc.service.PermissionsService;
@Service
public class PermissionsServiceImpl implements PermissionsService {
	@Resource
	private PermissionsDao permDao;
	public List<Permissions> selPermissionsList() {
		return permDao.selPermissionsList();
	}

	public String selPermissionsByUserId(String userid) {
		return permDao.selPermissionsByUserId(userid);
	}

}
