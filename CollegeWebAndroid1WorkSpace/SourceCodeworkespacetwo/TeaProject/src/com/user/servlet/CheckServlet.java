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
 * ��֤��servlet��δ�õ�
 * 
 */
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// �õ�ͼƬ
		VerifyCode vc = new VerifyCode();
		BufferedImage image = vc.getImage();
		//��ȡ��֤�������ַ�
		String serverCode = vc.getText();
		request.getSession().setAttribute("code", serverCode);
		//�õ��ֽ�������
		OutputStream out = response.getOutputStream();
		//��ͼƬд�������
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
