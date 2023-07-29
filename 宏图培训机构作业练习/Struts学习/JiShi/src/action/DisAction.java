package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.DynaActionForm;
import org.apache.struts.actions.DispatchAction;

import form.EmpForm;
import serviceI.EmpI;
import serviceImp.EmpImp;

public class DisAction extends DispatchAction{
	
	EmpI ss=new EmpImp();
	
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//动态表单
		//DynaActionForm
		
		List list=ss.selemp();
				
		request.setAttribute("list", list);
		
		return new ActionForward("/emplist.jsp");
	}
	
	
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//动态表单
		//DynaActionForm
		DynaActionForm  emp=(DynaActionForm)form;
		
//		System.out.println(emp.get("emp_id"));
		
		ss.delemp(Integer.parseInt((String) emp.get("emp_id")));
//		
//		EmpForm emp=(EmpForm)form;
//		
//		//System.out.println(emp.getEmp_id());
//		
//		ss.delemp(emp.getEmp_id());
		
		return new ActionForward("/dis.do?method=list",true);
	}
	
	
	public ActionForward toalter(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//动态表单
		//DynaActionForm
		DynaActionForm emp=(DynaActionForm)form;
		
		EmpForm emplist=ss.toalter(Integer.parseInt((String) emp.get("emp_id")));
				
		request.setAttribute("list", emplist);
		
		return new ActionForward("/alteremp.jsp");
	}
	
	
	public ActionForward alter(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		DynaActionForm emp=(DynaActionForm)form;
		EmpForm emp2=new EmpForm();
		emp2.setEmp_id(Integer.parseInt((String) emp.get("emp_id")));
		emp2.setEmp_name(((String) emp.get("emp_name")));
		emp2.setEmp_sex(((String) emp.get("emp_sex")));
		emp2.setEmp_salary(Float.parseFloat(((String) emp.get("emp_salary"))));
		emp2.setJoin_date(((String) emp.get("join_date")));

		ss.alter(emp2);
		
		return new ActionForward("/dis.do?method=list",true);
	}
	
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//动态表单
		//DynaActionForm
		DynaActionForm emp=(DynaActionForm)form;
		EmpForm emp2=new EmpForm();
		emp2.setEmp_id(Integer.parseInt((String) emp.get("emp_id")));
		emp2.setEmp_name(((String) emp.get("emp_name")));
		emp2.setEmp_sex(((String) emp.get("emp_sex")));
		emp2.setEmp_salary(Float.parseFloat(((String) emp.get("emp_salary"))));
		emp2.setJoin_date(((String) emp.get("join_date")));
		
		ss.addemp(emp2);
		
		return new ActionForward("/dis.do?method=list",true);
	}
}
