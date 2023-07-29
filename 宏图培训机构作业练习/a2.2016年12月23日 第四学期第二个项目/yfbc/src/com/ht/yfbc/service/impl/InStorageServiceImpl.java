package com.ht.yfbc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.InStorageDao;
import com.ht.yfbc.dao.StageDao;
import com.ht.yfbc.dao.WarehouseDao;
import com.ht.yfbc.pojo.InStorage;
import com.ht.yfbc.pojo.Picking;
import com.ht.yfbc.pojo.Stage;
import com.ht.yfbc.pojo.Warehouse2;
import com.ht.yfbc.service.InStorageService;
import com.ht.yfbc.service.StageService;
/**
 * 
 * instorage业务层(in_storage)
 * day 2016-12-28
 * @author 刘建杰
 *
 */
@Service
public class InStorageServiceImpl implements InStorageService{

	@Resource
	private InStorageDao instoragedao;
	
	@Resource
	private WarehouseDao wardao;
	
	@Override
	public Map<String, Object> selInStoragelist(Integer cpage,String starttime,String endtime,String whid) {
		// 分页
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("starttime", starttime);
		map.put("endtime", endtime);
		map.put("whid", whid);
		int pagecount = 5;
		int totalcount = instoragedao.selInStorageCount(map);
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
		
		List<InStorage> inlist = instoragedao.selInStoragelist(map);//分页的instorage数据
		//仓库
		List<Warehouse2> warelist = wardao.selWarehouseAll();
		
		Map<String, Object> maps=new HashMap<String, Object>();
		maps.put("currPage", cpage);
		maps.put("totalPage", totalpage);
		maps.put("pagecount", pagecount);
		maps.put("totalcount", totalcount);
		maps.put("inlist", inlist);
		maps.put("warelist", warelist);
		maps.put("starttime", starttime);
		maps.put("endtime", endtime);
		maps.put("whid", whid);
		return maps;
	}

	@Override
	public Map<String, Object> selInStoragelist2(Integer cpage,String whid,String starttime,String endtime) {
		// 分页
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("whid", whid);
		map.put("starttime", starttime);
		map.put("endtime", endtime);
		int pagecount = 5;
		int totalcount = instoragedao.selInStorageCount(map);
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
		List<InStorage> inlist = instoragedao.selInStoragelist2(map);//分页的instorage数据
		//仓库
		List<Warehouse2> warelist = wardao.selWarehouseAll();
		
		Map<String, Object> maps=new HashMap<String, Object>();
		maps.put("currPage", cpage);
		maps.put("totalPage", totalpage);
		maps.put("pagecount", pagecount);
		maps.put("totalcount", totalcount);
		maps.put("inlist", inlist);
		maps.put("starttime", starttime);
		maps.put("endtime", endtime);
		maps.put("whid", whid);
		maps.put("warelist", warelist);
		return maps;
	}
	
	@Override
	public int addInStorage(InStorage instorage) {
		// TODO 自动生成的方法存根
		return instoragedao.addInStorage(instorage);
	}

	@Override
	public InStorage selInStorage(String id) {
		return instoragedao.selInStorage(id);
	}

	
}
