package com.ht.service;

import java.util.List;

import com.ht.pojo.Ttzbank;

public interface TtzbanlService {
	public void addTtzbank(Ttzbank bank);
	
	public List<Ttzbank> seluserBank(String userid);
	public void withDraw(String userid,String bankcard,Double takeMoney);
	//��ѯ���û��󶨵����п�
	public List<Ttzbank> selBankcard(String userid);
	//�����
	public int delbankcard(String userid);
}
