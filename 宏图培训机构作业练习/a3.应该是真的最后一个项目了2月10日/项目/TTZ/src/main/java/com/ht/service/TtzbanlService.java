package com.ht.service;

import java.util.List;

import com.ht.pojo.Ttzbank;

public interface TtzbanlService {
	public void addTtzbank(Ttzbank bank);
	
	public List<Ttzbank> seluserBank(String userid);
	public void withDraw(String userid,String bankcard,Double takeMoney);
	//查询出用户绑定的银行卡
	public List<Ttzbank> selBankcard(String userid);
	//解除绑定
	public int delbankcard(String userid);
}
