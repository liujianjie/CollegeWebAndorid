package com.ht.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.BackgroundUserDao;
import com.ht.dao.PostDao;
import com.ht.pojo.BackGroundUser;
import com.ht.pojo.Post;
import com.ht.service.BackgroundUserService;

@Service
public class BackgroundUserServiceImpL implements BackgroundUserService {

	@Resource
	BackgroundUserDao back;
	@Resource
	PostDao pdao;

	public BackGroundUser getBackGroudUser(Map<String, String> map) {
		return back.getBackGroudUser(map);
	}

	@Override
	public Map<String, Object> selbackuserlist(Integer cpage) {
		Integer pageCount = 9;
		Integer totalCount = back.selbackuserlistsize();
		Integer totalPage = (totalCount + pageCount - 1) / pageCount;

		if (cpage > totalPage) {
			cpage = totalPage;
		}
		if (cpage <= 0) {
			cpage = 1;
		}
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("pageCount", pageCount);
		map.put("currPage", cpage);
		map.put("totalPage", totalPage);
		map.put("totalCount", totalCount);

		List<BackGroundUser> list = back.selbackuserlist(map);
		List<Post> post = pdao.selpostlist();
		map.put("list", list);
		map.put("post", post);
		return map;
	}

	@Override
	public BackGroundUser selBackGroudUser(String b_id) {
		return back.selBackGroudUser(b_id);
	}

	@Override
	public int updBackGroundUser(BackGroundUser bkuser) {
		return back.updBackGroundUser(bkuser);
	}

	@Override
	public int addBackGroundUser(BackGroundUser bkuser) {
		return back.addBackGroundUser(bkuser);
	}

	// 删除
	public int delBackGroundUser(String id) {
		return back.delBackGroundUser(id);
	}

	@Override
	public List<BackGroundUser> selbackuserlistAll() {
		// TODO Auto-generated method stub
		return back.selbackuserlistAll();
	}

	// 验证用户名是否存在
	public int YanZhengBackUsername(String b_username) {
		return back.YanZhengBackUsername(b_username);
	}
}
