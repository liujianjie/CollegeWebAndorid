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

	SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 时间处理器
	
	
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
			
			//跳转主页面并登入
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
				//返回注册页面
				request.setAttribute("cunzai", "该用户名已存在,请输入其它");
				request.getRequestDispatcher("qiantai_admin/zhuce.jsp").forward(request, response);
			}else{// 去添加
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
				//保存bean 去主页面
				JRuserBean jr=ss.seljruser(uname);
				
				HttpSession session=request.getSession();
				session.setAttribute("jruser", jr);
				
				response.sendRedirect("qiantai_main/main.jsp");
			}else{
				//返回
				request.setAttribute("msg", "登录失败！账号密码不正确");
				request.getRequestDispatcher("qiantai_admin/login.jsp").forward(request, response);
			}
		}else if(method.equals("deljruser")){
			HttpSession session=request.getSession();
			
			session.removeAttribute("jruser");
			
			response.sendRedirect("qiantai_main/main.jsp");
		}else if(method.equals("saveorders")){ //唉 有这个问题存在，立即购买与购物车占同一个方法，
			//保存订单 
			HttpSession session=request.getSession();
			
			String gid=request.getParameter("gid");
			int id=0;
			if(gid!=null&&!gid.equals("")){
				id=Integer.parseInt(gid);
			}
			List goodslist=new ArrayList();
			if(gid==null||"".equals(gid)){//购物车过来的
				//购物车信息
				goodslist=(List)session.getAttribute("gwcgoods");
				
			}else{
				//立即购买的
				Goodsbean goods=sss.selhang(id);
				goodslist.add(goods);
			}
			
			//用户
			JRuserBean jr=(JRuserBean)session.getAttribute("jruser");

			String st="";//多个消费码
			
			//循环出商品信息 来一一对应 一条商品为一条数据
			boolean bln=false;
			for(int i=0;i<goodslist.size();i++){
				Goodsbean goods=(Goodsbean)goodslist.get(i);	
				
				//订单 bean
				OrdersBean order=new OrdersBean();
				
				order.setJruser_id(jr.getJruser_id());
				
				Random r=new Random();
				order.setXfm((r.nextInt(900000)+100000)+"");
				
				order.setStatu(1);//状态 0是 未支付 1是未使用 2是已使用	
//				order.setGtime(new Date().toLocaleString());
				order.setGtime(si.format(new Date()));
				order.setG_id(goods.getG_id());
				order.setGname(goods.getG_name());
				order.setGdec(goods.getG_dec());
				order.setGprice(goods.getG_price());
				order.setGwccount(goods.getGwccount());//获取购物车的大小
				order.setTotal(goods.getGwccount()*goods.getG_price());//总额
				int c=goods.getGwccount();
				float p=goods.getG_price();
				float o=c*p;
				order.setTotal(o);
				order.setGimg(goods.getG_img());
				bln=ss.addorders(order);//添加下单数据
				
				//保存消费码
				st+=order.getXfm()+" ";
				
				//将销量 增加到原先的sale+购物车的数量 ；
				ss.alertsale(goods.getG_id(),goods.getGwccount());//商品id 和 物品数量
			}
			//删除购物车list 
			session.removeAttribute("gwcgoods");
			session.setAttribute("chartcount", 0);
			if(bln){
				
				request.setAttribute("xfm",st);

				request.getRequestDispatcher("qiantai_sel/xfm.jsp").forward(request, response);
			}else{
				response.sendRedirect("zhongzhuang.jsp");
			}
		}else if(method.equals("saveoneorders")){//立即抢购 原来是这里 草
			//通过 商品id查询商品信息保存在request
			String ID=request.getParameter("id");
			int id=Integer.parseInt(ID);
			
			//这个是订单信息吧 去订单页面
			Goodsbean goods=sss.selhang(id);
			
			//保存list 因为那边是循环 单个的bean类是单体 并没有封装
			List list=new ArrayList();
			list.add(goods);
			
			request.setAttribute("gwcgoods", list);
			
			//保存商品id
			request.setAttribute("g_id", goods.getG_id());
			
			request.getRequestDispatcher("qiantai_sel/tjdd.jsp").forward(request, response);
		}else if(method.equals("selorders")){//查看订单 同过用户查看 保存在list
			//用户
			HttpSession session=request.getSession();
			JRuserBean jr=(JRuserBean)session.getAttribute("jruser");
			
			//查询订单 分页 
			int pageCount=8;
			int currPage=1;
			int totalRow=ss.selcountorders(jr.getJruser_id());
			int totalPage=(totalRow+pageCount-1)/pageCount;
			
			//从goodsxq.jsp中操作然后传过来的页数处理
			String currpage=request.getParameter("currp");
			if(currpage!=null&&!currpage.equals("")){
				currPage=Integer.parseInt(currpage);
			}
			
			//判断当前页大于最大页
			if(currPage>totalPage){
				currPage=totalPage;
			}
			
			//判断当前页小于1
			if(currPage<1){
				currPage=1;
			}
			
			List list=ss.selorders(pageCount,currPage,jr.getJruser_id());
			
			request.setAttribute("orderslist", list);
			request.setAttribute("jr", jr);
			//保存值
			request.setAttribute("currPage", currPage);
			request.setAttribute("totalRow", totalRow);
			request.setAttribute("totalPage",totalPage);
			
			request.getRequestDispatcher("qiantai_sel/SelOrders.jsp").forward(request, response);
		}else if(method.equals("xfyz")){//消费验证
			String orderid=request.getParameter("orderid");
			
			int oid=Integer.parseInt(orderid);

			//并改成 已使用根据订单号修改 statu为2
			ss.alertstatu(oid);
			
			request.setAttribute("statu", 2);
			
			request.getRequestDispatcher("houtai_caozuo/xfyz.jsp").forward(request, response);
			
		}else if(method.equals("goxfyz")){//去消费
			String xfm=request.getParameter("yzm");
			
			OrdersBean or=ss.xfyz(xfm);
			
			if(or!=null){
				
				request.setAttribute("statu", or.getStatu());
				request.setAttribute("orderid", or.getOrders_id());
				request.getRequestDispatcher("houtai_caozuo/xfyz.jsp").forward(request, response);
				
			}else{
				request.setAttribute("msg", "验证失败,此验证码不存在");
				request.getRequestDispatcher("houtai_caozuo/goxfyz.jsp").forward(request, response);
			}
			
		}else if(method.equals("shifouxiaofei")){
			String ID=request.getParameter("id");
			int id=Integer.parseInt(ID);
			
			//用户
			HttpSession session=request.getSession();
			JRuserBean jr=(JRuserBean)session.getAttribute("jruser");
			
			boolean bln=ss.shifougm(jr.getJruser_id(), id);
			
			if(bln){//买过
				System.out.println("买过");
				request.getRequestDispatcher("goods?method=goodspingjia&gid="+id+"").forward(request, response);
			}else{
				request.setAttribute("meigoumai", "对不起！你还未买过这个商品");
				request.getRequestDispatcher("goods?method=goodsxq&gid="+id+"").forward(request, response);
			}
			
		}
	}

}
