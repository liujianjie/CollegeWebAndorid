package com.ht.dao;


import java.util.List;
import java.util.Map;

import com.ht.pojo.Ttzbank;

public interface TtzbankDao {
	public void addTtzbank(Ttzbank bank);
	
	public List<Ttzbank> seluserBank(String userid);
	public void withDraw(Map<String, Object> map );
	//��ѯ���û��󶨵����п�
	public List<Ttzbank> selBankcard(String userid);
	//�����
	public int delbankcard(String userid);
}
