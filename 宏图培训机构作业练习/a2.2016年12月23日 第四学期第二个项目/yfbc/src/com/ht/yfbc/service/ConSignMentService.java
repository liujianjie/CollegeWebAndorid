package com.ht.yfbc.service;

import java.util.List;

import com.ht.yfbc.pojo.ConSignMent;

public interface ConSignMentService {
	public List<ConSignMent> selConSignMent();
	public int addConSignMent(ConSignMent consignment);
}
