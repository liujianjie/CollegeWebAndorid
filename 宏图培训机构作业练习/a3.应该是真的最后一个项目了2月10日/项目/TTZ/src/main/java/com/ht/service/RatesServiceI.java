package com.ht.service;

import java.util.List;

import com.ht.pojo.Rates;

public interface RatesServiceI {
	//²éÑ¯ËùÓĞ
	public List<Rates> selrateslist();
	public int add(Rates rates);
	public int upd(Rates rates);
	public int del(String id);
	public Rates get(String id);
}
