package com.ht.yfbc.service;

import java.util.List;

import com.ht.yfbc.pojo.OutStorage;
import com.ht.yfbc.pojo.PickingList;

public interface PickingListService {
	public List<PickingList> selPickingList();
	public int addPickingList(PickingList pickinglist);//Ìí¼Ó
}
