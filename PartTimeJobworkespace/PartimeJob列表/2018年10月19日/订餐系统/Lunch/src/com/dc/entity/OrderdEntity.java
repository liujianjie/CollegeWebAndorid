package com.dc.entity;

public class OrderdEntity {
	private String orderid;
	private String meal;
	private String count;
	private String price;
	private String customerid;
	
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public String getMeal() {
		return meal;
	}
	public void setMeal(String meal) {
		this.meal = meal;
	}
	public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	/**
	 * @return the customerid
	 */
	public String getCustomerid() {
		return customerid;
	}
	/**
	 * @param customerid the customerid to set
	 */
	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}
	private String customer_id;
	
}
