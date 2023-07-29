package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import form.StuForm;
import serviceI.StuI;
import serviceImp.StuImp;
import vo.StudentVo;

public class StuAction extends DispatchAction{

	StuI ss=new StuImp();//未指定sessionfactory
	ApplicationContext context=new ClassPathXmlApplicationContext("config-resource/bean.xml");
	StuImp sss=(StuImp)context.getBean("stuservice");
	
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int pageCount=5;
		int currPage=1;
		int totalCount=ss.count();
		int totalPage=(totalCount+pageCount-1)/pageCount;
		System.out.println("共"+totalCount+"条数据,共"+totalPage+"页");
		
		String currpage=request.getParameter("currpage");
		if(currpage!=null&&!"".equals(currpage)){
			currPage=Integer.parseInt(currpage);
		}
		if(currPage<1){
			currPage=1;
		}
		if(currPage>totalPage){
			currPage=totalPage;
		}
		System.out.println(currPage);
		DetachedCriteria dc=DetachedCriteria.forClass(StudentVo.class);
		List list=sss.selstu(dc,(currPage-1)*pageCount, pageCount);
		//List list=ss.list("from StudentVo",(currPage-1)*pageCount, pageCount);
		System.out.println(list.size());
		request.setAttribute("list", list);
		request.setAttribute("currPage", currPage);
		request.setAttribute("totalCount", totalCount);
		request.setAttribute("totalPage", totalPage);
		return new ActionForward("/list.jsp");
	}
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		StuForm stu=(StuForm)form;
		String aihao[]=stu.getAihao();
		String str="";
		for(int i=0;i<aihao.length;i++){
			System.out.println(aihao[i]);
			str+=aihao[i]+" ";
		}
		//赋值
		StudentVo stuvo=new StudentVo();
		BeanUtils.copyProperties(stuvo, stu);
		
		stuvo.setStu_aihao(str);
		
		//ss.add(stuvo);
		sss.add2(stuvo);
		return new ActionForward("stu.do?method=list",true);
	}
	
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		StuForm stu=(StuForm)form;
		//查出
		StudentVo stuvo=(StudentVo)ss.seldan(stu.getStu_id());
//		System.out.println(stuvo.getStu_name());
		//删除
		//ss.delete(stuvo);
		sss.delete2(stuvo);
		return new ActionForward("stu.do?method=list",true);
	}
	public ActionForward toalert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("来修改了");
		//获取单行值返回去
		StuForm stu=(StuForm)form;
		StudentVo stuvo=(StudentVo)ss.seldan(stu.getStu_id());
		request.setAttribute("student", stuvo);
		return new ActionForward("/alert.jsp");
	}
	public ActionForward alert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		StuForm stu=(StuForm)form;
		//id获取到了
		String aihao[]=stu.getAihao();
		String str="";
		for(int i=0;i<aihao.length;i++){
			System.out.println(aihao[i]);
			str+=aihao[i]+" ";
		}
		//赋值
		StudentVo stuvo=new StudentVo();
		BeanUtils.copyProperties(stuvo, stu);
		
		stuvo.setStu_aihao(str);
		
		sss.alert(stuvo);
		//ss.alert2(stuvo);
		
		return new ActionForward("stu.do?method=list",true);
		
	}
}
