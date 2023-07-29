package com.aaa.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aaa.biz.DepartmentBiz;
import com.aaa.biz.DeptBiz;
import com.aaa.biz.StaffBiz;
import com.aaa.biz.UserBiz;
import com.aaa.entity.Department;
import com.aaa.entity.Staff;
@Controller
@ParentPackage("struts-default")
public class BkUserAction extends BaseAction {
	private Staff BkloginUser;
	private String staffUserName;
	private String staffUserPwd;
	private String staDeptId;
	
	public Staff getBkloginUser() {
		return BkloginUser;
	}

	public void setBkloginUser(Staff bkloginUser) {
		BkloginUser = bkloginUser;
	}
	public String getStaDeptId() {
		return staDeptId;
	}

	public void setStaDeptId(String staDeptId) {
		this.staDeptId = staDeptId;
	}

	public String getStaffUserName() {
		return staffUserName;
	}

	public void setStaffUserName(String staffUserName) {
		this.staffUserName = staffUserName;
	}

	public String getStaffUserPwd() {
		return staffUserPwd;
	}

	public void setStaffUserPwd(String staffUserPwd) {
		this.staffUserPwd = staffUserPwd;
	}

	private List<Department> list;
	
	
	@Autowired
	private UserBiz userBiz;
	@Autowired
	private DepartmentBiz departBiz;
	@Autowired
	private StaffBiz staffBiz;
	@Autowired
	private DeptBiz deptbiz;
	@Action("bglogin")
	public String bglogin() throws IOException {
		System.out.println(staffUserPwd);
		if (staffUserPwd != null && staffUserName != null) {
			// ���û���Ϣ�ŵ�session��
//
//			getSession().put("user", user);
			System.out.println(staffUserName);
			Staff sta = staffBiz.selOneByNameAndPsd(staffUserName, staffUserPwd);
			// ��ȡȨ��
			// 权限
			System.out.println(sta.getStaDeptId());
			List list = deptbiz.getLevelIdList(sta.getStaDeptId());
			getSession().put("UserpreReallist", list);
			
			
			getSession().put("staff", sta);
			getWrite().print("true");
			System.out.println("true");
			return null;

		} else {
			getWrite().print("false");
			return "false";
		}
	}

	// ע��
	@Action("bgregister")
	public String bgregister() throws IOException {
		//System.out.println(BkloginUser.getStaffUserName()+BkloginUser.getStaffUserPwd());
		System.out.println(staffUserPwd);
		System.out.println(staffUserName);
		System.out.println(staDeptId);
		Staff bkloginUser = new Staff();
		bkloginUser.setStaDeptId(Integer.parseInt(staDeptId));
		bkloginUser.setStaffUserName(staffUserName);
		bkloginUser.setStaffUserPwd(staffUserPwd);
		int i = staffBiz.add(bkloginUser);
		if(i > 0){
			return "tobkLogin";
		}else{
			return "tobkRegister";
		}
	}
	@Action("getDepartmentList")
	public String getDepartmentList() throws IOException {
		list = departBiz.getDepartmentList();
		//JSONObject json=new JSONObject(list);
		//json.
		//out.println(json.toString());
		return "success";
	}
	
	public List<Department> getList() {
		return list;
	}

	public void setList(List<Department> list) {
		this.list = list;
	}

}
