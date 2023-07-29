package com.ht.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.RengzhengDao;
import com.ht.pojo.Rengzheng;
import com.ht.pojo.Rengzheng2;
import com.ht.service.RengzhengService;
@Service
public class RengzhengServiceImpl implements RengzhengService{
	@Resource
	private RengzhengDao renDao;
	
	@Override
	public void insert(Rengzheng ren) {
		// TODO Auto-generated method stub
		renDao.insert(ren);
	}

	@Override
	public List<Rengzheng> sel(String userid) {
		// TODO Auto-generated method stub
		return renDao.sel(userid);
	}

	@Override
	public List<Rengzheng2> selAll() {
		// TODO Auto-generated method stub
		return renDao.selAll();
	}

	@Override
	public Rengzheng selone(String userid, String rtype) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("rtype", rtype);
		return renDao.selone(map);
	}

	@Override
	public void deleteone(String userid, String rtype) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("rtype", rtype);
		renDao.deleteone(map);
	}

	@Override
	public void updatexyed(Integer xyed, String userid, String rtype) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("rtype", rtype);
		map.put("xyed", xyed);
		renDao.updatexyed(map);
	}

}
