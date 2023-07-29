package com.ht.yfbc.service;

import java.util.List;

import com.ht.yfbc.pojo.Financing;

public interface FinancingService {
	public int addFinancing(Financing financing);
	public List<Financing> findFinancingList();
	public int delFinancing(String id);
	public int updFinancing(Financing financing);
}
