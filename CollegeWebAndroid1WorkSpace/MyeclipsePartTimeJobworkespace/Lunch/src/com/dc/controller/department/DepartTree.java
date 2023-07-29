package com.dc.controller.department;

import java.util.List;

import net.sf.json.JSONArray;

import com.dc.dao.department.DepartTreeDAO;
import com.dc.dao.department.DepartTreeDAOImpl;
import com.dc.util.BaseAction;

public class DepartTree extends BaseAction{
	private String target;
	private String departid;
	public void DepartTrees(){
		//System.out.println("1");
		DepartTreeDAO dao=new DepartTreeDAOImpl();
		List list=dao.SelectAllDepart();
		JSONArray json=new JSONArray();
		json=JSONArray.fromObject(list);
		this.getOut().print(json.toString());
	}
	public void DutyTrees(){
		DepartTreeDAO dao=new DepartTreeDAOImpl();
		List list=dao.SelectDutyBydid(departid);
		JSONArray json=new JSONArray();
		json=JSONArray.fromObject(list);
		this.getOut().print(json.toString());
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getDepartid() {
		return departid;
	}
	public void setDepartid(String departid) {
		this.departid = departid;
	}
	
}
