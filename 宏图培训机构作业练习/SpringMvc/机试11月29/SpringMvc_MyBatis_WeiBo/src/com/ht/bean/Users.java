package com.ht.bean;

import java.io.Serializable;

public class Users implements Serializable{
	private Integer u_id;
	private String u_username;
	private String u_password;
	private Integer	u_age;
	private String u_sex;
	private String u_nickname;
	private String u_mobile;
	private String u_address;
	private Integer u_supper;
	private String u_picpath;
	public Integer getU_id() {
		return u_id;
	}
	public void setU_id(Integer u_id) {
		this.u_id = u_id;
	}
	public String getU_username() {
		return u_username;
	}
	public void setU_username(String u_username) {
		this.u_username = u_username;
	}
	public String getU_password() {
		return u_password;
	}
	public void setU_password(String u_password) {
		this.u_password = u_password;
	}
	public Integer getU_age() {
		return u_age;
	}
	public void setU_age(Integer u_age) {
		this.u_age = u_age;
	}
	
	public String getU_sex() {
		return u_sex;
	}
	public void setU_sex(String u_sex) {
		this.u_sex = u_sex;
	}
	public String getU_nickname() {
		return u_nickname;
	}
	public void setU_nickname(String u_nickname) {
		this.u_nickname = u_nickname;
	}
	public String getU_mobile() {
		return u_mobile;
	}
	public void setU_mobile(String u_mobile) {
		this.u_mobile = u_mobile;
	}
	public String getU_address() {
		return u_address;
	}
	public void setU_address(String u_address) {
		this.u_address = u_address;
	}
	public Integer getU_supper() {
		return u_supper;
	}
	public void setU_supper(Integer u_supper) {
		this.u_supper = u_supper;
	}
	public String getU_picpath() {
		return u_picpath;
	}
	public void setU_picpath(String u_picpath) {
		this.u_picpath = u_picpath;
	}
	
}
