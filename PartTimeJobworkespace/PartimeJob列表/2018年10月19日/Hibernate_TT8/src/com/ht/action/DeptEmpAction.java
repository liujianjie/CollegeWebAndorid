package com.ht.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ht.common.ServiceFactory;
import com.ht.form.DeptEmpForm;
import com.ht.service.DeptEmpService;
import com.ht.service.impl.DeptEmpServiceImpl;
import com.ht.vo.DepartmentVo;
import com.ht.vo.EmployeeVo;

public class DeptEmpAction extends DispatchAction{
	
	//ʹ��service����ģʽ���õ�serviceʵ��        deptEmpService��service-config.xml�ļ������õ�name
	DeptEmpService ds=(DeptEmpService)ServiceFactory.getService("deptEmpService");
	
	public ActionForward add(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DeptEmpForm deptf=(DeptEmpForm)form;
		
		//����
		DepartmentVo dept=new DepartmentVo();
		BeanUtils.copyProperties(dept, deptf);
		
		
		//Ա��
		String[] enames=deptf.getEname();
		String[] sexs=deptf.getSex();
		for (int i = 0; i < enames.length; i++) {
			EmployeeVo emp=new EmployeeVo();
			emp.setEname(enames[i]);
			emp.setSex(sexs[i]);
			dept.getEmployees().add(emp);
			emp.setDepartmentVo(dept);
		}
		ds.addDept(dept);
		
		return null;
	}
	public ActionForward list(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List list= ds.listDept();
		request.setAttribute("list", list);
		return new ActionForward("/list.jsp");
	}
	
	public ActionForward toupd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DeptEmpForm deptf=(DeptEmpForm)form;
		DepartmentVo dept= ds.getDept(deptf.getDid());
		request.setAttribute("dept", dept);
		return new ActionForward("/upd.jsp");
	}
	
	public ActionForward upd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DeptEmpForm deptf=(DeptEmpForm)form;
		
		//����
		DepartmentVo dept=new DepartmentVo();
		BeanUtils.copyProperties(dept, deptf);
		
		
		//Ա��
		String[] enames=deptf.getEname();
		String[] sexs=deptf.getSex();
		Integer[] eids=deptf.getEid();
		for (int i = 0; i < enames.length; i++) {
			EmployeeVo emp=new EmployeeVo();
			//����Ա��ID 
			emp.setEid(eids[i]);
			
			emp.setEname(enames[i]);
			emp.setSex(sexs[i]);
			dept.getEmployees().add(emp);
			emp.setDepartmentVo(dept);
		}
		ds.updDept(dept);
		
		return new ActionForward("/deptemp.do?method=list",true);
	}
	
	public ActionForward del(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DeptEmpForm deptf=(DeptEmpForm)form;
		DepartmentVo dept= ds.getDept(deptf.getDid());
		ds.delDept(dept);
		return new ActionForward("/deptemp.do?method=list",true);
	}
	
	
	
	
	public ActionForward add2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		DeptEmpForm deptf=(DeptEmpForm)form;
		
		//Ա��
		String[] enames=deptf.getEname();
		String[] sexs=deptf.getSex();
		for (int i = 0; i < enames.length; i++) {
			EmployeeVo emp=new EmployeeVo();
			
			emp.setDeptid(deptf.getDid());//��ȡ����ID
			emp.setEname(enames[i]);
			emp.setSex(sexs[i]);
			
			ds.addEmp(emp);
		}
		
		return new ActionForward("/deptemp.do?method=list",true);
	}
	
	public ActionForward toadd(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		List deptlist= ds.listDept();
		request.setAttribute("deptlist", deptlist);
		return new ActionForward("/add2.jsp");
	} 
}
