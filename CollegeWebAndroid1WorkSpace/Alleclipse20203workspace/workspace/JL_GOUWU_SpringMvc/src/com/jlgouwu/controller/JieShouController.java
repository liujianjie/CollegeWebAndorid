package com.jlgouwu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jlgouwu.pojo.JRuser;

@Controller
@RequestMapping("jieshou")
public class JieShouController {
	@RequestMapping("jieshou")
	private String jieshou(Model model,HttpServletRequest request){
		ServletContext sc=request.getServletContext();//applction
		
		// ��ȡ�û���Ϣ
		HttpSession session=request.getSession();
		JRuser jr=(JRuser)session.getAttribute("jruser");
		String uname=jr.getUname();
		
		String amessage=(String) sc.getAttribute("message");//��ȡ������application����Ϣ
		if(amessage == null){
			amessage = "";
		}
		sc.setAttribute("message", amessage+uname+"˵:"+request.getParameter("message")+"\r\n");
		
//		response.sendRedirect("qiantai_chart/khdchart.jsp");
		return "qiantai_chart/khdchart";
	}
	@RequestMapping("send")
	private String send(Model model,HttpServletRequest request){// �̼�˵��
		ServletContext sc=request.getServletContext();
		
		String uname="�̼�";
		
		String amessage=(String) sc.getAttribute("message");
		if(amessage == null){
			amessage = "";
		}
		sc.setAttribute("message", amessage+uname+"˵:"+request.getParameter("message")+"\r\n");
		
//		response.sendRedirect("qiantai_chart/fwdchart.jsp");
		return "qiantai_chart/fwdchart";
	}
	@RequestMapping("test")
	private String test(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException{// ���Է�������
		PrintWriter out = response.getWriter();
		
		ServletContext sc=request.getServletContext();
		
		//String uname=(String) request.getSession().getAttribute("aa");
		String uname="�̼�";

		String amessage=(String) sc.getAttribute("message");
		
		sc.setAttribute("message", amessage+uname+"˵:"+request.getParameter("message")+"\r\n");
		
//		response.sendRedirect("1.jsp");
		return "1";
	}
	@RequestMapping("khdbaocun")
	private String khdbaocun(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException{// ���Է�������
		String neirong=request.getParameter("neirong");
		
		request.setAttribute("neirong", neirong);
		
//		request.getRequestDispatcher("qiantai_chart/khdchart.jsp").forward(request, response);
		return "qiantai_chart/khdchart";
	}
	@RequestMapping("fwdbaocun")
	private String fwdbaocun(Model model,HttpServletRequest request, HttpServletResponse response) throws IOException{// ���Է�������
		String neirong=request.getParameter("neirong");
//		System.out.println(neirong);
		request.setAttribute("neirong", neirong);
		
//		request.getRequestDispatcher("qiantai_chart/fwdchart.jsp").forward(request, response);
		return "qiantai_chart/fwdchart";
	}

}
