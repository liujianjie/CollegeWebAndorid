package com.ht.pojo;

public class Permission {
	private String p_id;
	private String b_id;
	private Integer p_list;
	
	public Permission(){}

	public Permission(String p_id, String b_id, Integer p_list) {
		super();
		this.p_id = p_id;
		this.b_id = b_id;
		this.p_list = p_list;
	}

	public String getP_id() {
		return p_id;
	}

	public void setP_id(String p_id) {
		this.p_id = p_id;
	}

	public String getB_id() {
		return b_id;
	}

	public void setB_id(String b_id) {
		this.b_id = b_id;
	}

	public Integer getP_list() {
		return p_list;
	}

	public void setP_list(Integer p_list) {
		this.p_list = p_list;
	}
	
	
}
