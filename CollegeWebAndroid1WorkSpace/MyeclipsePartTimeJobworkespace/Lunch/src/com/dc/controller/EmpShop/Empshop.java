package com.dc.controller.EmpShop;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import com.dc.dao.EmpShop.empShopDAO;
import com.dc.dao.EmpShop.empShopDAOImpl;
import com.dc.util.BaseAction;
import com.dc.util.StringUtil;

/**
 * @author Administrator
 *
 */
public class Empshop extends BaseAction{
	public static int key=1;
	private String mealid;
	private String flag;
	private String roomid;
	private String mealcount;
	private List empshopList;
	private List roominfo;
	private Map shopinfo;
	private String orderid;
	private Map shopmap;
	private String keyname;
	private String Addorderid;
	public Map getShopmap() {
		return shopmap;
	}
	public void setShopmap(Map shopmap) {
		this.shopmap = shopmap;
	}
	private List allRoomlist;
	private String target;
	/**
	 * 后台房间进行点餐,将该点菜存储到session里
	 * @return
	 */
	public String EmpshopBuy(){
		empShopDAO dao=new empShopDAOImpl();
		HttpSession session=this.getSession();
		String sessromid=session.getAttribute("roomid").toString();
		if(this.roomid.equals(sessromid)){
			shopmap=dao.selectShopinfo(mealid);
			shopmap.put("mealcount", mealcount);
		if(StringUtil.checkNotNull(session.getAttribute("roomShopinfo"))){
			Map roomShopinfo=(Map)session.getAttribute("roomShopinfo");
			String keynum="key"+key;
			//System.out.println("key"+keynum);
			roomShopinfo.put(keynum,shopmap);
			key++;
			session.setAttribute("roomShopinfo", roomShopinfo);
		}else{
			Map map =new HashMap();
			map.put("key0", shopmap);
			session.setAttribute("roomShopinfo", map);	
		}
		}
		//this.target="/module/Login/Empshop.jsp";
		if(StringUtil.checkNotNull(flag)){
			orderid=this.Addorderid;
			this.target="/module/BgMenu/BgMenu.jsp";
		}else{
			this.target="/module/Login/Empshop.jsp";
		}
		
		return "success";	
	}
	/**
	 * 房间初始所有房间
	 * @return
	 */
	public String SetRoom(){
		empShopDAO dao=new empShopDAOImpl();
		allRoomlist=dao.selectAllRoominfo();
		this.target="/module/Login/ShowAllRoom.jsp";
		return "success";
	}
	/**
	 * 后台购物车删除
	 * @return
	 */
	public void Empshopdele(){
		HttpSession session=this.getSession();
		Map roomShopinfo=(Map)session.getAttribute("roomShopinfo");
		roomShopinfo.remove(keyname);
		System.out.println(roomShopinfo);
		session.setAttribute("roomShopinfo", roomShopinfo);
		this.getOut().print("true");
		/*this.target="/module/Login/Empshop.jsp";
		return "success";*/
	}
	/**
	 * 开桌检查
	 */
	public void CheckRoom(){
		empShopDAO dao=new empShopDAOImpl();
		String state=dao.selectroomState(roomid);
		this.getOut().print(state);
	}
	/**
	 * 查房间信息
	 * @return
	 */
	public String GetRoominfo(){
		empShopDAO dao=new empShopDAOImpl();
		roominfo=dao.selectroominfo(roomid);
		HttpSession sess=this.getSession();
		sess.setAttribute("roominfo", roominfo);
		this.target="/module/BgMenu/BgMenu.jsp";
		return "success";
	}
	/**
	 * 找房间orderid
	 */
	public void findOrderid(){
		empShopDAO dao=new empShopDAOImpl();
		String orderid=dao.FindRoomOrid(roomid);
		this.getOut().print(orderid);
	}
	/**
	 * 通知结账
	 */
	public void callOrder(){
		empShopDAO dao=new empShopDAOImpl();
		String orderid=dao.FindRoomOrid(roomid);
		int i=dao.calltopay(orderid);
		this.getOut().print(orderid);
	}
	/**
	 * 添加到后台empshop表
	 */
	public void InsetTableEmpshop(){
		empShopDAO dao=new empShopDAOImpl();
		int i=dao.InsertTBEmpshop(mealid,mealcount,roomid,Addorderid);
		if(i!=0){			
			this.getOut().print("true");
		}
	}
	/**
	 * 进入购物车
	 * @return
	 */
	public String ToEmpshop(){
		empShopDAO dao=new empShopDAOImpl();
		empshopList=dao.selectTbEmpshop(roomid);
		this.target="/module/Login/Empshop.jsp";
		return "success";
	}
	/**
	 * 后台empshop表删除
	 */
	public void TbEmpshopdele(){
		empShopDAO dao=new empShopDAOImpl();
		dao.deleteTbEmpshop(mealid,roomid);
		this.getOut().print("true");
	}
	/**
	 * 进行手动添加数量
	 * @return
	 */
	public void TbEmpshopaddcount(){
		empShopDAO dao=new empShopDAOImpl();
		int i=dao.updateTbempshop(mealid,roomid,mealcount);
		this.getOut().print("true");
	}
	public List getEmpshopList() {
		return empshopList;
	}
	public void setEmpshopList(List empshopList) {
		this.empshopList = empshopList;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getAddorderid() {
		return Addorderid;
	}
	public void setAddorderid(String addorderid) {
		Addorderid = addorderid;
	}
	public String getFlag() {
		return flag;
	}
	public void setFlag(String flag) {
		this.flag = flag;
	}
	public List getRoominfo() {
		return roominfo;
	}
	public void setRoominfo(List roominfo) {
		this.roominfo = roominfo;
	}
	public String getMealcount() {
		return mealcount;
	}
	public void setMealcount(String mealcount) {
		this.mealcount = mealcount;
	}
	public String getKeyname() {
		return keyname;
	}
	public void setKeyname(String keyname) {
		this.keyname = keyname;
	}
	public List getAllRoomlist() {
		return allRoomlist;
	}
	public void setAllRoomlist(List allRoomlist) {
		this.allRoomlist = allRoomlist;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getMealid() {
		return mealid;
	}
	public void setMealid(String mealid) {
		this.mealid = mealid;
	}
	public String getRoomid() {
		return roomid;
	}
	public void setRoomid(String roomid) {
		this.roomid = roomid;
	}
	public Map getShopinfo() {
		return shopinfo;
	}
	public void setShopinfo(Map shopinfo) {
		this.shopinfo = shopinfo;
	}	
	
}
