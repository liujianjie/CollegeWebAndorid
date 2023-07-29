package com.ht.yfbc.dao;

import java.util.List;

import com.ht.yfbc.pojo.OutStorage;
import com.ht.yfbc.pojo.PickingList;

/**
 * 
 * 拣货单列操作(pickinglist)
 * day 2016-12-27
 * @author 刘建杰
 *
 */
public interface PickingListDao {
	public List<PickingList> selPickingList();
	public int addPickingList(PickingList pickinglist);
}
