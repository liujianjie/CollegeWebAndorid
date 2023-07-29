package com.ht.service.impl;

import java.util.List;

import com.ht.common.Hibernate_Dao;
import com.ht.service.IPhotoService;
import com.ht.vo.Photos;

public class PhotoServiceImpl extends Hibernate_Dao implements IPhotoService{

	public List list() {
		// TODO Auto-generated method stub
		return listbysql("select * from photos");
	}

	public boolean add(Photos ph) {
		// TODO Auto-generated method stub
		return addObj(ph);
	}

}
