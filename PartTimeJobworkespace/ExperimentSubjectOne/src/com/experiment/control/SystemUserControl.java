package com.experiment.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.experiment.bean.SystemUserBean;
import com.experiment.service.SystemUserServiceI;
import com.experiment.serviceimp.SystemUserServiceImp;

//ֻ��һ���ּ�
public class SystemUserControl extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SystemUserServiceI userservice = new SystemUserServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO �Զ����ɵķ������
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");//ͨ��һ��������ʵ�ֶ��action
		if(method.equals("register")){
			//ҳ���Ѿ��ж��ˣ�����Ҫ�жϿ�ֵ����
			SystemUserBean user = new SystemUserBean();
			user.setUserName(request.getParameter("username"));
			user.setUserPassword(request.getParameter("password"));
			boolean bln = userservice.userregister(user);//����user������service��get
			if(bln){
				request.setAttribute("systemuser", user);
				request.getRequestDispatcher("userlogin.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("registeruser.jsp").forward(request, response);
			}
			
		}else if(method.equals("login")){//��¼
			SystemUserBean user = new SystemUserBean();
			user.setUserName(request.getParameter("username"));
			user.setUserPassword(request.getParameter("password"));
			int userId = userservice.checkuser(user);
			if(userId != 0){
				user = userservice.getOneSystemUser(userId);
				HttpSession session =  request.getSession();// ��ȡsession
				session.setAttribute("systemusersession", user);//���浱ǰ��¼ȫ���û���Ϣ
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "�û��������������");
				request.getRequestDispatcher("userlogin.jsp").forward(request, response);
			}
			
		}else if(method.equals("userlist")){//�û��б�
			List<SystemUserBean> userlist = userservice.seluserlist();
			request.setAttribute("systemuserlist", userlist);
			request.getRequestDispatcher("userlist.jsp").forward(request, response);
			
		}else if(method.equals("toupdate")){//ȥ�޸ģ�������Ҫ��ȡ��ֵ �����Ự���ټ��������ر��� id
			String userid = request.getParameter("id");
			int id =  Integer.parseInt(userid);
			SystemUserBean systemuser = userservice.getOneSystemUser(id);
			request.setAttribute("systemuser", systemuser);
			request.getRequestDispatcher("toupdateuser.jsp").forward(request, response);
			
		}else if(method.equals("update")){//�޸ģ�
			SystemUserBean user = new SystemUserBean();
			user.setUserName(request.getParameter("username"));
			user.setUserPassword(request.getParameter("password"));
			String userid = request.getParameter("userId");
			int id =  Integer.parseInt(userid);
			user.setUserId(id);
			userservice.updatesystemuser(user);
			request.getRequestDispatcher("/systemuser?method=userlist").forward(request, response);//�޸����۳ɲ��ɹ���������û��б�
			
		}else if(method.equals("delete")){//ɾ����idΨһ��ʶ
			String userid = request.getParameter("id");
			int id =  Integer.parseInt(userid);
			boolean bln = userservice.deletesystemuser(id);
			if(bln)
				request.getRequestDispatcher("/systemuser?method=userlist").forward(request, response);
			
		}
		
	}
}
