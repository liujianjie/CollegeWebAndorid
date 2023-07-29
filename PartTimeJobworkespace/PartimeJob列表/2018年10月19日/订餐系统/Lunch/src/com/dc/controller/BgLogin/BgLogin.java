	package com.dc.controller.BgLogin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.dc.dao.BgLogin.UserDAO;
import com.dc.dao.BgLogin.UserDAOImpl;
import com.dc.entity.Message;
import com.dc.util.StringUtil;



public class BgLogin extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			String username=request.getParameter("username");
			String pwd=request.getParameter("pwd");
			UserDAO user=new UserDAOImpl();
			PrintWriter out=response.getWriter();
			Map map=user.login(username, pwd);
			//判断该用户是否数据库存在
			if(map!=null&&!map.isEmpty()){
				HttpSession sess=request.getSession();
				sess.setAttribute("userinfo", map);
				String accountid=map.get("emp_account_id").toString();
				//将该用户功能遍历，放入会话中，实现动态
				List<HashMap> list=user.findAllFunctionByUserId(accountid);
				sess.setAttribute("functionlist", list);
				Message mge=new Message();
				mge.setState(true);
				mge.setMessage("/module/BgLogin/Bgindex.jsp");
				out.print(StringUtil.transObjectToJson(mge));
				//request.getRequestDispatcher("/module/BgLogin/Bgindex.jsp").forward(request, response);
			}else{
				Message mge=new Message();
				mge.setState(false);
				mge.setMessage("用户名或密码错误");
				out.print(StringUtil.transObjectToJson(mge));
				//response.sendRedirect("/Lunch/module/BgLogin/BgLogin.jsp");
			}
	}

}
