package com.dc.controller.predetermine;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dc.dao.predetermine.PredetermineDao;
import com.dc.dao.predetermine.PredetermineDaoImpI;
import com.dc.entity.Message;
import com.dc.util.BaseAction;
import com.dc.util.StringUtil;

/**
 * 前后台所有的预订方法都在这
 * @author K
 *
 */
public class CustomerQueryRoom extends BaseAction{
		private String predate;          //预定日期
		private String preframe;         //预定时间段
		private List listRoom;           //所有可以预定的房间信息
		private String target;			 //通用地址字符
		private String customerid;		 //顾客id
		private String roomid;			 //房间id
		private List listCustomer;       //顾客查询自己所有的预定信息
		private String preid;            //预订单的id
		private String peocount;    	 //顾客通过人数进行查询可预订的房间
		private String roomtype;		 //顾客通过房间类型查询可预订的房间
		private String precustomer;		 //顾客打电话预定，留下的顾客姓名
		private String prephone;		 //顾客打电话预定,留下的顾客电话
		private List reserveRoom;		 //这个是将查询到的预定桌房信息放到list中去
		
		/**
		 * 根据选择的预订日期,房间类型,人数,时间段来进行查询返回所有可以预订的房间信息(前台后台查询通用的)
		 * @return
		 */
		public String selectRoom(){
			PredetermineDao dao=new PredetermineDaoImpI();
			Date date=new Date();
			SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dateformat2=new SimpleDateFormat("HH");
			//date代表当前日期,hour代表当前小时,aa代表predate时间段的前2位数字
			String datetime=dateformat1.format(date);
			int hour=Integer.parseInt(dateformat2.format(date));
			if(StringUtil.checkNotNull(predate)&&StringUtil.checkNotNull(preframe)){
				int aa=Integer.parseInt(preframe.substring(0,2));
				if(predate.equals(datetime)&&hour>=aa){
					listRoom=null;
				}else{
					listRoom=dao.selectRoom(peocount,roomtype,predate,preframe);
				}
			}else{
				listRoom=dao.selectRoom(peocount,roomtype,predate,preframe);
			}
			this.target="/module/predetermine/CustomerQueryRoom.jsp";
			return "success";
		}
		
		/**
		 * 
		 * 先进行判断日期和时间段不为空，顾客才能下预订单
		 */
		public void addPredeterMine(){
			PredetermineDao dao=new PredetermineDaoImpI();
			if(StringUtil.checkNotNull(predate)&&StringUtil.checkNotNull(preframe)){
				dao.insertPreterMine(customerid, roomid, predate, preframe);
				Message mess=new Message();
				mess.setState(true);
				mess.setMessage("预定成功");
				this.getOut().print(StringUtil.transObjectToJson(mess));
			}else{
				Message mess=new Message();
				mess.setState(false);
				mess.setMessage("预订日期或时间段为空,请重新操作");
				this.getOut().print(StringUtil.transObjectToJson(mess));
			}
		}
		
		/**
		 * 顾客查看自己的预定单
		 * @return
		 */
		public String seeCustomerRoom(){
			PredetermineDao dao=new PredetermineDaoImpI();
			listCustomer=dao.selectCustomer(customerid);
			this.target="/module/predetermine/CustomerSeeRoom.jsp";
			return "success";
		}
		/**
		 * 
		 * 顾客根据自己预定的id进行取消预定桌号单
		 */
		public void customerCansel(){
			PredetermineDao dao=new PredetermineDaoImpI();
			dao.cansel(preid);
			Message mess=new Message();
			mess.setState(true);
			mess.setMessage("成功取消预定");
			String mess2=StringUtil.transObjectToJson(mess);
			this.getOut().print(mess2);
		}
		/**
		 * 员工从后台进行查询可预订的房桌号
		 * @return
		 */
		public String empSelectRoom(){
			PredetermineDao dao=new PredetermineDaoImpI();
			Date date=new Date();
			SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dateformat2=new SimpleDateFormat("HH");
			//date代表当前日期,hour代表当前小时,aa代表predate时间段的前2位数字
			String datetime=dateformat1.format(date);
			int hour=Integer.parseInt(dateformat2.format(date));
			if(StringUtil.checkNotNull(predate)&&StringUtil.checkNotNull(preframe)){
				int aa=Integer.parseInt(preframe.substring(0,2));
				if(predate.equals(datetime)&&hour>=aa){
					listRoom=null;
				}else{
					listRoom=dao.selectRoom(peocount,roomtype,predate,preframe);
					reserveRoom=dao.empFindReserveRoom(peocount, roomtype, predate, preframe);
				}
			}else{
				listRoom=dao.selectRoom(peocount,roomtype,predate,preframe);
				reserveRoom=dao.empFindReserveRoom(peocount, roomtype, predate, preframe);
			}
			this.target="/module/predetermine/backgroundQueryRoom.jsp";
			return "success";
		}
		/**
		 * 
		 * 后台员工添加一条预定桌房信息(要对所有的内容不能为空进行判断)
		 */
		public void empInsertPredeterMine(){
			PredetermineDao dao=new PredetermineDaoImpI();
			if(StringUtil.checkNotNull(roomid)&&StringUtil.checkNotNull(predate)&&StringUtil.checkNotNull(preframe)
				&&StringUtil.checkNotNull(precustomer)&&StringUtil.checkNotNull(prephone)){
				dao.empInsertPreterMine(roomid, predate, preframe, precustomer, prephone);
				Message mess=new Message();
				mess.setState(true);
				mess.setMessage("添加预订成功");
				this.getOut().print(StringUtil.transObjectToJson(mess));
			}else{
				Message mess=new Message();
				mess.setState(false);
				mess.setMessage("请仔细检查你的输入，至少有一条信息为空");
				this.getOut().print(StringUtil.transObjectToJson(mess));
			}
		}
		
		public String getPredate(){
			return predate;
		}
		public void setPredate(String predate) {
			this.predate = predate;
		}
		public String getPreframe() {
			return preframe;
		}
		public void setPreframe(String preframe) {
			this.preframe = preframe;
		}
		public String getTarget() {
			return target;
		}
		public void setTarget(String target) {
			this.target = target;
		}
		public List getListRoom() {
			return listRoom;
		}
		public void setListRoom(List listRoom) {
			this.listRoom = listRoom;
		}
		public String getCustomerid() {
			return customerid;
		}
		public void setCustomerid(String customerid) {
			this.customerid = customerid;
		}
		public String getRoomid() {
			return roomid;
		}
		public void setRoomid(String roomid) {
			this.roomid = roomid;
		}
		public List getListCustomer() {
			return listCustomer;
		}
		public void setListCustomer(List listCustomer) {
			this.listCustomer = listCustomer;
		}

		public String getPreid() {
			return preid;
		}

		public void setPreid(String preid) {
			this.preid = preid;
		}

		public String getPeocount() {
			return peocount;
		}

		public void setPeocount(String peocount) {
			this.peocount = peocount;
		}

		public String getRoomtype() {
			return roomtype;
		}

		public void setRoomtype(String roomtype) {
			this.roomtype = roomtype;
		}

		public String getPrecustomer() {
			return precustomer;
		}

		public void setPrecustomer(String precustomer) {
			this.precustomer = precustomer;
		}

		public String getPrephone() {
			return prephone;
		}

		public void setPrephone(String prephone) {
			this.prephone = prephone;
		}

		public List getReserveRoom() {
			return reserveRoom;
		}

		public void setReserveRoom(List reserveRoom) {
			this.reserveRoom = reserveRoom;
		}
		
}
