package com.dc.controller.Cook;

import java.util.*;

import com.dc.dao.cook.cookDao;
import com.dc.dao.cook.cookDaoImpl;
import com.dc.entity.Message;
import com.dc.entity.PageEntity;
import com.dc.util.BaseAction;
import com.dc.util.StringUtil;

public class CookDish extends BaseAction{
		private Map map;				//将要查询的条件放到map里
		private List lianlist;			//查询所有未做的凉菜送到后厨的订单
		private List relist;			//查询所有未做的热菜送到后厨的订单(人多的时候)
		private List refewlist;			//查询所有未做的热菜送到后厨的订单(人少的时候)
		private List finishlist;		//查询所有完成的菜品
		private String target;			//返回跳转的字符串路径
		private String orderdate;		//返回后厨选择做菜顺序的条件
		private String orderdetailid;	//返回一个订单详情表id进行修改菜的未完成状态
		private String state;			//返回一个菜的状态从而进行修改
		private String cookid;			//返回需要修改的热菜的cook中的ID
		private String orderdetailid2;	//返回热菜修改(人少)
		
		/**
		 * 将所有送到后厨的订单进行排序(包括未做的凉菜，未做的热菜，所有完成的菜品)
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
		 * 厨师完成凉菜，从而改变该菜的状态
		 */
		public void cookFinishDish(){
			cookDao dao=new cookDaoImpl();
			dao.finishDishLian(orderdetailid,state);
		}
		/**
		 * 厨师完成热菜，从而改变该菜的状态(人多的时候)
		 */
		public void cookFinishRe(){
			cookDao dao=new cookDaoImpl();
			dao.finishRe(state, cookid);
		}
		/**
		 * 厨师完成热菜，从而改变该菜的状态(人少的时候)
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
