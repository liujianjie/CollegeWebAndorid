package com.ht.yfbc.dao;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.InStorage;
import com.ht.yfbc.pojo.Picking;
import com.ht.yfbc.pojo.Stage;

/**
 * instorage操作(in_storage)
 * day 2016-12-28
 * @author 刘建杰
 *
 */
public interface InStorageDao {
	public List<InStorage> selInStoragelist(Map<String, Object> map);
	public List<InStorage> selInStoragelist2(Map<String, Object> map);//仓库管理员
	public int addInStorage(InStorage instorage);
	public InStorage selInStorage(String id);
	
	//修改状态为已收货
	public int updateStorageState(String id);
	
	//查询大小
	public int selInStorageCount(Map<String, Object> map);
}
