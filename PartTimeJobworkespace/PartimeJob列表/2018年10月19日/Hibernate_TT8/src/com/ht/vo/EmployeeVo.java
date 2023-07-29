package com.ht.vo;

public class EmployeeVo {
	private Integer eid;
	private Integer deptid;
	private String ename;
	private String sex;
	
	//在多的一端放一的对象
	private DepartmentVo departmentVo;
	
	public DepartmentVo getDepartmentVo() {
		return departmentVo;
	}
	public void setDepartmentVo(DepartmentVo departmentVo) {
		this.departmentVo = departmentVo;
	}
	public Integer getEid() {
		return eid;
	}
	public void setEid(Integer eid) {
		this.eid = eid;
	}
	public Integer getDeptid() {
		return deptid;
	}
	public void setDeptid(Integer deptid) {
		this.deptid = deptid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
}
