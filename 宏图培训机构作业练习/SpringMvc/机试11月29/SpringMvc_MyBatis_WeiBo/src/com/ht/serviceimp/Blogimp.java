package com.ht.serviceimp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import com.ht.bean.Blog;
import com.ht.daoi.BlogDaoI;
import com.ht.service.BlogI;
@Service
public class Blogimp  implements BlogI{
	
	@Resource
	BlogDaoI blogi;
	
	@Override
	public List<Blog> selbloglist(Map<String, Object> map) {
		//·ÖÒ³
		return blogi.selbloglist(map);
	}

	@Override
	public List<Blog> seluserblog(Map<String, Object> map) {
		return blogi.seluserblog(map);
	}
	public int addblog(Map<String, Object> map){
		return blogi.addblog(map);
	}

	@Override
	public int delblog(Integer id) {
		return blogi.delblog(id);
	}
	public int selbloglistcount(){
		return blogi.selbloglistcount();
	}

	@Override
	public int seluserblogcount(Integer id) {
		return blogi.seluserblogcount(id);
	}
		
}
