package com.ht.yfbc.pojo;

public class Warehouse2 extends Warehouse{
	private City city;
	private Users user;
	
	public Warehouse2() {
		// TODO Auto-generated constructor stub
	}

	public Warehouse2(City city, Users user) {
		super();
		this.city = city;
		this.user = user;
	}

	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}
	
	
}
