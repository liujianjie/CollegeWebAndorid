package com.ht.yfbc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.DeliveryDao;
import com.ht.yfbc.pojo.Delivery;
import com.ht.yfbc.pojo.putaway2;
import com.ht.yfbc.service.DeliveryService;
@Service
public class DeliveryServiceImpl implements DeliveryService{
	@Resource
	private DeliveryDao delDao;
	@Override
	public int insert(Delivery deli) {
		// TODO Auto-generated method stub
		return delDao.insert(deli);
	}
	@Override
	public List<Delivery> seldeAll() {
		// TODO Auto-generated method stub
		return delDao.seldeAll();
	}
	@Override
	public Map<String, Object> seldeBypage(Integer curr) {
		Integer currPage=1;
		Integer pageCount=6;
		List<Delivery> lists=delDao.seldeAll();
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
		List<Delivery> list = delDao.seldeBypage(map);
		
		
		Map<String, Object> maps=new HashMap<String, Object>();
		maps.put("list", list);
		maps.put("totalRow", totalRow);
		maps.put("totalPage", totalPage);
		maps.put("currPage", currPage);
		maps.put("pageCount", pageCount);
		
		return maps;
	}
	@Override
	public int updateStaut(String deid) {
		// TODO Auto-generated method stub
		return delDao.updateStatu(deid);
	}
	@Override
	public Map<String, Object> seldeBypage2(Integer curr, String whid) {
		Integer currPage=1;
		Integer pageCount=6;
		List<Delivery> lists=delDao.seldeAll2(whid);
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
		List<Delivery> list = delDao.seldeBypage2(map);
		
		
		Map<String, Object> maps=new HashMap<String, Object>();
		maps.put("list", list);
		maps.put("totalRow", totalRow);
		maps.put("totalPage", totalPage);
		maps.put("currPage", currPage);
		maps.put("pageCount", pageCount);
		
		return maps;
	}
	@Override
	public List<Delivery> seldeAll2(String whid) {
		// TODO Auto-generated method stub
		return delDao.seldeAll2(whid);
	}

}
