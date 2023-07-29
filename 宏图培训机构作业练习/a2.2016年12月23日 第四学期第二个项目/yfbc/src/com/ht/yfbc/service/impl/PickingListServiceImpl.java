package com.ht.yfbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.OutStorageDao;
import com.ht.yfbc.dao.PickingListDao;
import com.ht.yfbc.pojo.OutStorage;
import com.ht.yfbc.pojo.PickingList;
import com.ht.yfbc.service.OutStorageService;
import com.ht.yfbc.service.PickingListService;

/**
 * 
 * 拣货单层(outstorage)
 * day 2016-12-27
 * @author 刘建杰
 *
 */
@Service
public class PickingListServiceImpl implements PickingListService{

	@Resource
	private PickingListDao pickinglistdao;
	
	@Override
	public List<PickingList> selPickingList() {
		return pickinglistdao.selPickingList();
	}

	@Override
	public int addPickingList(PickingList pickinglists) {
		return pickinglistdao.addPickingList(pickinglists);
	}
}
