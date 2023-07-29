package com.dc.dao.predetermine;

import java.util.List;
import java.util.Map;

import com.dc.entity.PageEntity;

public interface PredetermineDao {
	public List findLineRoom(Map map,PageEntity page);
	public void empCancelCustomerRoom(String preid);
	public List findEmptyRoom(Map map,PageEntity page);
	public void insertRoom(String roomnumber,String peocount,String roomtype);
	public Map checkRoom(String roomnumber);
	public List selectRoom(String peocount,String roomtype,String predate,String preframe);
	public void insertPreterMine(String customerid,String roomid,String predate,String preframe);
	public List selectCustomer(String customerid);
	public void cansel(String preid);
	public List empFindReserveRoom(String peocount,String roomtype,String predate,String preframe);
	public void empInsertPreterMine(String roomid,String predate,String preframe,String precustomer,String prephone);
	public List openFindRoom(String roomnumber);
	public void updateOpenRoom(String roomid);
	public void recoverOpenRoom(String roomid);
	public void huifuOpenRoom(String roomid);
	public List yudingOpenRoom();
	public void dingShiPredetermine();
}
