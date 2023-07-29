package com.ht.yfbc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.InStorageDao;
import com.ht.yfbc.dao.ReceivingDao;
import com.ht.yfbc.dao.WarehouseDao;
import com.ht.yfbc.pojo.Goodtype;
import com.ht.yfbc.pojo.InStorage;
import com.ht.yfbc.pojo.Putaway;
import com.ht.yfbc.pojo.Receiving;
import com.ht.yfbc.pojo.Warehouse2;
import com.ht.yfbc.service.GoodtypeService;
import com.ht.yfbc.service.InStorageService;
import com.ht.yfbc.service.ReceivingService;

@Service
public class ReceivingServiceImpl implements ReceivingService{

	@Resource
	private ReceivingDao receivingdao;
	
	@Resource
	private InStorageDao instoragedao;
	
	@Resource
	private GoodtypeService goodservice;
	
	@Resource
	private WarehouseDao wardao;
	
	@Override
	public Map<String, Object> selReceiving(Integer cpage,String whid,Integer unit,String sku) {
		// 分页
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("unit", unit);
		map.put("sku", sku);
		map.put("whid", whid);
		int pagecount = 5;
		int totalcount = receivingdao.selReceivingCount(map);
		int totalpage = (totalcount+pagecount-1)/pagecount;
		if(cpage>totalpage){
			cpage=totalpage;
		}
		if(cpage<=0){
			cpage=1;
		}
		
		map.put("pagecount", pagecount);
		map.put("currpage", cpage);
		map.put("totalpage", totalpage);
		List<Receiving> relist = receivingdao.selReceiving(map);//分页的数据
		
		//仓库 货物类型
		List<Goodtype> goodslist = goodservice.seltype();
		List<Warehouse2> warelist = wardao.selWarehouseAll();
		
		Map<String, Object> maps=new HashMap<String, Object>();
		maps.put("currPage", cpage);
		maps.put("totalPage", totalpage);
		maps.put("pagecount", pagecount);
		maps.put("totalcount", totalcount);
		maps.put("relist", relist);
		maps.put("warelist", warelist);
		maps.put("goodslist", goodslist);
		maps.put("whid", whid);
		maps.put("unit", unit);
		maps.put("sku", sku);
		return maps;
	}
	@Override
	public Map<String, Object> selReceiving2(Integer cpage,String whid,Integer unit,String sku) {
		// 分页
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("unit", unit);
		map.put("sku", sku);
		map.put("whid", whid);
		int pagecount = 5;
		int totalcount = receivingdao.selReceivingCount(map);
		int totalpage = (totalcount+pagecount-1)/pagecount;
		if(cpage>totalpage){
			cpage=totalpage;
		}
		if(cpage<=0){
			cpage=1;
		}
		
		map.put("pagecount", pagecount);
		map.put("currpage", cpage);
		map.put("totalpage", totalpage);
		List<Receiving> relist = receivingdao.selReceiving(map);//分页的数据
		
		//仓库 货物类型
		List<Goodtype> goodslist = goodservice.seltype();
		List<Warehouse2> warelist = wardao.selWarehouseAll();
		
		Map<String, Object> maps=new HashMap<String, Object>();
		maps.put("currPage", cpage);
		maps.put("totalPage", totalpage);
		maps.put("pagecount", pagecount);
		maps.put("totalcount", totalcount);
		maps.put("relist", relist);
		maps.put("warelist", warelist);
		maps.put("goodslist", goodslist);
		maps.put("unit", unit);
		maps.put("sku", sku);
		return maps;
	}

	@Override
	public int addReceiving(Receiving receiving) {
		//自动回滚 在xml文件中定义的事务机制
		//修改成功 更改为已收获状态
		int i = receivingdao.addReceiving(receiving);
		if(i>0){
			instoragedao.updateStorageState(receiving.getInid());
		}
		return i;
	}

}
