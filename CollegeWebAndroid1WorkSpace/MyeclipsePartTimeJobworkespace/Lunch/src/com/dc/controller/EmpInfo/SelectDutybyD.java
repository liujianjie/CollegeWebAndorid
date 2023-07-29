package com.dc.controller.EmpInfo;

import java.util.List;

import net.sf.json.JSONArray;

import com.dc.dao.Empinfo.EmpDAO;
import com.dc.dao.Empinfo.EmpDAOImpl;
import com.dc.util.BaseAction;

public class SelectDutybyD extends BaseAction{
	private String target;
	private String departid;
	private List Dutyinfo;
	/**
	 * 异步刷新职务
	 */
	public void selectDuty(){
		EmpDAO dao=new EmpDAOImpl();
		List list=dao.selectDutyBydepid(departid);
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
	public List getDutyinfo() {
		return Dutyinfo;
	}
	public void setDutyinfo(List dutyinfo) {
		Dutyinfo = dutyinfo;
	}
	
}
