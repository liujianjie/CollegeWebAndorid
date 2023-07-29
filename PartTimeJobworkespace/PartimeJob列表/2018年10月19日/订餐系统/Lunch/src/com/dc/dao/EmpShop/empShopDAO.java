package com.dc.dao.EmpShop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface empShopDAO {
	public Map selectShopinfo(String mealid);

	public List selectAllRoominfo();

	public String selectroomState(String roomid);
	public int insertShopcar(String money, String roomid, List list);

	public List selectThisdtail(String orderid);

	public List noselectThisdtail(String orderid);

	public String getDetailcount(String orderid);

	public List orderdetailinfo(String orderid);

	public List orderRoominfo(String orderid);

	public List selectroominfo(String roomid);

	public int changeOrDeS3(String orderdetailid);

	public int reOneTableDe(String orderdetailid);

	public String FindRoomOrid(String roomid);

	public boolean countOrder(String orderid);

	public int AddMeal(String money, String roomid, List list, String addorderid);

	public int puchMealcount(String orderid);

	public List showremovecookde(String orderid);

	public int removecookde(String orderid, String orderdetailid);

	public int InsertTBEmpshop(String mealid, String mealcount, String roomid,
			String addorderid);

	public List selectTbEmpshop(String roomid);

	public void deleteTbEmpshop(String mealid, String roomid);

	public int updateTbempshop(String mealid, String roomid, String mealcount);

	public List selectAllTbempshop(String roomid);
	public int deleteAllTbempshop(String roomid);

	public int EmpshopAddMeal(String roomid, List empshoplist);

	public int EmpshopAddMeal2(String roomid, String addorderid,
			List empshoplist);

	public int changeOrTo2(String orderid);

	public int calltopay(String orderid);

	public String selectordercall(String orderid);
}
