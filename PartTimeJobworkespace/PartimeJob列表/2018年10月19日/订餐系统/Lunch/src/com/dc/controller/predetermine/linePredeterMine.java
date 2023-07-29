package com.dc.controller.predetermine;

import java.util.*;

import com.dc.dao.predetermine.PredetermineDao;
import com.dc.dao.predetermine.PredetermineDaoImpI;
import com.dc.entity.Message;
import com.dc.entity.PageEntity;
import com.dc.util.BaseAction;
import com.dc.util.StringUtil;

/*
 * 对所有线上和线下的桌房预订进行一定的操作
 */
public class linePredeterMine extends BaseAction{
		private Map map;				//将要查询的条件全部set进去
		private PageEntity page;		//分页的实体
		private List roomlist;			//查询所有的线下的预订信息
		public String target;			//通过这个字符进行地质传参
		public String nowpage;			//返回过来的当前页数
		public String customername;		//返回顾客姓名进行查询
		public String roomnumber;		//返回房间名进行查询
		public String preline;			//返回桌房预订类别
		public String customerphone;	//返回顾客电话进行查询
		public String predate;			//返回日期进行查询(任意日期都可以)
		public String roomtype;			//返回房间桌号类型进行查询
		public String preid;			//返回预定id进行取消预定
		public String preframe;			//返回预定时间段
		
		/**
		 * 员工对所有的预订桌房表信息进行查询
		 * @return
		 */
		public String seeLineRoom(){
			PredetermineDao dao=new PredetermineDaoImpI();
			map=new HashMap();
			map.put("customername",customername);
			map.put("roomnumber",roomnumber);
			map.put("preline",preline);
			map.put("customerphone",customerphone);
			map.put("predate",predate);
			map.put("roomtype",roomtype);
			map.put("preframe",preframe);
			int pagN=0;
			if(StringUtil.checkNotNull(nowpage)){
				pagN=Integer.parseInt(nowpage);
			}else{
				pagN=1;
			}
			page=new PageEntity();
			page.setNowpage(pagN);
			roomlist=dao.findLineRoom(map, page);
			this.target="/module/predetermine/linePredeterMine.jsp";
			return "success";
		}
		public void cancelRoom(){
			PredetermineDao dao=new PredetermineDaoImpI();
			dao.empCancelCustomerRoom(preid);
			Message mess=new Message();
			mess.setState(true);
			mess.setMessage("成功取消预订");
			this.getOut().print(StringUtil.transObjectToJson(mess));
		}
		public Map getMap() {
			return map;
		}

		public void setMap(Map map) {
			this.map = map;
		}

		public PageEntity getPage() {
			return page;
		}

		public void setPage(PageEntity page) {
			this.page = page;
		}

		public List getRoomlist() {
			return roomlist;
		}

		public void setRoomlist(List roomlist) {
			this.roomlist = roomlist;
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

		public String getCustomername() {
			return customername;
		}

		public void setCustomername(String customername) {
			this.customername = customername;
		}

		public String getRoomnumber() {
			return roomnumber;
		}

		public void setRoomnumber(String roomnumber) {
			this.roomnumber = roomnumber;
		}

		public String getPreline() {
			return preline;
		}

		public void setPreline(String preline) {
			this.preline = preline;
		}

		public String getCustomerphone() {
			return customerphone;
		}

		public void setCustomerphone(String customerphone) {
			this.customerphone = customerphone;
		}

		public String getPredate() {
			return predate;
		}

		public void setPredate(String predate) {
			this.predate = predate;
		}

		public String getRoomtype() {
			return roomtype;
		}

		public void setRoomtype(String roomtype) {
			this.roomtype = roomtype;
		}
		public String getPreid() {
			return preid;
		}
		public void setPreid(String preid) {
			this.preid = preid;
		}
		public String getPreframe() {
			return preframe;
		}
		public void setPreframe(String preframe) {
			this.preframe = preframe;
		}

}
