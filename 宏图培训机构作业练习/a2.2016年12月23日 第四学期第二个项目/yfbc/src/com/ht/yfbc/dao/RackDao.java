package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Rack;
import com.ht.yfbc.pojo.Rack2;

public interface RackDao {
	public int insert(Rack rack);
	
	public List<Rack2> selRack(String whid);
	
	public List<Rack2> selRackforputway(Map<String,Object> map);
	
	//修改剩余大小
	public int updaterackrsurplus(Map<String,Object> map);
	//1月13日 为了 逻辑 减少
	public List<Rack> selRackofMoveStorage(String whid);
	
}
