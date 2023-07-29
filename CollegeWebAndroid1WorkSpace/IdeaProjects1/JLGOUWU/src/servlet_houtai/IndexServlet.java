package servlet_houtai;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

//import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.Goodsbean;
import bean.JRuserBean;
import bean.OrdersBean;
import service_goods.GoodsImp;
import service_goods.IGoods;
import service_userorders.IUserOrders;
import service_userorders.UserOrdersImp;

public class IndexServlet extends HttpServlet {
	
	IUserOrders ss=new UserOrdersImp();
	IGoods sss=new GoodsImp();

	SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// ʱ�䴦����
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		String method=request.getParameter("method");
		if(method.equals("add")){
			String phone=request.getParameter("phone");
			String uname=request.getParameter("uname");
			String pwd=request.getParameter("pwd1");
			String year=request.getParameter("year");
			String month=request.getParameter("month");
			String day=request.getParameter("day");
			String birthday=year+month+day;
			
			JRuserBean jr=new JRuserBean();
			jr.setPhone(phone);
			jr.setUname(uname);
			jr.setJr_img("jieruishu");
			jr.setPwd(pwd);
			jr.setMoneys(1000);
			jr.setBirthday(birthday);
//			jr.setJointime(new Date().toLocaleString());
			jr.setJointime(si.format(new Date()));
			
			boolean bln=ss.zhuce(jr);
			
			//��ת��ҳ�沢����
			if(bln){
				request.setAttribute("uname", uname);
				request.setAttribute("pwd", pwd);
				request.getRequestDispatcher("qiantai_admin/login.jsp").forward(request, response);
			}else{
				response.sendRedirect("zhongzhuang.jsp");
			}
			
		}else if(method.equals("checkuname")){
			String phone=request.getParameter("phone");
			String uname=request.getParameter("uname");
			String pwd=request.getParameter("pwd1");
			String year=request.getParameter("year");
			String month=request.getParameter("month");
			String day=request.getParameter("day");
			
			boolean bln=ss.cunzaiuname(uname);
			request.setAttribute("phone", phone);
			request.setAttribute("uname", uname);
			request.setAttribute("pwd", pwd);
			request.setAttribute("year", year);
			request.setAttribute("month", month);
			request.setAttribute("day", day);
			
			if(bln){
				//����ע��ҳ��
				request.setAttribute("cunzai", "���û����Ѵ���,����������");
				request.getRequestDispatcher("qiantai_admin/zhuce.jsp").forward(request, response);
			}else{// ȥ���
				request.getRequestDispatcher("index?method=add").forward(request, response);
			}
			
//			boolean shifou1=false;
//			boolean shifou2=false;
//			boolean shifou3=false;
//			boolean shifou4=false;
//			boolean shifou5=false;
//			boolean shifou6=false;
//			if(phone!=null&&!phone.equals("")){
//				shifou1=true;
//			}
//			if(uname!=null&&!uname.equals("")){
//				shifou2=true;
//			}
//			if(pwd!=null&&!pwd.equals("")){
//				shifou3=true;
//			}
//			if(year!=null&&!year.equals("")){
//				shifou4=true;
//			}
//			if(month!=null&&!month.equals("")){
//				shifou5=true;
//			}
//			if(day!=null&&!day.equals("")){
//				shifou6=true;
//			}
//			if(shifou1&&shifou2&&shifou3&&shifou4&&shifou5&&shifou6){
//				
//			}else{
//				request.getRequestDispatcher("qiantai_admin/zhuce.jsp").forward(request, response);
//			}
		}else if(method.equals("yanzheng")){
			String uname=request.getParameter("uname");
			String pwd=request.getParameter("pwd");
			
			boolean bln=ss.denglu(uname, pwd);
			
			if(bln){
				//����bean ȥ��ҳ��
				JRuserBean jr=ss.seljruser(uname);
				
				HttpSession session=request.getSession();
				session.setAttribute("jruser", jr);
				
				response.sendRedirect("qiantai_main/main.jsp");
			}else{
				//����
				request.setAttribute("msg", "��¼ʧ�ܣ��˺����벻��ȷ");
				request.getRequestDispatcher("qiantai_admin/login.jsp").forward(request, response);
			}
		}else if(method.equals("deljruser")){
			HttpSession session=request.getSession();
			
			session.removeAttribute("jruser");
			
			response.sendRedirect("qiantai_main/main.jsp");
		}else if(method.equals("saveorders")){ //�� �����������ڣ����������빺�ﳵռͬһ��������
			//���涩�� 
			HttpSession session=request.getSession();
			
			String gid=request.getParameter("gid");
			int id=0;
			if(gid!=null&&!gid.equals("")){
				id=Integer.parseInt(gid);
			}
			List goodslist=new ArrayList();
			if(gid==null||"".equals(gid)){//���ﳵ������
				//���ﳵ��Ϣ
				goodslist=(List)session.getAttribute("gwcgoods");
				
			}else{
				//���������
				Goodsbean goods=sss.selhang(id);
				goodslist.add(goods);
			}
			
			//�û�
			JRuserBean jr=(JRuserBean)session.getAttribute("jruser");

			String st="";//���������
			
			//ѭ������Ʒ��Ϣ ��һһ��Ӧ һ����ƷΪһ������
			boolean bln=false;
			for(int i=0;i<goodslist.size();i++){
				Goodsbean goods=(Goodsbean)goodslist.get(i);	
				
				//���� bean
				OrdersBean order=new OrdersBean();
				
				order.setJruser_id(jr.getJruser_id());
				
				Random r=new Random();
				order.setXfm((r.nextInt(900000)+100000)+"");
				
				order.setStatu(1);//״̬ 0�� δ֧�� 1��δʹ�� 2����ʹ��	
//				order.setGtime(new Date().toLocaleString());
				order.setGtime(si.format(new Date()));
				order.setG_id(goods.getG_id());
				order.setGname(goods.getG_name());
				order.setGdec(goods.getG_dec());
				order.setGprice(goods.getG_price());
				order.setGwccount(goods.getGwccount());//��ȡ���ﳵ�Ĵ�С
				order.setTotal(goods.getGwccount()*goods.getG_price());//�ܶ�
				int c=goods.getGwccount();
				float p=goods.getG_price();
				float o=c*p;
				order.setTotal(o);
				order.setGimg(goods.getG_img());
				bln=ss.addorders(order);//����µ�����
				
				//����������
				st+=order.getXfm()+" ";
				
				//������ ���ӵ�ԭ�ȵ�sale+���ﳵ������ ��
				ss.alertsale(goods.getG_id(),goods.getGwccount());//��Ʒid �� ��Ʒ����
			}
			//ɾ�����ﳵlist 
			session.removeAttribute("gwcgoods");
			session.setAttribute("chartcount", 0);
			if(bln){
				
				request.setAttribute("xfm",st);

				request.getRequestDispatcher("qiantai_sel/xfm.jsp").forward(request, response);
			}else{
				response.sendRedirect("zhongzhuang.jsp");
			}
		}else if(method.equals("saveoneorders")){//�������� ԭ�������� ��
			//ͨ�� ��Ʒid��ѯ��Ʒ��Ϣ������request
			String ID=request.getParameter("id");
			int id=Integer.parseInt(ID);
			
			//����Ƕ�����Ϣ�� ȥ����ҳ��
			Goodsbean goods=sss.selhang(id);
			
			//����list ��Ϊ�Ǳ���ѭ�� ������bean���ǵ��� ��û�з�װ
			List list=new ArrayList();
			list.add(goods);
			
			request.setAttribute("gwcgoods", list);
			
			//������Ʒid
			request.setAttribute("g_id", goods.getG_id());
			
			request.getRequestDispatcher("qiantai_sel/tjdd.jsp").forward(request, response);
		}else if(method.equals("selorders")){//�鿴���� ͬ���û��鿴 ������list
			//�û�
			HttpSession session=request.getSession();
			JRuserBean jr=(JRuserBean)session.getAttribute("jruser");
			
			//��ѯ���� ��ҳ 
			int pageCount=8;
			int currPage=1;
			int totalRow=ss.selcountorders(jr.getJruser_id());
			int totalPage=(totalRow+pageCount-1)/pageCount;
			
			//��goodsxq.jsp�в���Ȼ�󴫹�����ҳ������
			String currpage=request.getParameter("currp");
			if(currpage!=null&&!currpage.equals("")){
				currPage=Integer.parseInt(currpage);
			}
			
			//�жϵ�ǰҳ�������ҳ
			if(currPage>totalPage){
				currPage=totalPage;
			}
			
			//�жϵ�ǰҳС��1
			if(currPage<1){
				currPage=1;
			}
			
			List list=ss.selorders(pageCount,currPage,jr.getJruser_id());
			
			request.setAttribute("orderslist", list);
			request.setAttribute("jr", jr);
			//����ֵ
			request.setAttribute("currPage", currPage);
			request.setAttribute("totalRow", totalRow);
			request.setAttribute("totalPage",totalPage);
			
			request.getRequestDispatcher("qiantai_sel/SelOrders.jsp").forward(request, response);
		}else if(method.equals("xfyz")){//������֤
			String orderid=request.getParameter("orderid");
			
			int oid=Integer.parseInt(orderid);

			//���ĳ� ��ʹ�ø��ݶ������޸� statuΪ2
			ss.alertstatu(oid);
			
			request.setAttribute("statu", 2);
			
			request.getRequestDispatcher("houtai_caozuo/xfyz.jsp").forward(request, response);
			
		}else if(method.equals("goxfyz")){//ȥ����
			String xfm=request.getParameter("yzm");
			
			OrdersBean or=ss.xfyz(xfm);
			
			if(or!=null){
				
				request.setAttribute("statu", or.getStatu());
				request.setAttribute("orderid", or.getOrders_id());
				request.getRequestDispatcher("houtai_caozuo/xfyz.jsp").forward(request, response);
				
			}else{
				request.setAttribute("msg", "��֤ʧ��,����֤�벻����");
				request.getRequestDispatcher("houtai_caozuo/goxfyz.jsp").forward(request, response);
			}
			
		}else if(method.equals("shifouxiaofei")){
			String ID=request.getParameter("id");
			int id=Integer.parseInt(ID);
			
			//�û�
			HttpSession session=request.getSession();
			JRuserBean jr=(JRuserBean)session.getAttribute("jruser");
			
			boolean bln=ss.shifougm(jr.getJruser_id(), id);
			
			if(bln){//���
				System.out.println("���");
				request.getRequestDispatcher("goods?method=goodspingjia&gid="+id+"").forward(request, response);
			}else{
				request.setAttribute("meigoumai", "�Բ����㻹δ��������Ʒ");
				request.getRequestDispatcher("goods?method=goodsxq&gid="+id+"").forward(request, response);
			}
			
		}
	}

}
