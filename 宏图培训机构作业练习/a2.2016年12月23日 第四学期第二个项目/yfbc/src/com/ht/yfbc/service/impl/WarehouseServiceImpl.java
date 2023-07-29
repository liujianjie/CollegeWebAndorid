package com.ht.yfbc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.WarehouseDao;
import com.ht.yfbc.pojo.Warehouse;
import com.ht.yfbc.pojo.Warehouse2;
import com.ht.yfbc.service.WarehouseService;
/**
 * 仓库操作业务层
 * day 2016-12-27
 * @author 魏海明
 *
 */
@Service
public class WarehouseServiceImpl implements WarehouseService{
	@Resource
	private WarehouseDao wardao;
	@Override
	public Map<String, Object> selWarehouse(Integer curr) {
		Integer currPage=1;
		Integer pageCount=6;
		List<Warehouse2> lists=wardao.selWarehouseAll();
		Integer totalRow=lists.size();
		Integer totalPage=(totalRow+pageCount-1)/pageCount;
		
		if(curr!=null&&!curr.equals("")){
			currPage=curr;
		}
		if(currPage>totalPage){
			currPage=totalPage;
		}
		if(currPage<1){
			currPage=1;
		}
		Map<String, Object> map=new HashMap<String, Object>(); 
		map.put("max", currPage*pageCount);
		map.put("min", (currPage - 1) * pageCount);
		List<Warehouse2> list = wardao.selWarehouse(map);
		
		
		Map<String, Object> maps=new HashMap<String, Object>();
		maps.put("list", list);
		maps.put("totalRow", totalRow);
		maps.put("totalPage", totalPage);
		maps.put("currPage", currPage);
		maps.put("pageCount", pageCount);
		
		return maps;
	}
	@Override
	public int addWarehouse(Warehouse war) {
		// TODO Auto-generated method stub
		int i = wardao.addWarehouse(war);
		return i;
	}
	@Override
	public int delwar(String whid) {
		// TODO Auto-generated method stub
		return wardao.delwar(whid);
	}
	@Override
	public Warehouse2 selWarById(String whid) {
		// TODO Auto-generated method stub
		return wardao.selWarById(whid);
	}
	@Override
	public int update(Warehouse war) {
		// TODO Auto-generated method stub
		return wardao.update(war);
	}
	@Override
	public List<Warehouse2> selWarehouseAll() {
		// TODO Auto-generated method stub
		return wardao.selWarehouseAll();
	}
	@Override
	public String selWarehouseNameById(String whid) {
		// TODO Auto-generated method stub
		return wardao.selWarehouseNameById(whid);
	}
	@Override
	public Warehouse2 selWarByUserId2(String userid) {
		// TODO Auto-generated method stub
		return wardao.selWarByUserId2(userid);
	}
	
}
