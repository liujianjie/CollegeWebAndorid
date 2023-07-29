package com.ht.yfbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.OutStorageDao;
import com.ht.yfbc.dao.PickingDao;
import com.ht.yfbc.dao.PickingListDao;
import com.ht.yfbc.pojo.OutStorage;
import com.ht.yfbc.pojo.Picking;
import com.ht.yfbc.pojo.PickingList;
import com.ht.yfbc.service.OutStorageService;
import com.ht.yfbc.service.PickingListService;
import com.ht.yfbc.service.PickingService;

/**
 * 
 * 拣货单业务层(outstorage)
 * day 2016-12-27
 * @author 刘建杰
 *
 */
@Service
public class PickingServiceImpl implements PickingService{

	@Resource 
	private PickingDao pickingdao;
	
	@Override
	public List<Picking> selPicking() {
		return pickingdao.selPicking();
	}

	@Override
	public int addPicking(Picking pick) {
		return pickingdao.addPicking(pick);
	}

}
