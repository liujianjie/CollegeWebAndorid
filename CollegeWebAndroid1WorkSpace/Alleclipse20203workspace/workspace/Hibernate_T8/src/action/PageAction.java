package action;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import common.ServiceFactory;
import serviceI.DeptServiceI;
import serviceImp.DeptServiceImp;

public class PageAction extends DispatchAction{
		
	//����ģʽ
	//DeptServiceI ss=(DeptServiceI)ServiceFactory.getService("deptservice");
	DeptServiceI ss=new DeptServiceImp();
	
	public ActionForward factory(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("������");
		ss.say();
		return null;
	}
	public ActionForward hibernatehql(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int pageCount=5;
		int currPage=1;
		int rowCount=ss.totalRowdept();;
		int totalPage=(rowCount+pageCount-1)/pageCount;
		System.out.println(rowCount+"������ ��"+totalPage+"ҳ");
		
		String currpage=request.getParameter("currpage");
		//�ж��Ƿ�Ϊ��
		if(currpage!=null&&!currpage.equals("")){
			currPage=Integer.parseInt(currpage);
		}
		
		if(currPage<1){
			currPage=1;
		}
		
		if(currPage>totalPage){
			currPage=totalPage;
		}
		
		List list=ss.hibernatehql((currPage-1)*pageCount, pageCount);

		//System.out.println(list.size());
		request.setAttribute("list", list);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("currPage", currPage);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("totalPage", totalPage);
		return new ActionForward("/listhql.jsp");
	}
	public ActionForward hibernatebysql(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int pageCount=5;
		int currPage=1;
		int rowCount=ss.totalRowemp();;
		int totalPage=(rowCount+pageCount-1)/pageCount;
		
		System.out.println(rowCount+"������ ��"+totalPage+"ҳ");
		
		String currpage=request.getParameter("currpage");
		//�ж��Ƿ�Ϊ��
		if(currpage!=null&&!currpage.equals("")){
			currPage=Integer.parseInt(currpage);
		}
		
		if(currPage<1){
			currPage=1;
		}
		
		if(currPage>totalPage){
			currPage=totalPage;
		}
		
		List list=ss.hibernatesql((currPage-1)*pageCount, pageCount);

		System.out.println(list.size());
		for(Iterator it=list.iterator();it.hasNext();){
			Object obj[]=(Object[])it.next();
			System.out.println(obj[0]+"  "+obj[1]+"  "+obj[2]);
		}
		request.setAttribute("list", list);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("currPage", currPage);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("totalPage", totalPage);
		return new ActionForward("/listsql1.jsp");
	}
	
	public ActionForward hibernatebysql1(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int pageCount=5;
		int currPage=1;
		int rowCount=ss.totalRowemp();;
		int totalPage=(rowCount+pageCount-1)/pageCount;
		
		System.out.println(rowCount+"������ ��"+totalPage+"ҳ");
		
		String currpage=request.getParameter("currpage");
		//�ж��Ƿ�Ϊ��
		if(currpage!=null&&!currpage.equals("")){
			currPage=Integer.parseInt(currpage);
		}
		
		if(currPage<1){
			currPage=1;
		}
		
		if(currPage>totalPage){
			currPage=totalPage;
		}
		
		List list=ss.hibernatesql1((currPage-1)*pageCount, pageCount);

		System.out.println(list.size());
		for(Iterator it=list.iterator();it.hasNext();){
			Map map=(Map)it.next();
			System.out.println(map.get("EMPNAME")+"  "+map.get("SEX")+"  "+map.get("DEPTNAME"));
		}
		request.setAttribute("list", list);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("currPage", currPage);
		request.setAttribute("rowCount", rowCount);
		request.setAttribute("totalPage", totalPage);
		return new ActionForward("/listsql2.jsp");
	}
}
