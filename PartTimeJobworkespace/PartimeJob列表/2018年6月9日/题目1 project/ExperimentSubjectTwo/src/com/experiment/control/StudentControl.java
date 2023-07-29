package com.experiment.control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.experiment.bean.StudentBean;


public class StudentControl extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");//ͨ��һ��������ʵ�ֶ��action
		if(method.equals("login")){
			//ǰ̨��������username��password ����
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//����xml ���Ƿ�������û� �Լ� ����
			List<StudentBean> stulist = new ArrayList<StudentBean>();
			SAXBuilder sb = new SAXBuilder();// ����һ��SAXBuilder����  
			Document doc = null;
			try {
//				doc = sb.build("studentinfo.xml");//������У��޷����ʵ���Դ
				//studentinfo.xml�ᵽTomcat����λ���¡����ԣ�../../Ϊǰ׺��ʡȥ��ǰ��ǰ׺
				doc = sb.build(StudentControl.class.getClassLoader().getResourceAsStream("../../studentinfo.xml"));
			} catch (JDOMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        // �����ĵ�����  
			if(doc != null){
		        Element root = doc.getRootElement(); // ��ȡ��Ԫ��  
		        List list = root.getChildren("student");// ȡ����Ϊstudent������Ԫ��  
		        for (int i = 0; i < list.size(); i++) {  
		        	StudentBean student = new StudentBean();
		            Element element = (Element) list.get(i);  
		            student.setUsername(element.getChildText("username"));//��ȡusername���������õ�studentbean��
		            student.setPassword(element.getChildText("password"));
		            student.setStuno(element.getChildText("stuno"));
		            student.setStuname(element.getChildText("stuname"));
		            student.setSex(element.getChildText("sex"));
		            student.setIdcard(element.getChildText("idcard"));
		            stulist.add(student);
		        }  
			}
			boolean bln = false;//�����ж��ǻ�login���滹���½���
			StudentBean stu = new StudentBean();
			if(stulist.size() > 0){
				for(StudentBean stus:stulist){
					if(username.equals(stus.getUsername()) && password.equals(stus.getPassword())){
						stu = stus;//�����Ҫ����jspҳ��Ķ���
						bln = true;
						break;//����ѭ��
					}
				}
			}
			if(bln){
				request.setAttribute("studentbean", stu);
				request.getRequestDispatcher("studentmain.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "�û��������������");//����ظ� 
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}
	public List<StudentBean> saxBulidAnalysis(){
	
		return null;
	}
}
