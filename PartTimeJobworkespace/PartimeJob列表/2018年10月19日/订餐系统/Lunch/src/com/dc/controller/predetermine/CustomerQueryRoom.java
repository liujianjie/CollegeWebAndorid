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
 * ǰ��̨���е�Ԥ������������
 * @author K
 *
 */
public class CustomerQueryRoom extends BaseAction{
		private String predate;          //Ԥ������
		private String preframe;         //Ԥ��ʱ���
		private List listRoom;           //���п���Ԥ���ķ�����Ϣ
		private String target;			 //ͨ�õ�ַ�ַ�
		private String customerid;		 //�˿�id
		private String roomid;			 //����id
		private List listCustomer;       //�˿Ͳ�ѯ�Լ����е�Ԥ����Ϣ
		private String preid;            //Ԥ������id
		private String peocount;    	 //�˿�ͨ���������в�ѯ��Ԥ���ķ���
		private String roomtype;		 //�˿�ͨ���������Ͳ�ѯ��Ԥ���ķ���
		private String precustomer;		 //�˿ʹ�绰Ԥ�������µĹ˿�����
		private String prephone;		 //�˿ʹ�绰Ԥ��,���µĹ˿͵绰
		private List reserveRoom;		 //����ǽ���ѯ����Ԥ��������Ϣ�ŵ�list��ȥ
		
		/**
		 * ����ѡ���Ԥ������,��������,����,ʱ��������в�ѯ�������п���Ԥ���ķ�����Ϣ(ǰ̨��̨��ѯͨ�õ�)
		 * @return
		 */
		public String selectRoom(){
			PredetermineDao dao=new PredetermineDaoImpI();
			Date date=new Date();
			SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dateformat2=new SimpleDateFormat("HH");
			//date����ǰ����,hour����ǰСʱ,aa����predateʱ��ε�ǰ2λ����
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
		 * �Ƚ����ж����ں�ʱ��β�Ϊ�գ��˿Ͳ�����Ԥ����
		 */
		public void addPredeterMine(){
			PredetermineDao dao=new PredetermineDaoImpI();
			if(StringUtil.checkNotNull(predate)&&StringUtil.checkNotNull(preframe)){
				dao.insertPreterMine(customerid, roomid, predate, preframe);
				Message mess=new Message();
				mess.setState(true);
				mess.setMessage("Ԥ���ɹ�");
				this.getOut().print(StringUtil.transObjectToJson(mess));
			}else{
				Message mess=new Message();
				mess.setState(false);
				mess.setMessage("Ԥ�����ڻ�ʱ���Ϊ��,�����²���");
				this.getOut().print(StringUtil.transObjectToJson(mess));
			}
		}
		
		/**
		 * �˿Ͳ鿴�Լ���Ԥ����
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
		 * �˿͸����Լ�Ԥ����id����ȡ��Ԥ�����ŵ�
		 */
		public void customerCansel(){
			PredetermineDao dao=new PredetermineDaoImpI();
			dao.cansel(preid);
			Message mess=new Message();
			mess.setState(true);
			mess.setMessage("�ɹ�ȡ��Ԥ��");
			String mess2=StringUtil.transObjectToJson(mess);
			this.getOut().print(mess2);
		}
		/**
		 * Ա���Ӻ�̨���в�ѯ��Ԥ���ķ�����
		 * @return
		 */
		public String empSelectRoom(){
			PredetermineDao dao=new PredetermineDaoImpI();
			Date date=new Date();
			SimpleDateFormat dateformat1=new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat dateformat2=new SimpleDateFormat("HH");
			//date����ǰ����,hour����ǰСʱ,aa����predateʱ��ε�ǰ2λ����
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
		 * ��̨Ա�����һ��Ԥ��������Ϣ(Ҫ�����е����ݲ���Ϊ�ս����ж�)
		 */
		public void empInsertPredeterMine(){
			PredetermineDao dao=new PredetermineDaoImpI();
			if(StringUtil.checkNotNull(roomid)&&StringUtil.checkNotNull(predate)&&StringUtil.checkNotNull(preframe)
				&&StringUtil.checkNotNull(precustomer)&&StringUtil.checkNotNull(prephone)){
				dao.empInsertPreterMine(roomid, predate, preframe, precustomer, prephone);
				Message mess=new Message();
				mess.setState(true);
				mess.setMessage("���Ԥ���ɹ�");
				this.getOut().print(StringUtil.transObjectToJson(mess));
			}else{
				Message mess=new Message();
				mess.setState(false);
				mess.setMessage("����ϸ���������룬������һ����ϢΪ��");
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
