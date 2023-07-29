package com.ht.yfbc.dao;

import java.util.List;

import com.ht.yfbc.pojo.OutStorage;
import com.ht.yfbc.pojo.Picking;

/**
 * 
 * 拣货单表操作(picking)
 * day 2016-12-27
 * @author 刘建杰
 *
 */
public interface PickingDao {
	public List<Picking> selPicking();
	public int addPicking(Picking picking);
}
