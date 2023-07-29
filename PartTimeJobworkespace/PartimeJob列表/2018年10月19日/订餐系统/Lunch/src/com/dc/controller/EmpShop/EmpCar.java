package com.dc.controller.EmpShop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.dc.dao.EmpShop.empShopDAO;
import com.dc.dao.EmpShop.empShopDAOImpl;
import com.dc.util.BaseAction;
import com.dc.util.StringUtil;

import net.sf.json.JSONArray;

public class EmpCar extends BaseAction{
	private String flag;
	private String Jsonlist;
	private String orderdetailid;
	private String roomid;
	private String detailcount;
	private String orderid;
	private String Addorderid;
	private String money;
	private String target;
	private List roomMealDeatil;
	private List roomcooklist;
	private List roomorderlist;
	private List orderdetilist;
public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

/**
 * 异步购物车添加到数据库,加菜
 */
	public void addToTable(){
		JSONArray json=new JSONArray();
		json=JSONArray.fromObject(Jsonlist);
		List list=JSONArray.toList(json,HashMap.class);
		empShopDAO dao=new empShopDAOImpl();
		if(StringUtil.checkNotNull(Addorderid)){
			int j=dao.AddMeal(money,roomid,list,Addorderid);
			this.getOut().print(Addorderid);
		}else{
			int i=dao.insertShopcar(money,roomid,list);
			orderid=i+"";
			if(i!=0){
				HttpSession session=this.getSession();
				Map roomShopinfo=(Map) session.getAttribute("roomShopinfo");
				roomShopinfo.clear();
				session.setAttribute("roomShopinfo", roomShopinfo);
				this.getOut().print(orderid);
			}
			else{
				this.getOut().print("false");
			}
		}
	}
	/**
	 * 显示房间订单详情
	 */
	public String showRoomdetail(){
		empShopDAO dao=new empShopDAOImpl();
		roomMealDeatil=dao.selectThisdtail(orderid);
		detailcount=dao.getDetailcount(orderid);
		//System.out.println(roomMealDeatil);
		this.target="/module/Login/RoomOrderdetail.jsp";
		return "success";
	}
	/**
	 * 通过订单id显示详情有关信息
	 */
	public void showMenu(){
		empShopDAO dao=new empShopDAOImpl();
		List list=dao.noselectThisdtail(orderid);
		JSONArray json=new JSONArray();
		json=JSONArray.fromObject(list);
		this.getOut().print(json.toString());
	}
	/**
	 * 后台显示房间订单
	 * @return
	 */
	public String OneroomOrder(){
		empShopDAO dao=new empShopDAOImpl();
		
			orderdetilist=dao.orderdetailinfo(orderid);
			roomorderlist=dao.orderRoominfo(orderid);
			HttpSession sess=this.getSession();
			sess.setAttribute("BgOrderid", orderid);
			this.target="/module/Login/OneroomOrder.jsp";
		
		return "success";
	}
	public String OnlyLookroom(){
		empShopDAO dao=new empShopDAOImpl();
		
			orderdetilist=dao.orderdetailinfo(orderid);
			roomorderlist=dao.orderRoominfo(orderid);
			HttpSession sess=this.getSession();
			sess.setAttribute("BgOrderid", orderid);
			this.target="/module/BgOrder/Onlylookroom.jsp";
		
		return "success";
	}
	/**
	 * 上桌菜详情改为3
	 * @return
	 */
	public String OnTable(){
		empShopDAO dao=new empShopDAOImpl();
		int i=dao.changeOrDeS3(orderdetailid);
		int j=dao.changeOrTo2(orderid);
		orderdetilist=dao.orderdetailinfo(orderid);
		roomorderlist=dao.orderRoominfo(orderid);
		flag="1";
		this.target="/module/Login/OneroomOrder.jsp";
		return "success";
	}
	/**
	 * 删菜，退菜
	 * @return
	 */
	public String reOneTableDe(){
		empShopDAO dao=new empShopDAOImpl();
		int i=dao.reOneTableDe(orderdetailid);
		int j=dao.changeOrTo2(orderid);
		orderdetilist=dao.orderdetailinfo(orderid);
		roomorderlist=dao.orderRoominfo(orderid);
		flag="1";
		this.target="/module/Login/OneroomOrder.jsp";
		return "success";
	}
	/**
	 * 计算订单详情数量判断订单是否全部上桌
	 * @return
	 */
	public void checkEnd(){
		empShopDAO dao=new empShopDAOImpl();
		boolean i=dao.countOrder(orderid);
		this.getOut().print(i);
	}
/**
 * 进行催菜
 */
	public void pushfoodcount(){
		empShopDAO dao=new empShopDAOImpl();
		int i=dao.puchMealcount(orderid);
		if(i!=0){		
			this.getOut().print("true");
		}else{
			this.getOut().print("false");
		}
	}
	/**
	 * 进行退菜cook，详情单更新
	 * @return
	 */
	public String RemovecookDe(){
		empShopDAO dao=new empShopDAOImpl();
		int i=dao.removecookde(orderid,orderdetailid);
		int j=dao.changeOrTo2(orderid);
		roomcooklist=dao.showremovecookde(orderid);
		roomorderlist=dao.orderRoominfo(orderid);
		this.target="/module/BgOrder/RemoveDeal.jsp";
		return "success";
	}
	/**
	 * 进行退菜cook联合显示
	 * @return
	 */
	public String showRemovecookDe(){
		empShopDAO dao=new empShopDAOImpl();
		roomorderlist=dao.orderRoominfo(orderid);
		roomcooklist=dao.showremovecookde(orderid);
		this.target="/module/BgOrder/RemoveDeal.jsp";
		return "success";
	}
	/**
	 * 添加到订单与订单详情表返回订单id
	 */
	public void addToTbTable(){
		empShopDAO dao=new empShopDAOImpl();
		List empshoplist=dao.selectAllTbempshop(roomid);
		//返回订单id
		if(StringUtil.checkNotNull(Addorderid)){
			int i=dao.EmpshopAddMeal2(roomid,Addorderid, empshoplist);
			dao.deleteAllTbempshop(roomid);
			this.getOut().print(Addorderid);
		}else{
			int i=dao.EmpshopAddMeal(roomid, empshoplist);
			dao.deleteAllTbempshop(roomid);
			HttpSession sess=this.getSession();
			sess.setAttribute("orderid", i);
			this.getOut().print(i);
		}
	}
	/**
	 * 结账界面
	 * @return
	 */
	public String Jiezhang(){
		empShopDAO dao=new empShopDAOImpl();
		
		orderdetilist=dao.orderdetailinfo(orderid);
		roomorderlist=dao.orderRoominfo(orderid);
		HttpSession sess=this.getSession();
		sess.setAttribute("BgOrderid", orderid);
		this.target="/module/BgOrder/Jiezhang.jsp";
	
	return "success";
	}
	/**
	 * 界面显示结账
	 */
	public void showCall(){
		empShopDAO dao=new empShopDAOImpl();
		String orderid=dao.FindRoomOrid(roomid);
		String callstate=dao.selectordercall(orderid);
		if(StringUtil.checkNotNull(callstate)){
			this.getOut().print("{\"state\":\"true\",\"roomid\":\""+roomid+"\"}");
		}else{
			this.getOut().print("{\"state\":\"false\",\"roomid\":\""+roomid+"\"}");
		}
	}
	public String getAddorderid() {
		return Addorderid;
	}

	public List getRoomcooklist() {
		return roomcooklist;
	}

	public void setRoomcooklist(List roomcooklist) {
		this.roomcooklist = roomcooklist;
	}

	public void setAddorderid(String addorderid) {
		Addorderid = addorderid;
	}

	public String getOrderdetailid() {
		return orderdetailid;
	}

	public void setOrderdetailid(String orderdetailid) {
		this.orderdetailid = orderdetailid;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public List getRoomorderlist() {
		return roomorderlist;
	}

	public void setRoomorderlist(List roomorderlist) {
		this.roomorderlist = roomorderlist;
	}

	public List getOrderdetilist() {
		return orderdetilist;
	}

	public void setOrderdetilist(List orderdetilist) {
		this.orderdetilist = orderdetilist;
	}

	public String getDetailcount() {
		return detailcount;
	}

	public void setDetailcount(String detailcount) {
		this.detailcount = detailcount;
	}

	public String getOrderid() {
		return orderid;
	}

	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}

	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public List getRoomMealDeatil() {
		return roomMealDeatil;
	}

	public void setRoomMealDeatil(List roomMealDeatil) {
		this.roomMealDeatil = roomMealDeatil;
	}

	public String getRoomid() {
	return roomid;
}

public void setRoomid(String roomid) {
	this.roomid = roomid;
}

	public String getJsonlist() {
		return Jsonlist;
	}

	public void setJsonlist(String jsonlist) {
		Jsonlist = jsonlist;
	}
	
}
