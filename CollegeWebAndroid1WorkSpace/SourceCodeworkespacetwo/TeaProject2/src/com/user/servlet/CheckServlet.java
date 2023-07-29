package com.user.servlet;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class CheckServlet
 * 验证码servlet，未用到
 * 
 */
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 得到图片
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage();
		//获取验证码的随机字符
		String serverCode = vc.getText();
		request.getSession().setAttribute("code", serverCode);
		//得到字节输入流
		OutputStream out = response.getOutputStream();
		//吧图片写到浏览器
		VerifyCode.output(image,out);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
