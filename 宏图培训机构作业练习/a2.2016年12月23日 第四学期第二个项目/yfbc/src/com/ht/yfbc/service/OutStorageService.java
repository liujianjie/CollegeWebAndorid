package com.ht.yfbc.service;

import java.util.List;
import java.util.Map;

import com.ht.yfbc.pojo.OutStorage;

public interface OutStorageService {
	public List<OutStorage> selOutStorage();
	public int addOutStorage(OutStorage outstorage);//���
	
	public Map<String, Object> selOutStoragePage(Integer currPage);//��ѯ
	
	public Map<String, Object> selOutStoragePage2(Integer currPage,String whid);//��ѯ
	
	public OutStorage selOutByid(String outid);
	
	public int updateState(String outid);
	
	public List<OutStorage> selOutByWhid(String whid);
}
