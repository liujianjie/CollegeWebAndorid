package com.ht.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.dao.ForengmessageDao;
import com.ht.pojo.Forengmessage;
import com.ht.service.ForengmessageService;

@Service
public class ForengmessageServiceImpl implements ForengmessageService {
	@Resource
	private ForengmessageDao fdao;

	@Override
	public int insertForengmessage(Forengmessage fore) {
		// TODO Auto-generated method stub
		return fdao.insertForengmessage(fore);
	}

	@Override
	public List<Forengmessage> selectAllMsg(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return fdao.selectAllMsg(map);
	}

	@Override
	public int countAllMsg(String userid) {
		// TODO Auto-generated method stub
		return fdao.countAllMsg(userid);
	}

}
