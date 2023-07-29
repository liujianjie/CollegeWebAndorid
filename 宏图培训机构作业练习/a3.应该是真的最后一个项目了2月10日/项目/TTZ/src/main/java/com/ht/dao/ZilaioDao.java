package com.ht.dao;

import java.util.List;
import java.util.Map;

import com.ht.pojo.Ziliao;
import com.ht.pojo.Ziliao2;

public interface ZilaioDao {
	public void insert(Ziliao ziliao);

	public List<Ziliao2> selectAll();

	public int updateSFZ(Map<String, Object> map);

	public int updateGZZ(Map<String, Object> map);

	public int updateSRZ(Map<String, Object> map);

	public int updateJZZ(Map<String, Object> map);

	public int updateXYZ(Map<String, Object> map);

	// 查询某个人的认证信息
	public Ziliao selectOneUserZiLiao(String userid);

}
