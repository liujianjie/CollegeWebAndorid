package com.ht.pojo;

//后台用户表
public class BackGroundUser {
	private String b_id;
	private String b_username;
	private String b_pwd;
	private String b_tel;
	private String b_sex;
	private String b_address;
	private String b_positionid;
	private String b_touxiang;
	private Integer b_statu;
	
	public BackGroundUser(){}
	
	public BackGroundUser(String b_id, String b_username, String b_pwd, String b_tel, String b_sex, String b_address,
			String b_positionid, String b_touxiang, Integer b_statu) {
		super();
		this.b_id = b_id;
		this.b_username = b_username;
		this.b_pwd = b_pwd;
		this.b_tel = b_tel;
		this.b_sex = b_sex;
		this.b_address = b_address;
		this.b_positionid = b_positionid;
		this.b_touxiang = b_touxiang;
		this.b_statu = b_statu;
	}



	public String getB_id() {
		return b_id;
	}
	public void setB_id(String b_id) {
		this.b_id = b_id;
	}
	public String getB_username() {
		return b_username;
	}
	public void setB_username(String b_username) {
		this.b_username = b_username;
	}
	public String getB_pwd() {
		return b_pwd;
	}
	public void setB_pwd(String b_pwd) {
		this.b_pwd = b_pwd;
	}
	public Integer getB_statu() {
		return b_statu;
	}
	public void setB_statu(Integer b_statu) {
		this.b_statu = b_statu;
	}


	public String getB_tel() {
		return b_tel;
	}


	public void setB_tel(String b_tel) {
		this.b_tel = b_tel;
	}


	public String getB_sex() {
		return b_sex;
	}


	public void setB_sex(String b_sex) {
		this.b_sex = b_sex;
	}


	public String getB_address() {
		return b_address;
	}


	public void setB_address(String b_address) {
		this.b_address = b_address;
	}


	public String getB_positionid() {
		return b_positionid;
	}


	public void setB_positionid(String b_positionid) {
		this.b_positionid = b_positionid;
	}


	public String getB_touxiang() {
		return b_touxiang;
	}


	public void setB_touxiang(String b_touxiang) {
		this.b_touxiang = b_touxiang;
	}
	
}
