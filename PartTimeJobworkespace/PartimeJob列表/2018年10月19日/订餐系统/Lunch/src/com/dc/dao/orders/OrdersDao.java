package com.dc.dao.orders;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface OrdersDao {
	/**
	 * ��ѯͳ�ƶ���
	 * */
	public List findAllOrders(Map map,PageEntity page);
}
