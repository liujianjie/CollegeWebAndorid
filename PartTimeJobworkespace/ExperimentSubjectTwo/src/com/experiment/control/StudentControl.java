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
		// TODO 自动生成的方法存根
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");//通过一个参数来实现多个action
		if(method.equals("login")){
			//前台传过来的username和password 以来
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			//解析xml 中是否有这个用户 以及 密码
			List<StudentBean> stulist = new ArrayList<StudentBean>();
			SAXBuilder sb = new SAXBuilder();// 创建一个SAXBuilder对象  
			Document doc = null;
			try {
//				doc = sb.build("studentinfo.xml");//这个不行，无法访问到资源
				//studentinfo.xml会到Tomcat发布位置下。所以，../../为前缀，省去这前的前缀
				doc = sb.build(StudentControl.class.getClassLoader().getResourceAsStream("../../studentinfo.xml"));
			} catch (JDOMException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        // 构造文档对象  
			if(doc != null){
		        Element root = doc.getRootElement(); // 获取根元素  
		        List list = root.getChildren("student");// 取名字为student的所有元素  
		        for (int i = 0; i < list.size(); i++) {  
		        	StudentBean student = new StudentBean();
		            Element element = (Element) list.get(i);  
		            student.setUsername(element.getChildText("username"));//获取username的内容设置到studentbean中
		            student.setPassword(element.getChildText("password"));
		            student.setStuno(element.getChildText("stuno"));
		            student.setStuname(element.getChildText("stuname"));
		            student.setSex(element.getChildText("sex"));
		            student.setIdcard(element.getChildText("idcard"));
		            stulist.add(student);
		        }  
			}
			boolean bln = false;//用来判断是回login界面还是新界面
			StudentBean stu = new StudentBean();
			if(stulist.size() > 0){
				for(StudentBean stus:stulist){
					if(username.equals(stus.getUsername()) && password.equals(stus.getPassword())){
						stu = stus;//赋予给要传给jsp页面的对象
						bln = true;
						break;//跳出循环
					}
				}
			}
			if(bln){
				request.setAttribute("studentbean", stu);
				request.getRequestDispatcher("studentmain.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "用户名或者密码错误");//给予回复 
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
	}
	public List<StudentBean> saxBulidAnalysis(){
	
		return null;
	}
}
