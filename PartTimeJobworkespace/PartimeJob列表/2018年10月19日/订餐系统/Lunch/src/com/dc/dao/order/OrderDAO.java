package com.dc.dao.order;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface OrderDAO {
	public List findorder(Map map,PageEntity page);
	public List findById(String orderid);
	public List findDetail(String orderid);
	public List findemp();
	public void updateByName(String empname,String orderid);
	public void updatestate(String orderid);
	public void qxdd(String orderid);
	public List findpack(String orderid);
	public void pack(String orderid);
}
