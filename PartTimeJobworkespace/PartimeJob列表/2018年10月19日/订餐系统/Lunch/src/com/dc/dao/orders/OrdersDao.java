package com.dc.dao.orders;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface OrdersDao {
	/**
	 * 查询统计订单
	 * */
	public List findAllOrders(Map map,PageEntity page);
}
