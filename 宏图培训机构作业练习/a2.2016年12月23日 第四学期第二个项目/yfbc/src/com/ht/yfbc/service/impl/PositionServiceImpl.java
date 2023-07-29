package com.ht.yfbc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.PositionDao;
import com.ht.yfbc.pojo.Position;
import com.ht.yfbc.service.PositionService;
@Service
public class PositionServiceImpl implements PositionService {
	@Resource
	private PositionDao posDao;
	
	public List<Position> selPositionList() {
		return posDao.selPositionList();
	}

	public String selPositionNameById(String id) {
		return posDao.selPositionNameById(id);
	}

	public String selPositionIdByName(String pname) {
		return posDao.selPositionIdByName(pname);
	}

	@Override
	public List<Position> selCars_posiPage(Map<String, Object> map) {
		
		return posDao.selCars_posiPage(map);
	}

	@Override
	public int selCount() {
		return posDao.selCount();
	}

	@Override
	public int addposi(Position posi) {
		return posDao.addposi(posi);
	}

	@Override
	public int delposi(String id) {
		// TODO Auto-generated method stub
		return posDao.delposi(id);
	}

}
