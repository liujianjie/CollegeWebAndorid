package com.ht.yfbc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ht.yfbc.dao.GoodtypeDao;
import com.ht.yfbc.pojo.Goodtype;
import com.ht.yfbc.service.GoodtypeService;
/**
 * 类型操作
 * day 2016-12-29
 * @author 魏海明
 *
 */
@Service
public class GoodtypeServiceImpl implements GoodtypeService{
	@Resource
	GoodtypeDao gDao;

	public List<Goodtype> seltype() {
		// TODO Auto-generated method stub
		return gDao.seltype();
	}

	

}
