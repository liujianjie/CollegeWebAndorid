package com.dc.controller.department;

import java.util.List;

import com.dc.dao.department.DepartDAO;
import com.dc.dao.department.DepartDAOImpl;
import com.dc.util.BaseAction;
import com.dc.util.StringUtil;

public class DepartAction extends BaseAction{
	private String departid;
	public void close(){		
		DepartDAO d=new DepartDAOImpl();
		List list=d.findDepartEmployee(departid);
		
		if(!list.isEmpty()&&list!=null){
			this.getOut().print("{\"state\":0,\"message\":\"该部门不能禁用\"}");
		}else{
			d.close(departid);
			this.getOut().print("{\"state\":1,\"message\":\"该部门能禁用\"}");
		}
	}
	public void open(){
		DepartDAO d=new DepartDAOImpl();
		d.open(departid);
		this.getOut().print("{\"state\":1,\"message\":\"该部门能启用\"}");
	}
	public String getDepartid() {
		return departid;
	}
	public void setDepartid(String departid) {
		this.departid = departid;
	}
	
}
