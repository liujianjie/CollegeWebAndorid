package com.ht.yfbc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.PutawayDao;
import com.ht.yfbc.dao.ReceivingDao;
import com.ht.yfbc.dao.StageDao;
import com.ht.yfbc.pojo.Picking;
import com.ht.yfbc.pojo.Putaway;
import com.ht.yfbc.pojo.Stage;
import com.ht.yfbc.pojo.Warehouse2;
import com.ht.yfbc.pojo.putaway2;
import com.ht.yfbc.pojo.putaway3;
import com.ht.yfbc.service.PutawayService;
import com.ht.yfbc.service.StageService;
/**
 * 
 * putaway层(put_away)
 * day 2016-12-28
 * @author 刘建杰
 *
 */
@Service
public class PutawayServiceImpl implements PutawayService{

	@Resource
	private PutawayDao putawaydao;
	
	@Resource
	private ReceivingDao receivingdao;
	
	@Override
	public List<putaway2> selPutaway() {
		// TODO 自动生成的方法存根
		return putawaydao.selPutaway();
	}

	@Override
	public int addPutaway(Putaway putaway) {
		// TODO 自动生成的方法存根
		 int i = putawaydao.addPutaway(putaway);
		 if(i>0){
			 //修改为已摆货状态
			 receivingdao.updatePutstate(putaway.getReid());
		 }
		 return i;
	}

	@Override
	public Map<String, Object> PutawayBypage(Integer curr) {
		// TODO Auto-generated method stub
		Integer currPage=1;
		Integer pageCount=6;
		List<putaway2> lists=putawaydao.selPutaway();
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
		List<putaway2> list = putawaydao.selPutawayBypage(map);
		
		
		Map<String, Object> maps=new HashMap<String, Object>();
		maps.put("list", list);
		maps.put("totalRow", totalRow);
		maps.put("totalPage", totalPage);
		maps.put("currPage", currPage);
		maps.put("pageCount", pageCount);
		
		return maps;
	}

	@Override
	public List<putaway2> selPutawayByid(String pid) {
		// TODO Auto-generated method stub
		return putawaydao.selPutawayByid(pid);
	}

	@Override
	public putaway2 selPutawayByPid(String pid) {
		// TODO Auto-generated method stub
		return putawaydao.selPutawayByPid(pid);
	}

	@Override
	public int updatePtbln(String pid) {
		// TODO 自动生成的方法存根
		return putawaydao.updatePtbln(pid);
	}

	@Override
	public Map<String, Object> selPutawayBywhid(String whid, Integer curr) {
		Integer currPage=1;
		Integer pageCount=6;
		List<putaway2> lists=putawaydao.selPutawayBywhid(whid);
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
		map.put("whid", whid);
		List<putaway2> list = putawaydao.selPutawayBypageByid(map);
		
		
		Map<String, Object> maps=new HashMap<String, Object>();
		maps.put("list", list);
		maps.put("totalRow", totalRow);
		maps.put("totalPage", totalPage);
		maps.put("currPage", currPage);
		maps.put("pageCount", pageCount);
		
		return maps;
	}

	@Override
	public List<putaway3> selPutawayByid3(String pid) {
		// TODO 自动生成的方法存根
		return putawaydao.selPutawayByid3(pid);
	}

	

}
