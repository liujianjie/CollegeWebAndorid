package com.dc.controller.predetermine;

import java.util.*;

import com.dc.dao.predetermine.PredetermineDao;
import com.dc.dao.predetermine.PredetermineDaoImpI;
import com.dc.entity.Message;
import com.dc.entity.PageEntity;
import com.dc.util.BaseAction;
import com.dc.util.StringUtil;

/*
 * ���������Ϻ����µ�����Ԥ������һ���Ĳ���
 */
public class linePredeterMine extends BaseAction{
		private Map map;				//��Ҫ��ѯ������ȫ��set��ȥ
		private PageEntity page;		//��ҳ��ʵ��
		private List roomlist;			//��ѯ���е����µ�Ԥ����Ϣ
		public String target;			//ͨ������ַ����е��ʴ���
		public String nowpage;			//���ع����ĵ�ǰҳ��
		public String customername;		//���ع˿��������в�ѯ
		public String roomnumber;		//���ط��������в�ѯ
		public String preline;			//��������Ԥ�����
		public String customerphone;	//���ع˿͵绰���в�ѯ
		public String predate;			//�������ڽ��в�ѯ(�������ڶ�����)
		public String roomtype;			//���ط����������ͽ��в�ѯ
		public String preid;			//����Ԥ��id����ȡ��Ԥ��
		public String preframe;			//����Ԥ��ʱ���
		
		/**
		 * Ա�������е�Ԥ����������Ϣ���в�ѯ
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
			mess.setMessage("�ɹ�ȡ��Ԥ��");
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
