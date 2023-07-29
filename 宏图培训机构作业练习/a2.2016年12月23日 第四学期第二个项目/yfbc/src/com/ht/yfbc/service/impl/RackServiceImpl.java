package com.ht.yfbc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.Cars_infoDao;
import com.ht.yfbc.dao.PutawayDao;
import com.ht.yfbc.dao.RackDao;
import com.ht.yfbc.dao.WarehouseDao;
import com.ht.yfbc.pojo.Cars_info;
import com.ht.yfbc.pojo.Goodtype;
import com.ht.yfbc.pojo.Rack;
import com.ht.yfbc.pojo.Rack2;
import com.ht.yfbc.pojo.Warehouse2;
import com.ht.yfbc.pojo.putaway3;
import com.ht.yfbc.service.GoodtypeService;
import com.ht.yfbc.service.PutawayService;
import com.ht.yfbc.service.RackService;

@Service
public class RackServiceImpl implements RackService{
	@Resource
	private RackDao rDao;
	
	@Resource
	private PutawayDao ptdao;
	
	@Resource
	private GoodtypeService goodservice;
	@Resource
	private Cars_infoDao carsinfodao;
	@Resource
	private WarehouseDao warDao;

	@Override
	public int insert(Rack rack) {
		// TODO Auto-generated method stub
		return rDao.insert(rack);
	}

	@Override
	public List<Rack2> selRack(String whid) {
		// TODO Auto-generated method stub
		return rDao.selRack(whid);
	}

	@Override
	public List<Rack2> selRackforputway(Map<String, Object> map) {
		// TODO 自动生成的方法存根
		return rDao.selRackforputway(map);
	}

	@Override
	public int updaterackrsurplus(Map<String, Object> map) {
		// TODO 自动生成的方法存根
		return rDao.updaterackrsurplus(map);
	}
	
	@Override
	public Map<String,Object> selRackofMoveStorage(String whid,String userid) {
		Map<String,Object> maps = new HashMap<String,Object>();
		List<Rack2> racklist = rDao.selRack(whid);
		if(racklist.size()!=0){
			//货物
			List<putaway3> list = ptdao.selPutawayByid3(racklist.get(0).getRid());
			maps.put("list", list);
		}
		//仓库
		List<Warehouse2> warelist = warDao.selWarehouseAll();
		//这个仓库的车辆
		List<Cars_info> carsinfoslist = carsinfodao.selCars_infobywhidandstate(userid);
		//仓库 货物类型
		List<Goodtype> goodslist = goodservice.seltype();
		
		maps.put("racklist", racklist);
		maps.put("warelist", warelist);
		maps.put("carsinfoslist", carsinfoslist);
		maps.put("goodslist", goodslist);
		
		return maps;
	}
	
}
