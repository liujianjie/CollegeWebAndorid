package com.goods.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Book;
//import com.bean.BookDB;

/**
 * Servlet implementation class ListBookServlet
 * չʾ������Ʒ�б�δʵ��
 */
public class ListBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
//		  //�õ�����ͼ��
//		  Collection<Book> books = BookDB.getAll();
//		  //����ҳ��
//		  PrintWriter out = response.getWriter();
//		  out.print("�����Ǳ���վ����������ͼ�飺"+"<br/><br/>");
//		  //�������ϣ���ͼ����Ե�ҳ��
//		  for(Book b:books) {
//		   //�õ�ͼ������
//		   String name = b.getName();
//		   int id = b.getId();
//		   //����ͼ�������
//		   String url="<a href='/charp1_easy/PurcharseServlet?id="+id+"'>�������</a>";
//		   out.print("ͼ�����ƣ�"+name+"		"+url+"<br/><br/>");
//		  }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
