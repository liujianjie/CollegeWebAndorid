package com.ht.yfbc.service;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.InStorage;
import com.ht.yfbc.pojo.Picking;
import com.ht.yfbc.pojo.Stage;

public interface InStorageService {
	public Map<String, Object> selInStoragelist(Integer cpage,String starttime,String endtime,String whid);
	public Map<String, Object> selInStoragelist2(Integer cpage,String whid,String starttime,String endtime);
	public int addInStorage(InStorage instorage);
	public InStorage selInStorage(String id);
}
