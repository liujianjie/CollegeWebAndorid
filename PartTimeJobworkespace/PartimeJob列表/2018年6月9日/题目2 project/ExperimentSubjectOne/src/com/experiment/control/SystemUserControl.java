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

//只有一个分级
public class SystemUserControl extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	SystemUserServiceI userservice = new SystemUserServiceImp();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		this.doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");//通过一个参数来实现多个action
		if(method.equals("register")){
			//页面已经判断了，不需要判断空值问题
			SystemUserBean user = new SystemUserBean();
			user.setUserName(request.getParameter("username"));
			user.setUserPassword(request.getParameter("password"));
			boolean bln = userservice.userregister(user);//传入user对象，在service层get
			if(bln){
				request.setAttribute("systemuser", user);
				request.getRequestDispatcher("userlogin.jsp").forward(request, response);
			}else{
				request.getRequestDispatcher("registeruser.jsp").forward(request, response);
			}
			
		}else if(method.equals("login")){//登录
			SystemUserBean user = new SystemUserBean();
			user.setUserName(request.getParameter("username"));
			user.setUserPassword(request.getParameter("password"));
			int userId = userservice.checkuser(user);
			if(userId != 0){
				user = userservice.getOneSystemUser(userId);
				HttpSession session =  request.getSession();// 获取session
				session.setAttribute("systemusersession", user);//保存当前登录全局用户信息
				request.getRequestDispatcher("main.jsp").forward(request, response);
			}else{
				request.setAttribute("msg", "用户名或者密码错误");
				request.getRequestDispatcher("userlogin.jsp").forward(request, response);
			}
			
		}else if(method.equals("userlist")){//用户列表
			List<SystemUserBean> userlist = userservice.seluserlist();
			request.setAttribute("systemuserlist", userlist);
			request.getRequestDispatcher("userlist.jsp").forward(request, response);
			
		}else if(method.equals("toupdate")){//去修改，首先需要获取到值 ，靠会话跟踪技术的隐藏表单域 id
			String userid = request.getParameter("id");
			int id =  Integer.parseInt(userid);
			SystemUserBean systemuser = userservice.getOneSystemUser(id);
			request.setAttribute("systemuser", systemuser);
			request.getRequestDispatcher("toupdateuser.jsp").forward(request, response);
			
		}else if(method.equals("update")){//修改，
			SystemUserBean user = new SystemUserBean();
			user.setUserName(request.getParameter("username"));
			user.setUserPassword(request.getParameter("password"));
			String userid = request.getParameter("userId");
			int id =  Integer.parseInt(userid);
			user.setUserId(id);
			userservice.updatesystemuser(user);
			request.getRequestDispatcher("/systemuser?method=userlist").forward(request, response);//修改无论成不成功都给予回用户列表
			
		}else if(method.equals("delete")){//删除，id唯一标识
			String userid = request.getParameter("id");
			int id =  Integer.parseInt(userid);
			boolean bln = userservice.deletesystemuser(id);
			if(bln)
				request.getRequestDispatcher("/systemuser?method=userlist").forward(request, response);
			
		}
		
	}
}
