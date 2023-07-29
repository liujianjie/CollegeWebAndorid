package com.ht.action;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import com.ht.service.IPageService;
import com.ht.service.impl.PageServiceImpl;

public class PageAction extends DispatchAction {
	IPageService ip=new PageServiceImpl();
	public ActionForward list1(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int currPage = 1;// ��ǰҳ��
		int pageCount = 5;// ÿҳ����
		int totalRow = 0;// ������
		int totalPage = 0;// ��ҳ��

		String str_curr = request.getParameter("currPage");
		if (str_curr != null && !"".equals(str_curr)) {
			currPage = Integer.parseInt(str_curr);
		}
		
		//�������Ļ�ȡ����
		totalRow=ip.totalRow();
		
		//������ҳ��
		totalPage=(totalRow+pageCount-1)/pageCount;
		
		//�жϵ�ǰҳ�Ƿ�С��1
		if(currPage<1){
			currPage=1;
		}
		//�����ǰҳ������ҳ��
		if(currPage>totalPage){
			currPage=totalPage;
		}
		
		List list= ip.pagelist((currPage-1)*pageCount, pageCount);
		request.setAttribute("list", list);
		
		request.setAttribute("currPage", currPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("totalRow", totalRow);
		request.setAttribute("totalPage", totalPage);
		return new ActionForward("/listpage.jsp");
	}
	
	public ActionForward list2(ActionMapping mapping, ActionForm form,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		int currPage = 1;// ��ǰҳ��
		int pageCount = 5;// ÿҳ����
		int totalRow = 0;// ������
		int totalPage = 0;// ��ҳ��

		String str_curr = request.getParameter("currPage");
		if (str_curr != null && !"".equals(str_curr)) {
			currPage = Integer.parseInt(str_curr);
		}
		
		//�������Ļ�ȡ����
		totalRow=ip.totalRow();
		
		//������ҳ��
		totalPage=(totalRow+pageCount-1)/pageCount;
		
		//�жϵ�ǰҳ�Ƿ�С��1
		if(currPage<1){
			currPage=1;
		}
		//�����ǰҳ������ҳ��
		if(currPage>totalPage){
			currPage=totalPage;
		}
		
		List list= ip.pagelistbysql((currPage-1)*pageCount, pageCount);
//		for (Iterator it=list.iterator();it.hasNext();) {
//			Object[] obj=(Object[])it.next();
//			System.out.println(obj[0]+" "+obj[1]+" "+obj[2]);
//		}
		for (Iterator it=list.iterator();it.hasNext();) {
			Map map=(Map)it.next();// һ��map����һ������
			//�����ݿ�����Ϊ��      ����Ϊֵ
			System.out.println("Ա������   "+map.get("ENAME"));
			
		}
	
//		
		request.setAttribute("list", list);
		
		request.setAttribute("currPage", currPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("totalRow", totalRow);
		request.setAttribute("totalPage", totalPage);
		return new ActionForward("/listpagebysql.jsp");
	}
}
