package com.ht.yfbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.ConSignMentDao;
import com.ht.yfbc.dao.OutStorageDao;
import com.ht.yfbc.pojo.ConSignMent;
import com.ht.yfbc.pojo.OutStorage;
import com.ht.yfbc.service.ConSignMentService;
import com.ht.yfbc.service.OutStorageService;

/**
 * 
 * 发货单业务层(consignment)
 * day 2016-12-27
 * @author 刘建杰
 *
 */
@Service
public class ConSignMentServiceImpl implements ConSignMentService{

	@Resource
	private ConSignMentDao con;
	
	@Override
	public List<ConSignMent> selConSignMent() {
		// TODO 自动生成的方法存根
		return con.selConSignMent();
	}

	@Override
	public int addConSignMent(ConSignMent consignment) {
		// TODO 自动生成的方法存根
		return con.addConSignMent(consignment);
	}
}
