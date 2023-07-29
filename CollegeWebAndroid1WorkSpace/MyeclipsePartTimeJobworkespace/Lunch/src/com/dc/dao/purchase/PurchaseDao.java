package com.dc.dao.purchase;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface PurchaseDao {
	/**
	 * 查询进货详情单
	 * */
	public  List findPruchare(Map map,PageEntity page);
}
