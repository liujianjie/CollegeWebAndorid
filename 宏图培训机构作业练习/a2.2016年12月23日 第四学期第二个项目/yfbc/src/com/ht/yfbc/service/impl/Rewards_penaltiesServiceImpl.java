package com.ht.yfbc.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.Rewards_penaltiesDao;
import com.ht.yfbc.pojo.Rewards_penalties;
import com.ht.yfbc.service.Rewards_penaltiesService;
@Service
public class Rewards_penaltiesServiceImpl implements Rewards_penaltiesService {
	@Resource
	private Rewards_penaltiesDao rpDao;

	public List<Rewards_penalties> selRewards_penaltiesList(Map<String, Object> map) {
		return rpDao.selRewards_penaltiesList(map);
	}
	public void addRewards_penalties(Rewards_penalties Rewards_penalties) {
		rpDao.addRewards_penalties(Rewards_penalties);
	}
	public int selCount(Map<String, Object> map) {
		return rpDao.selCount(map);
	}
	public List<Rewards_penalties> selRewards_penaltiesListPage(Map<String, Object> map) {
		return rpDao.selRewards_penaltiesListPage(map);
	}

}
