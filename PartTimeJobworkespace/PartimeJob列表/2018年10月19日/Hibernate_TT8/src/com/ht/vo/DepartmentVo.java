package com.ht.vo;

import java.util.HashSet;
import java.util.Set;

public class DepartmentVo {
	private Integer did;
	private String dname;
	
	private Integer parentId;//�ϼ�����ID
	public DepartmentVo(){}
	public DepartmentVo(int did,String dname){
		this.did=did;
		this.dname=dname;
	}
	
	
	public Integer getParentId() {
		return parentId;
	}
	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}
	//��һ��һ�˷�set����
	private Set employees=new HashSet();
	
	public Set getEmployees() {
		return employees;
	}
	public void setEmployees(Set employees) {
		this.employees = employees;
	}
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
	
	
}
