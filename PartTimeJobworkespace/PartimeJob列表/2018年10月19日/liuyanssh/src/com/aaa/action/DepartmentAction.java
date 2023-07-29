package com.aaa.action;

import java.io.IOException;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.biz.CommentBiz;
import com.aaa.biz.DepartmentBiz;
import com.aaa.biz.DeptBiz;
import com.aaa.entity.Comment;
import com.aaa.entity.Department;
import com.aaa.entity.Dept;
import com.aaa.util.PageEntity;
import com.alibaba.fastjson.JSON;

@Controller
@ParentPackage("struts-default")
public class DepartmentAction extends BaseAction {
	private PageEntity page;
	private Department department;
	private Integer departmentId;
	@Autowired
	private DepartmentBiz departbiz;
	@Autowired
	private DeptBiz deptbiz;
	@Action("getAlldepartment")
	public String getAlldepartment() {
		System.out.println("getAlldepartment");
		if (page == null) {
			page = new PageEntity();
		}
		PageEntity pageEntity = departbiz.getAllDepartment(page);
		String json = JSON.toJSONString(pageEntity);
		try {
			getWrite().print(json);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Action("addDepartment")
	public void addDepartment() {
		System.out.println(department.getDepartmentName());
		departbiz.addBysql(department);
		try {
			getWrite().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Action("delDepartmentOne")
	public String delDepartmentOne() {
		System.out.println(department.getDepartmentId());
		// 删除
		deptbiz.delDepByDepartId(departmentId);
		departbiz.delDepart(departmentId);
//		departbiz.del(department);
		try {
			getWrite().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Action("toupdatedepart")
	public String toupdatedepart() {
		return "alertdepartment";
	}
	@Action("updatedepartment")
	public void updatedepartment() {
		System.out.println("updatedepartment()");
		System.out.println(department.getDepartmentName());
		System.out.println(department.getDepartmentId());
		departbiz.updateBySql(department);
		try {
			getWrite().print("true");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Action("getDepartmentOne")
	public String getDepartmentOne() {
		String json = JSON.toJSONString(departbiz.getDepartmentOne(departmentId));
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
	@Action("getDepartmentMore")
	public String getDepartmentMore() {
		String json = JSON.toJSONString(departbiz.getDepartmentList());
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

	public Integer getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	

}
