package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.OutStorage;

/**
 * 
 * 出货计划操作(outstorage)
 * day 2016-12-27
 * @author 刘建杰
 *
 */
public interface OutStorageDao {
	public List<OutStorage> selOutStorage();//��ѯ
	
	public List<OutStorage> selOutStoragePage(Map<String, Object> map);//��ѯ
	
	public List<OutStorage> selOutStoragePage2(Map<String, Object> map);//��ѯ
	
	public int addOutStorage(OutStorage outstorage);//���
	
	public OutStorage selOutByid(String outid);
	
	public List<OutStorage> selOutByWhid(String whid);
	
	public int updateState(String outid);
}
