package com.ht.yfbc.pojo;

public class putaway2 extends Putaway{
	private Warehouse war;
	private Rack rack;
	private InStorage ins;
	private Receiving rece;
	
	public putaway2() {
		// TODO Auto-generated constructor stub
	}

	public putaway2(Warehouse war, Rack rack, InStorage ins, Receiving rece) {
		super();
		this.war = war;
		this.rack = rack;
		this.ins = ins;
		this.rece = rece;
	}

	public Warehouse getWar() {
		return war;
	}

	public void setWar(Warehouse war) {
		this.war = war;
	}

	public Rack getRack() {
		return rack;
	}

	public void setRack(Rack rack) {
		this.rack = rack;
	}

	public InStorage getIns() {
		return ins;
	}

	public void setIns(InStorage ins) {
		this.ins = ins;
	}

	public Receiving getRece() {
		return rece;
	}

	public void setRece(Receiving rece) {
		this.rece = rece;
	}
	
	
}
