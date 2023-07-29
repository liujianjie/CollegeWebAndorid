package com.ht.yfbc.pojo;

public class Rack2 extends Rack{
	private Goodtype type;
	private Warehouse warehouse;
	
	public Rack2() {
		// TODO Auto-generated constructor stub
	}
	public Rack2(Goodtype type, Warehouse warehouse) {
		super();
		this.type = type;
		this.warehouse = warehouse;
	}
	public Goodtype getType() {
		return type;
	}
	public void setType(Goodtype type) {
		this.type = type;
	}
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	
	
}
