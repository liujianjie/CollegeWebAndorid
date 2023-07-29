package com.ht.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.ZilaioDao;
import com.ht.pojo.Ziliao;
import com.ht.pojo.Ziliao2;
import com.ht.service.ZiliaoService;

@Service
public class ZiliaoServiceImpl implements ZiliaoService {
	@Resource
	private ZilaioDao ziDao;

	@Override
	public void insert(Ziliao ziliao) {
		// TODO Auto-generated method stub
		ziDao.insert(ziliao);
	}

	@Override
	public List<Ziliao2> selectAll() {
		// TODO Auto-generated method stub
		return ziDao.selectAll();
	}

	@Override
	public int updateSFZ(String userid, String zhungtai) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("zhutai", zhungtai);
		return ziDao.updateSFZ(map);
	}

	@Override
	public int updateGZZ(String userid, String zhungtai) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("zhutai", zhungtai);
		return ziDao.updateGZZ(map);
	}

	@Override
	public int updateSRZ(String userid, String zhungtai) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("zhutai", zhungtai);
		return ziDao.updateSRZ(map);
	}

	@Override
	public int updateJZZ(String userid, String zhungtai) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("zhutai", zhungtai);
		return ziDao.updateJZZ(map);
	}

	@Override
	public int updateXYZ(String userid, String zhungtai) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("userid", userid);
		map.put("zhutai", zhungtai);
		return ziDao.updateXYZ(map);
	}

	// 查询某个人的认证信息
	public Ziliao selectOneUserZiLiao(String userid) {
		return ziDao.selectOneUserZiLiao(userid);
	}
}
