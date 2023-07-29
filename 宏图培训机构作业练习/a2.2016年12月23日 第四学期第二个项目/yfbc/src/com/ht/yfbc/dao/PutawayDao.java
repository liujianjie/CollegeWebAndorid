package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.Picking;
import com.ht.yfbc.pojo.Putaway;
import com.ht.yfbc.pojo.Stage;
import com.ht.yfbc.pojo.putaway2;
import com.ht.yfbc.pojo.putaway3;

/**
 * 摆货操作(put_away)
 * day 2016-12-28
 * @author 刘建杰
 *
 */
public interface PutawayDao {
	public List<putaway2> selPutaway();
	public int addPutaway(Putaway putaway);
	
	//根据货架id查找
	public List<putaway2> selPutawayByid(String pid);
	
	//根据摆货id查找
	public putaway2 selPutawayByPid(String pid);
	
	public List<putaway2> selPutawayBypage(Map<String, Object> map);
	
	public int updatePtbln(String pid);
	
	public List<putaway2> selPutawayBywhid(String whid);
	
	public List<putaway2> selPutawayBypageByid(Map<String, Object> map);
	
	//1月11日 移库操作的商品信息 刘建杰
	public List<putaway3> selPutawayByid3(String pid);
	public int selPutawayCount();
}
