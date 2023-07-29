package com.dc.controller.predetermine;

import java.util.*;

import com.dc.dao.predetermine.PredetermineDao;
import com.dc.dao.predetermine.PredetermineDaoImpI;
import com.dc.entity.Message;
import com.dc.util.BaseAction;
import com.dc.util.StringUtil;

public class OpenTable extends BaseAction{
		private List roomlist;			//��������SQL����������з�������Ϣ
		private String roomnumber;		//��������ǰ̨��ѯ�ķ�����
		private String target;			//�������յ�ַ���ַ���
		private String roomid;			//�������տ����ķ����ID
		private List reservelist;		//�������յ�ǰʱ��ε�Ԥ����
		
		/**
		 * ����ʱ��ѯ���еķ�������Ϣ
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
		 * ����ʱ�޸����ӵ�״̬
		 */
		public void updateRoomType(){
			PredetermineDao dao=new PredetermineDaoImpI();
			dao.updateOpenRoom(roomid);
			Message mess=new Message();
			mess.setState(true);
			mess.setMessage("�����ɹ�");
			this.getOut().print(StringUtil.transObjectToJson(mess));
		}
		/**
		 * ����ʹ������ɴ�ɨ��״̬
		 */
		public void recoverRoomType(){
			PredetermineDao dao=new PredetermineDaoImpI();
			dao.recoverOpenRoom(roomid);
			Message mess=new Message();
			mess.setState(true);
			mess.setMessage("��ʼ��ɨ��");
			this.getOut().print(StringUtil.transObjectToJson(mess));
		}
		/**
		 * �����ɨ���ָ�����״̬
		 */
		public void huifuRoomType(){
			PredetermineDao dao=new PredetermineDaoImpI();
			dao.huifuOpenRoom(roomid);
			Message mess=new Message();
			mess.setState(true);
			mess.setMessage("�ָ����гɹ�");
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
