package com.dc.controller.BgOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dc.dao.Bgorder.BgROrderDAO;
import com.dc.dao.Bgorder.BgROrderDAOImpl;
import com.dc.entity.PageEntity;
import com.dc.util.StringUtil;


public class BgOrders {
private String target;
private String nowpage;
private String roomnumber;
private String state;
private String orderid;
private PageEntity page;
private List ROlist;
private List Drinklist;
private Map roomMap;
private String empid;
private String detailid;
/**
 * 分页查询房间订单
 * @return
 */
public String showAllRoomOrder(){
	Map map=new HashMap();
	map.put("roomnumber", roomnumber);
	map.put("state", state);
	roomMap=map;
	int npage=0;
	if(StringUtil.checkNotNull(nowpage)){
		npage=Integer.parseInt(nowpage);
	}else{
		npage=1;
	}
	PageEntity page0=new PageEntity();
	page0.setNowpage(npage);
	BgROrderDAO dao=new BgROrderDAOImpl();
	ROlist=dao.SelectAllRO(map,page0);//查询所有房间订单
	page=page0;
	if(state==null||state.equals("")){
		state="";
	}
	target="/module/BgOrder/AllRoomOrder.jsp";
	return "success";
}
/**
 * 完成房间订单
 * @return
 */
public String changeOrState(){
	BgROrderDAO dao=new BgROrderDAOImpl();
	int i=dao.changeOrState(orderid,empid);
	//target="bgO_showAllRoomOrder";
	//return "successto";
	if(i!=-1){
	target="open_openSeeTable";
	return "successto";
	}else{
		target="/module/BgLogin/BgLogin.jsp";
		return "success";
	}
}
/**
 * 显示所有酒水
 * @return
 */
public String DrinkOrder(){
	BgROrderDAO dao=new BgROrderDAOImpl();
	Drinklist=dao.SelectAllDrink();
	target="/module/BgOrder/DrinkOrder.jsp";
	return "success";
}
/**
 * 修改酒品状态
 * @return
 */
public String changeDrinkO(){
	BgROrderDAO dao=new BgROrderDAOImpl();
	int i=dao.changeDrinkState(detailid);
	Drinklist=dao.SelectAllDrink();
	target="/module/BgOrder/DrinkOrder.jsp";
	return "success";
}
public String getDetailid() {
	return detailid;
}
public void setDetailid(String detailid) {
	this.detailid = detailid;
}
public List getDrinklist() {
	return Drinklist;
}
public void setDrinklist(List drinklist) {
	Drinklist = drinklist;
}
public String getEmpid() {
	return empid;
}
public void setEmpid(String empid) {
	this.empid = empid;
}
public String getOrderid() {
	return orderid;
}
public void setOrderid(String orderid) {
	this.orderid = orderid;
}
public List getROlist() {
	return ROlist;
}

public void setROlist(List rOlist) {
	ROlist = rOlist;
}

public Map getRoomMap() {
	return roomMap;
}

public void setRoomMap(Map roomMap) {
	this.roomMap = roomMap;
}

public String getTarget() {
	return target;
}
public void setTarget(String target) {
	this.target = target;
}
public String getNowpage() {
	return nowpage;
}
public void setNowpage(String nowpage) {
	this.nowpage = nowpage;
}
public String getRoomnumber() {
	return roomnumber;
}
public void setRoomnumber(String roomnumber) {
	this.roomnumber = roomnumber;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public PageEntity getPage() {
	return page;
}
public void setPage(PageEntity page) {
	this.page = page;
}

}
