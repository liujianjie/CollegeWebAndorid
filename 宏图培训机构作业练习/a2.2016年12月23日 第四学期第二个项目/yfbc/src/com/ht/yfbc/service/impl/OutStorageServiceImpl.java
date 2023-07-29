package com.ht.yfbc.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.OutStorageDao;
import com.ht.yfbc.pojo.OutStorage;
import com.ht.yfbc.pojo.putaway2;
import com.ht.yfbc.service.OutStorageService;

/**
 * 
 * 出货计划单业务层(outstorage)
 * day 2016-12-27
 * @author 刘建杰
 *
 */
@Service
public class OutStorageServiceImpl implements OutStorageService{

	@Resource
	private OutStorageDao out;
	
	@Override
	public List<OutStorage> selOutStorage() {
		// TODO �Զ���ɵķ������
		return out.selOutStorage();
	}

	@Override
	public int addOutStorage(OutStorage outstorage) {
		return out.addOutStorage(outstorage);
	}

	@Override
	public Map<String, Object> selOutStoragePage(Integer curr) {
		Integer currPage=1;
		Integer pageCount=6;
		List<OutStorage> lists=out.selOutStorage();
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
		List<OutStorage> list = out.selOutStoragePage(map);
		
		
		Map<String, Object> maps=new HashMap<String, Object>();
		maps.put("list", list);
		maps.put("totalRow", totalRow);
		maps.put("totalPage", totalPage);
		maps.put("currPage", currPage);
		maps.put("pageCount", pageCount);
		
		return maps;
	}

	@Override
	public OutStorage selOutByid(String outid) {
		// TODO Auto-generated method stub
		return out.selOutByid(outid);
	}

	@Override
	public int updateState(String outid) {
		// TODO Auto-generated method stub
		return out.updateState(outid);
	}

	@Override
	public Map<String, Object> selOutStoragePage2(Integer curr, String whid) {
		Integer currPage=1;
		Integer pageCount=6;
		List<OutStorage> lists=out.selOutByWhid(whid);
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
		List<OutStorage> list = out.selOutStoragePage2(map);
		
		
		Map<String, Object> maps=new HashMap<String, Object>();
		maps.put("list", list);
		maps.put("totalRow", totalRow);
		maps.put("totalPage", totalPage);
		maps.put("currPage", currPage);
		maps.put("pageCount", pageCount);
		
		return maps;
	}

	@Override
	public List<OutStorage> selOutByWhid(String whid) {
		// TODO Auto-generated method stub
		return out.selOutByWhid(whid);
	}
}
