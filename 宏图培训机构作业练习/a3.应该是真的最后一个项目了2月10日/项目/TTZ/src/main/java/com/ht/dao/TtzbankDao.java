package com.ht.dao;


import java.util.List;
import java.util.Map;

import com.ht.pojo.Ttzbank;

public interface TtzbankDao {
	public void addTtzbank(Ttzbank bank);
	
	public List<Ttzbank> seluserBank(String userid);
	public void withDraw(Map<String, Object> map );
	//查询出用户绑定的银行卡
	public List<Ttzbank> selBankcard(String userid);
	//解除绑定
	public int delbankcard(String userid);
}
