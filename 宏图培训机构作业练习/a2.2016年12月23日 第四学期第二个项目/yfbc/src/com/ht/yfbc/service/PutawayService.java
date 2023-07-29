package com.ht.yfbc.service;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Putaway;
import com.ht.yfbc.pojo.putaway2;
import com.ht.yfbc.pojo.putaway3;


public interface PutawayService {
	public List<putaway2> selPutaway();
	
	
	public int addPutaway(Putaway putaway);
	public List<putaway2> selPutawayByid(String pid);
	public putaway2 selPutawayByPid(String pid);
	public Map<String, Object> PutawayBypage(Integer curr);
	//修改不在货架状态 1月5日
	public int updatePtbln(String pid);
	
	public Map<String, Object> selPutawayBywhid(String whid,Integer curr);
	//1月11日 移库操作的商品信息 刘建杰
	public List<putaway3> selPutawayByid3(String pid);
}
