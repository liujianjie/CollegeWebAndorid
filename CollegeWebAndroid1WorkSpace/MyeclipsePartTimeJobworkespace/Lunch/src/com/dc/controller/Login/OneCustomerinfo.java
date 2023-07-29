package com.dc.controller.Login;

import java.util.List;
import java.util.Map;

import com.dc.dao.Login.UserLoginDAO;
import com.dc.dao.Login.UserLoginDAOImpl;
import com.dc.util.StringUtil;

public class OneCustomerinfo {
	private String customername;
	private String customeruser;
	private String pwd;
	private String birthday;
	private String sex;
	private String customerphone;
	private String province;
	private String city;
	private String district;
	private String customeradd;
	private String customerid;
	private Map onecustomerlist;
	private String target;
	public String getTarget() {
		return target;
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public String updatecustomer(){
		if(StringUtil.checkNotNull(customerid)){
			UserLoginDAO dao=new UserLoginDAOImpl();
			onecustomerlist= dao.selectBycustid(customerid);
			this.target="module/Login/Register.jsp";
			return "success";
		}else{
			this.target="module/Login/Menu.jsp";
			return "success";
		}
				
	}
	
	public Map getOnecustomerlist() {
		return onecustomerlist;
	}

	public void setOnecustomerlist(Map onecustomerlist) {
		this.onecustomerlist = onecustomerlist;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomeruser() {
		return customeruser;
	}
	public void setCustomeruser(String customeruser) {
		this.customeruser = customeruser;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getCustomerphone() {
		return customerphone;
	}
	public void setCustomerphone(String customerphone) {
		this.customerphone = customerphone;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCustomeradd() {
		return customeradd;
	}
	public void setCustomeradd(String customeradd) {
		this.customeradd = customeradd;
	}
	
}
