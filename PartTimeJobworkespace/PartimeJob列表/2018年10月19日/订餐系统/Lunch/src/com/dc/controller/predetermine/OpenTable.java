package com.dc.controller.predetermine;

import java.util.*;

import com.dc.dao.predetermine.PredetermineDao;
import com.dc.dao.predetermine.PredetermineDaoImpI;
import com.dc.entity.Message;
import com.dc.util.BaseAction;
import com.dc.util.StringUtil;

public class OpenTable extends BaseAction{
		private List roomlist;			//用来接收SQL语句查出的所有房间表的信息
		private String roomnumber;		//用来接收前台查询的房间名
		private String target;			//用来接收地址的字符串
		private String roomid;			//用来接收开桌的房间的ID
		private List reservelist;		//用来接收当前时间段的预定桌
		
		/**
		 * 开桌时查询所有的房间表的信息
		 * @return
		 */
		public String openSeeTable(){
			PredetermineDao dao=new PredetermineDaoImpI();
			roomlist=dao.openFindRoom(roomnumber);
			reservelist=dao.yudingOpenRoom();
			this.target="/module/predetermine/openTables.jsp";
			return "success";
		}
		/**
		 * 开桌时修改桌子的状态
		 */
		public void updateRoomType(){
			PredetermineDao dao=new PredetermineDaoImpI();
			dao.updateOpenRoom(roomid);
			Message mess=new Message();
			mess.setState(true);
			mess.setMessage("开桌成功");
			this.getOut().print(StringUtil.transObjectToJson(mess));
		}
		/**
		 * 房间使用完后变成打扫中状态
		 */
		public void recoverRoomType(){
			PredetermineDao dao=new PredetermineDaoImpI();
			dao.recoverOpenRoom(roomid);
			Message mess=new Message();
			mess.setState(true);
			mess.setMessage("开始打扫了");
			this.getOut().print(StringUtil.transObjectToJson(mess));
		}
		/**
		 * 房间打扫完后恢复空闲状态
		 */
		public void huifuRoomType(){
			PredetermineDao dao=new PredetermineDaoImpI();
			dao.huifuOpenRoom(roomid);
			Message mess=new Message();
			mess.setState(true);
			mess.setMessage("恢复空闲成功");
			this.getOut().print(StringUtil.transObjectToJson(mess));
		}
		public List getRoomlist() {
			return roomlist;
		}

		public void setRoomlist(List roomlist) {
			this.roomlist = roomlist;
		}

		public String getRoomnumber() {
			return roomnumber;
		}

		public void setRoomnumber(String roomnumber) {
			this.roomnumber = roomnumber;
		}

		public String getTarget() {
			return target;
		}

		public void setTarget(String target) {
			this.target = target;
		}
		public String getRoomid() {
			return roomid;
		}
		public void setRoomid(String roomid) {
			this.roomid = roomid;
		}
		public List getReservelist() {
			return reservelist;
		}
		public void setReservelist(List reservelist) {
			this.reservelist = reservelist;
		}
}
