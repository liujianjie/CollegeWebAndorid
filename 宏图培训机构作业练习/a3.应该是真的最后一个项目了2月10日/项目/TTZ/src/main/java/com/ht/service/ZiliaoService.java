package com.ht.service;

import java.util.List;
import java.util.Map;

import com.ht.pojo.Ziliao;
import com.ht.pojo.Ziliao2;

public interface ZiliaoService {
	public void insert(Ziliao ziliao);

	public List<Ziliao2> selectAll();

	public int updateSFZ(String userid, String zhungtai);

	public int updateGZZ(String userid, String zhungtai);

	public int updateSRZ(String userid, String zhungtai);

	public int updateJZZ(String userid, String zhungtai);

	public int updateXYZ(String userid, String zhungtai);

	// 查询某个人的认证信息
	public Ziliao selectOneUserZiLiao(String userid);
}
