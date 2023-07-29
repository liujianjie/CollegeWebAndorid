package com.dc.dao.card;

import java.util.List;

import com.dc.entity.OrderdEntity;

public interface CardDAO {
	public List find(String meal,String price,String customerid) throws Exception;
	public void insert(String meal,String price,String customerid);
	public void update(String meal,String customerid);
	public List select(String customerid) throws Exception;
	public void insertorderd(List<OrderdEntity> list,String orderid);
	public int insertorder(String customerid,String orderdate,String money,String content);
	public void clear(String customerid);
	public void delete(String cardid);
	public List findMyOrder(String customerid);
	public void finishOrder(String orderid);
	public List findcustomerById(String customerid);
	public void updateinfo(String customerid,String add,String phone,String province,String city,String district);
	public void updatecard(List list  );
}

