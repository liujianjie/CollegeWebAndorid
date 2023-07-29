package com.dc.controller.card;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.dc.dao.card.CardDAO;
import com.dc.dao.card.CardDAOImpl;
import com.dc.dao.order.OrderDAO;
import com.dc.dao.order.OrderDAOImpl;
import com.dc.entity.OrderdEntity;
import com.dc.entity.PageEntity;
import com.dc.util.BaseAction;

public class OrderDetail extends BaseAction {
	private List<OrderdEntity> orderdlist;
	private OrderdEntity order;
	private String info;
	private String customerid;
	private String money;
	private String cardid;
	private List list;
	private String orderid;
	private List list1;
	private String add;
	private String phone;
	private String content;
	private String province;
	private String city;
	private String district;
	/**
	 * 生成订单、订单详情、修改顾客信息
	 */
	public void insertorderd(){
		JSONArray json=JSONArray.fromObject(info);
		List list=json.toList(json,OrderdEntity.class);
		CardDAO card=new CardDAOImpl();
		Date date=new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String orderdate=sdf.format(date);

		int i=card.insertorder(customerid,orderdate,money,content);
		String orderid=Integer.toString(i);
		card.insertorderd(list,orderid);
		card.clear(customerid);
		card.updateinfo(customerid, add, phone,province,city,district);
		this.getOut().print("{\"state\":\"购买成功\"}");
	}
	/**
	 * 清空购物车
	 */
	public String clearcard(){
		CardDAO card=new CardDAOImpl();
		card.clear(customerid);
		return "clear";
	} 
	/**
	 * 删除购物车某个商品
	 */
	public String deletecard(){
		CardDAO card=new CardDAOImpl();
		card.delete(cardid);
		return "delete";
	}
	/**
	 * 用户查询所有订单
	 */
	public String findMyOrder(){
		CardDAO card=new CardDAOImpl();
		list=card.findMyOrder(customerid);
		return "myorder";
		
	}
	/**
	 * 查看订单详情
	 */
	public String MyOrderdetail(){
		OrderDAO order=new OrderDAOImpl();		
		list=order.findDetail(orderid);	
		list1=order.findById(orderid);
		return "detail";
	}
	/**
	 * 确认收货
	 */
	public void qrsh(){
		CardDAO card=new CardDAOImpl();
		
		card.finishOrder(orderid);
		this.getOut().print("{\"state\":\"true\",\"message\":\"订单完成\"}");
	}
	/**
	 *用户 取消订单
	 */
	public void qxdd(){
		OrderDAO order=new OrderDAOImpl();
		order.qxdd(orderid);
		this.getOut().print("{\"state\":\"true\",\"message\":\"取消成功\"}");
	}
	public List<OrderdEntity> getOrderdlist() {
		return orderdlist;
	}

	public void setOrderdlist(List<OrderdEntity> orderdlist) {
		this.orderdlist = orderdlist;
	}

	public OrderdEntity getOrder() {
		return order;
	}
	public void setOrder(OrderdEntity order) {
		this.order = order;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}

	
	/**
	 * @return the money
	 */
	public String getMoney() {
		return money;
	}
	/**
	 * @param money the money to set
	 */
	public void setMoney(String money) {
		this.money = money;
	}
	/**
	 * @return the cardid
	 */
	public String getCardid() {
		return cardid;
	}
	/**
	 * @param cardid the cardid to set
	 */
	public void setCardid(String cardid) {
		this.cardid = cardid;
	}
	public String getCustomerid() {
		return customerid;
	}
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	/**
	 * @return the list
	 */
	public List getList() {
		return list;
	}
	/**
	 * @param list the list to set
	 */
	public void setList(List list) {
		this.list = list;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	/**
	 * @return the list1
	 */
	public List getList1() {
		return list1;
	}
	/**
	 * @param list1 the list1 to set
	 */
	public void setList1(List list1) {
		this.list1 = list1;
	}
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	
	
}
