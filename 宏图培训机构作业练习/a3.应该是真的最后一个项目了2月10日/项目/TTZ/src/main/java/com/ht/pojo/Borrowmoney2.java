package com.ht.pojo;

import java.util.Date;

/**
 * Ҳ����������ûʲô�� ������Ҫ����װʣ������
 */

public class Borrowmoney2 extends Borrowmoney implements java.io.Serializable {

	// Fields
	
	private Integer syday;

	public Borrowmoney2() {
		// TODO Auto-generated constructor stub
	}

	public Borrowmoney2(Integer syday) {
		super();
		this.syday = syday;
	}

	public Integer getSyday() {
		return syday;
	}

	public void setSyday(Integer syday) {
		this.syday = syday;
	}
	
}