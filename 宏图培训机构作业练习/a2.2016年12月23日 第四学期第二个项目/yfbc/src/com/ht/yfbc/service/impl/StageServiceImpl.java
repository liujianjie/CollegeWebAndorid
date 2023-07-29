package com.ht.yfbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.StageDao;
import com.ht.yfbc.pojo.Picking;
import com.ht.yfbc.pojo.Stage;
import com.ht.yfbc.service.StageService;
/**
 * 
 * stage区层(outstorage)
 * day 2016-12-28
 * @author 刘建杰
 *
 */
@Service
public class StageServiceImpl implements StageService{

	@Resource
	private StageDao stagedao;
	
	@Override
	public List<Stage> selStage() {
		return stagedao.selStage();
	}

	@Override
	public int addStage(Stage stage) {
		return stagedao.addStage(stage);
	}

}
