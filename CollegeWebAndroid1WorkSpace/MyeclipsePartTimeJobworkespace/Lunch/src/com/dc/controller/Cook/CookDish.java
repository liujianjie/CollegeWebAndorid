package com.dc.controller.Cook;

import java.util.*;

import com.dc.dao.cook.cookDao;
import com.dc.dao.cook.cookDaoImpl;
import com.dc.entity.Message;
import com.dc.entity.PageEntity;
import com.dc.util.BaseAction;
import com.dc.util.StringUtil;

public class CookDish extends BaseAction{
		private Map map;				//��Ҫ��ѯ�������ŵ�map��
		private List lianlist;			//��ѯ����δ���������͵�����Ķ���
		private List relist;			//��ѯ����δ�����Ȳ��͵�����Ķ���(�˶��ʱ��)
		private List refewlist;			//��ѯ����δ�����Ȳ��͵�����Ķ���(���ٵ�ʱ��)
		private List finishlist;		//��ѯ������ɵĲ�Ʒ
		private String target;			//������ת���ַ���·��
		private String orderdate;		//���غ��ѡ������˳�������
		private String orderdetailid;	//����һ�����������id�����޸Ĳ˵�δ���״̬
		private String state;			//����һ���˵�״̬�Ӷ������޸�
		private String cookid;			//������Ҫ�޸ĵ��Ȳ˵�cook�е�ID
		private String orderdetailid2;	//�����Ȳ��޸�(����)
		
		/**
		 * �������͵�����Ķ�����������(����δ�������ˣ�δ�����Ȳˣ�������ɵĲ�Ʒ)
		 * @return
		 */
		public String seeCookRank(){
			cookDao dao=new cookDaoImpl();
			lianlist=dao.selectLianDish();
			if(StringUtil.checkNotNull(orderdate)){
				if(orderdate.equals("2")){
					relist=dao.usFood();
				}
				if(orderdate.equals("1")){
					refewlist=dao.dishFewPeople();
				}
			}else{
				refewlist=dao.dishFewPeople();
			}
			finishlist=dao.selectFinishDish();
			this.setTarget("/module/Cook/cookDishRank.jsp");
			return "success";
		}
		/**
		 * ��ʦ������ˣ��Ӷ��ı�ò˵�״̬
		 */
		public void cookFinishDish(){
			cookDao dao=new cookDaoImpl();
			dao.finishDishLian(orderdetailid,state);
		}
		/**
		 * ��ʦ����Ȳˣ��Ӷ��ı�ò˵�״̬(�˶��ʱ��)
		 */
		public void cookFinishRe(){
			cookDao dao=new cookDaoImpl();
			dao.finishRe(state, cookid);
		}
		/**
		 * ��ʦ����Ȳˣ��Ӷ��ı�ò˵�״̬(���ٵ�ʱ��)
		 */
		public void cookFewDish(){
			cookDao dao=new cookDaoImpl();
			dao.finishRe(state,cookid);
		}
		
		public String getTarget() {
			return target;
		}

		public void setTarget(String target) {
			this.target = target;
		}

		public Map getMap() {
			return map;
		}

		public void setMap(Map map) {
			this.map = map;
		}

		public String getOrderdate() {
			return orderdate;
		}

		public void setOrderdate(String orderdate) {
			this.orderdate = orderdate;
		}

		public String getOrderdetailid() {
			return orderdetailid;
		}

		public void setOrderdetailid(String orderdetailid) {
			this.orderdetailid = orderdetailid;
		}
		
		public List getRelist() {
			return relist;
		}
		public void setRelist(List relist) {
			this.relist = relist;
		}
		public List getLianlist() {
			return lianlist;
		}
		public void setLianlist(List lianlist) {
			this.lianlist = lianlist;
		}
		public String getState() {
			return state;
		}
		public void setState(String state) {
			this.state = state;
		}
		public List getFinishlist() {
			return finishlist;
		}
		public void setFinishlist(List finishlist) {
			this.finishlist = finishlist;
		}
		public String getCookid() {
			return cookid;
		}
		public void setCookid(String cookid) {
			this.cookid = cookid;
		}
		public List getRefewlist() {
			return refewlist;
		}
		public void setRefewlist(List refewlist) {
			this.refewlist = refewlist;
		}
		public String getOrderdetailid2() {
			return orderdetailid2;
		}
		public void setOrderdetailid2(String orderdetailid2) {
			this.orderdetailid2 = orderdetailid2;
		}
		
}
