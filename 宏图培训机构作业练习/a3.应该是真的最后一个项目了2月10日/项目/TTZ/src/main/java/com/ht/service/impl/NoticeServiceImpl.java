package com.ht.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.NoticeDao;
import com.ht.dao.PermissionDao;
import com.ht.pojo.BackGroundUser;
import com.ht.pojo.Borrowmoney;
import com.ht.pojo.Notice;
import com.ht.pojo.Permission;
import com.ht.service.NoticeService;
import com.ht.service.PermissionService;
@Service
public class NoticeServiceImpl implements NoticeService{
	@Resource
	NoticeDao noticedao;

	@Override
	public List<Notice> selnoticelistindex() {
		return noticedao.selnoticelistindex();
	}

	@Override
	public Notice getnoticeone(String id) {
		//增加浏览次数
		Notice notice =noticedao.getnoticeone(id);
		if(notice!=null){
			noticedao.addnoticecount(id);
		}
		return notice;
	}

	@Override
	public Map<String,Object> selnoticelist(Integer cpage) {
		Integer pageCount = 8;
		Integer totalCount = noticedao.selnoticelistsize();
		Integer totalPage = (totalCount + pageCount - 1) / pageCount;

		if (cpage > totalPage) {
			cpage = totalPage;
		}
		if (cpage <= 0) {
			cpage = 1;
		}
		if (totalPage == 0) {
			totalPage = 1;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageCount", pageCount);
		map.put("currPage", cpage);
		map.put("totalPage", totalPage);
		map.put("totalCount", totalCount);

		List<Notice> nolist = noticedao.selnoticelist(map);
		map.put("nolist", nolist);

		return map;
	}

	@Override
	public List<Notice> selnoticelistback() {
		return noticedao.selnoticelistback();
	}
	
}
