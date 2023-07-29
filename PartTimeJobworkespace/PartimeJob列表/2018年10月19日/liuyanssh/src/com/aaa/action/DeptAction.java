package com.aaa.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.biz.CommentBiz;
import com.aaa.biz.DeptBiz;
import com.aaa.entity.Comment;
import com.aaa.entity.Dept;
import com.aaa.util.PageEntity;
import com.alibaba.fastjson.JSON;

@Controller
@ParentPackage("struts-default")
public class DeptAction extends BaseAction {
	private PageEntity page;
	private Dept dept;
	private Integer deptId;
	private Integer departmentId;
	private String deptName;
	private String checks;
	@Autowired
	private DeptBiz deptbiz;
	
	
	@Action("getDeptListBydeparid")
	public String getDeptListBydeparid() {
		System.out.println(departmentId);
		String json = JSON.toJSONString(deptbiz.getDeptListBydeparid(departmentId));
		try{
			System.out.println(json);
			getWrite().print(json);
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}
	
	//perimson
	@Action("toPremiss")
	public String toPremiss() {
		// 通过deptid 获取有的checkbox
		List list = deptbiz.getLevelIdList(deptId);
		System.out.println("toPremiss() "+list.size());
		getSession().put("userperlist", list);
		return "jiedianguanli";

	}
	
	@Action("saveDeptpermission")
	public String saveDeptpermission(){
		System.out.println("saveDeptpermission"+checks);
		
		String[] array  = checks.split(",");
		//循环给Level_dept 增加值
		for(String i : array){
			int j = Integer.parseInt(i);
			deptbiz.setLevelAndDept(j, deptId);
		}
		try {
			getWrite().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Action("getAlldept")
	public String getAlldept() {
		if (page == null) {
			page = new PageEntity();
		}
		PageEntity pageEntity = deptbiz.getDeptList(page);
		String json = JSON.toJSONString(pageEntity);
		try {
			getWrite().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Action("addDept")
	public String addDept() {
		System.out.println(departmentId);
		System.out.println(deptName);
		dept = new Dept(deptId, deptName, departmentId);
		deptbiz.addDept(dept);
		try {
			getWrite().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Action("delDept")
	public String delDept() {
//		deptbiz.del(dept);
		try {
			getWrite().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Action("toupdatedept")
	public String toupdatedept() {
		System.out.println(deptId);
		return "alertdept";
	}
	@Action("updatedept")
	public String updatedept() {
		System.out.println(deptName);
		dept = new Dept(deptId, deptName, departmentId);
		deptbiz.updateBySql(dept);
		try {
			getWrite().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Action("getDeptOne")
	public String getDeptOne() {
//		String str = deptbiz.getDeptOne(deptId).toString();
		String json ="";
		try{
			 json = JSON.toJSONString(deptbiz.getDeptOne(deptId));
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(json);
		try {
			getWrite().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("errror");
		}
		
		return null;
	}

	public PageEntity getPage() {
		return page;
	}

	public void setPage(PageEntity page) {
		this.page = page;
	}

	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	public String getChecks() {
		return checks;
	}
	public void setChecks(String checks) {
		this.checks = checks;
	}

}
