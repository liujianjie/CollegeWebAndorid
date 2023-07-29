package com.ht.yfbc.dao;

import java.util.List;

import com.ht.yfbc.pojo.ConSignMent;
import com.ht.yfbc.pojo.OutStorage;

/**
 * 发货操作(ConSignMent)
 * day	2016-12-27
 * @author 刘建杰
 * */
public interface ConSignMentDao {
	public List<ConSignMent> selConSignMent();
	public int addConSignMent(ConSignMent consignment);
}
