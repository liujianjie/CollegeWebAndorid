package com.ht.pojo;

import java.util.Date;

/**
 * Rengzheng entity. @author MyEclipse Persistence Tools
 */

public class Rengzheng2 extends Rengzheng {

	// Fields

	private Ttzuser ttzuser;
	
	public Rengzheng2() {
		// TODO Auto-generated constructor stub
	}

	public Rengzheng2(Ttzuser ttzuser) {
		super();
		this.ttzuser = ttzuser;
	}

	public Ttzuser getTtzuser() {
		return ttzuser;
	}

	public void setTtzuser(Ttzuser ttzuser) {
		this.ttzuser = ttzuser;
	}
	
	
	
}