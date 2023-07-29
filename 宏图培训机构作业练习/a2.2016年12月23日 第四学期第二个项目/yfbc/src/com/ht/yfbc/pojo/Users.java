package com.ht.yfbc.pojo;

import java.io.Serializable;
/**
 * <p>users用户表</p>
 *	<p>id:sys_guid(),32位的字符串</p>
 *	<p>username：用户名</p>
 *	<p>password：密码</p>
 *	<p>sex：性别</p>
 *	<p>mobile：手机号码</p>
 *	<p>address：现住址</p>
 *	<p>positionid：对应权限列表id</p>
 *	<p>permissionid：对应权限列表id</p>
 *	<p>picpath：头像存储路径</p>
 **	<p>warehouseid：所属仓库id</p>
 * 	<p>Day 2016-12-27</p>
 * @author 刘宗龙
 * 
 *	
 */
public class Users implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String id;
	private String username;
	private String password;
	private String sex;
	private String mobile;
	private String address;
	private String positionid;
	private String permissionid;
	private String picpath;
	private String warehouseid;
	
	public Users() {
	}

	public Users(String id, String username, String password, String sex, String mobile, String address,
			String positionid, String permissionid, String picpath, String warehouseid) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.sex = sex;
		this.mobile = mobile;
		this.address = address;
		this.positionid = positionid;
		this.permissionid = permissionid;
		this.picpath = picpath;
		this.warehouseid = warehouseid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPositionid() {
		return positionid;
	}

	public void setPositionid(String positionid) {
		this.positionid = positionid;
	}

	public String getPermissionid() {
		return permissionid;
	}

	public void setPermissionid(String permissionid) {
		this.permissionid = permissionid;
	}

	public String getPicpath() {
		return picpath;
	}

	public void setPicpath(String picpath) {
		this.picpath = picpath;
	}

	public String getWarehouseid() {
		return warehouseid;
	}

	public void setWarehouseid(String warehouseid) {
		this.warehouseid = warehouseid;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", password=" + password + ", sex=" + sex + ", mobile="
				+ mobile + ", address=" + address + ", positionid=" + positionid + ", permissionid=" + permissionid
				+ ", picpath=" + picpath + ", warehouseid=" + warehouseid + "]";
	}

	
}
