package action;

import java.awt.BufferCapabilities;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.actions.DispatchAction;

import form.Stuform;
import serviceI.StudentServiceI;
import serviceImp.StudentServiceImp;
import vo.JingliVo;
import vo.StudentVo;

public class StuAction extends DispatchAction{

	StudentServiceI ss=new StudentServiceImp();
	
	public ActionForward list(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int currPage=1;
		int pageCount=3;
		int totalRow=ss.Row();
		int totalPage=(totalRow+pageCount-1)/pageCount;
		System.out.println("����"+totalRow+"�����ݣ���"+totalPage+"ҳ");
		
		String currpage=request.getParameter("currpage");
		if(currpage!=null&&!currpage.equals("")){
			currPage=Integer.parseInt(currpage);
		}
		
		if(currPage<1){
			currPage=1;
		}
		
		if(currPage>totalPage){
			currPage=totalPage;
			
		}
		
		//��һ������ ÿһҳ�ĵ�һ������ �ڶ������� һҳ��ʾ��������
		List list=ss.fenye((currPage-1)*pageCount,pageCount);
		System.out.println(list.size());
		request.setAttribute("list", list);
		request.setAttribute("currPage", currPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("totalRow", totalRow);
		request.setAttribute("totalPage", totalPage);
		
		return new ActionForward("/list.jsp");
	}
	public ActionForward add(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
//		StudentVo stu=new StudentVo();
//		stu.setStu_name("С��");
//		stu.setStu_sex("��");
//		stu.setStu_age(18);
//		stu.setStu_desc("�Һ�˧��");
//		
//		JingliVo jl=new JingliVo();
//		jl.setJl_starttime("9��-12-2003");
//		jl.setJl_endtime("7��-1-2008");
//		jl.setJl_school("̨ǰ����԰");
//		
//		//����
//		stu.getJinglivo().add(jl);
//		jl.setStudentvo(stu);
		
		Stuform stu=(Stuform)form;
		StudentVo student=new StudentVo();
		BeanUtils.copyProperties(student,stu);
		
		String jl_starttime[]=stu.getJl_starttime();
		String jl_endtime[]=stu.getJl_endtime();
		String jl_school[]=stu.getJl_school();
		
		for(int i=0;i<jl_endtime.length;i++){
			JingliVo jl=new JingliVo();
			jl.setJl_starttime(jl_starttime[i]);
			jl.setJl_endtime(jl_endtime[i]);
			jl.setJl_school(jl_school[i]);
			
			//����
			student.getJinglivo().add(jl);
			jl.setStudentvo(student);
		}
		
		boolean bln=ss.addstu(student);
		System.out.println(bln);
		return new ActionForward("/stu.do?method=list",true);
	}
	public ActionForward toalert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Stuform stu=(Stuform)form;

		StudentVo student=ss.toalert(stu.getStu_id());

		request.setAttribute("student", student);
		
		return new ActionForward("/alert.jsp");
	}
	public ActionForward alert(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Stuform stu=(Stuform)form;
		StudentVo student=new StudentVo();
		BeanUtils.copyProperties(student,stu);
		
		String jl_starttime[]=stu.getJl_starttime();
		String jl_endtime[]=stu.getJl_endtime();
		String jl_school[]=stu.getJl_school();
		Integer jl_jid[]=stu.getJl_jid();
		for(int i=0;i<jl_endtime.length;i++){
			JingliVo jl=new JingliVo();
			jl.setJl_starttime(jl_starttime[i]);
			jl.setJl_endtime(jl_endtime[i]);
			jl.setJl_school(jl_school[i]);
			jl.setJl_jid(jl_jid[i]);
			//����
			student.getJinglivo().add(jl);
			jl.setStudentvo(student);
		}
		
		boolean bln=ss.alert(student);
		System.out.println(bln);
		return new ActionForward("/stu.do?method=list",true);
	}
	public ActionForward delete(ActionMapping mapping, ActionForm form, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Stuform stu=(Stuform)form;

		StudentVo student=ss.toalert(stu.getStu_id());
		
		boolean bln=ss.deletestu(student);
		System.out.println(bln);
		return new ActionForward("/stu.do?method=list",true);
	}
}
