package com.ht.dao;

import java.util.List;

import com.ht.pojo.Rates;

public interface RatesDao {
	//��ѯ����
	public List<Rates> selrateslist();
	public int add(Rates rates);
	public int upd(Rates rates);
	public int del(String id);
	public Rates get(String id);
}
