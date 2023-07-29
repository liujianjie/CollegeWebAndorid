package com.ht.form;

import org.apache.struts.action.ActionForm;

public class DeptEmpForm extends ActionForm{
	//部门
	private Integer did;
	private String dname;
	private Integer parentId;//上级部门ID

	//员工
	private Integer[] eid;
	private Integer deptid;
	private String[] ename;
	private String[] sex;
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	public Integer[] getEid() {
		return eid;
	}
	public void setEid(Integer[] eid) {
		this.eid = eid;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	public String[] getEname() {
		return ename;
	}
	public void setEname(String[] ename) {
		this.ename = ename;
	}
	public String[] getSex() {
		return sex;
	}
	public void setSex(String[] sex) {
		this.sex = sex;
	}
	
	
}
