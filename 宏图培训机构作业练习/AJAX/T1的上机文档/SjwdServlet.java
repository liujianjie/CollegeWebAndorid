package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SjwdServlet extends HttpServlet{

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req,resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		System.out.println("������");
		resp.setContentType("text/html;charset=utf-8");
		PrintWriter write=resp.getWriter();
		String name=req.getParameter("name");
		name=new String(name.getBytes("iso-8859-1"),"utf-8");
		System.out.println(name);
		//������list�� list�ֱ�����session�� һһ�Ա���û���ظ�
		HttpSession session=req.getSession();
		Object obj=session.getAttribute("list");
		boolean bln=false;
		//��һ��
		if(obj==null){
			List list=new ArrayList();
			list.add(name);
			//��session����list��
			session.setAttribute("list", list);
		}else{//�ڶ���
			System.out.println("���� ��");
			List list=(List)obj;
			//��Ҫ�Ա���û����
			for(int i=0;i<list.size();i++){
				//System.out.println(list.get(i));
				if(name.equals(list.get(i)))
				{
					bln=true;
				}
				
			}
			//���û����ͬ�Ļ��ͱ���
			if(!bln){	
				list.add(name);
				session.setAttribute("list", list);
			}
		}
		System.out.println(bln);
		String str="";
		if(bln){//����
			str="��";
		}else{
			str="û��";
		}
		write.print(str);
		write.flush();
		write.close();
	}
	
}
