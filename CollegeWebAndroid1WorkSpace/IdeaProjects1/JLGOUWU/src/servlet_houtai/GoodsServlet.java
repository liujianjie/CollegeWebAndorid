
package servlet_houtai;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
//import com.sun.org.apache.bcel.internal.generic.AALOAD;

import bean.BottomBean;
import bean.CommentBean;
import bean.Goodsbean;
import bean.JRuserBean;
import bean.MoldBean;
import service_bottom.BottomImp;
import service_bottom.Ibottom;
import service_goods.GoodsImp;
import service_goods.IGoods;
import service_mold.Imold;
import service_mold.MoldImp;
import service_userorders.IUserOrders;
import service_userorders.UserOrdersImp;

public class GoodsServlet extends HttpServlet{
	
	IGoods ss=new GoodsImp();
	Ibottom sss=new BottomImp();
	IUserOrders iu=new UserOrdersImp();
	Imold imolds = new MoldImp();

	SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 时间处理器
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String method=request.getParameter("method");
		if(method.equals("list")){
			//查询商品 分页 
			int pageCount=10;
			int currPage=1;
			int totalRow=ss.selgoodscount();
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
			
			List list=ss.selhtGoods(pageCount, currPage);
			
			request.setAttribute("list", list);
			//保存值
			request.setAttribute("currPage", currPage);
			request.setAttribute("totalRow", totalRow);
			request.setAttribute("totalPage",totalPage);
			
			request.getRequestDispatcher("houtai_goods/Goodslist.jsp").forward(request, response);
		}else if(method.equals("toadd")){
			List list=ss.selBottom();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("houtai_goods/Goodsadd.jsp").forward(request, response);
		}else if(method.equals("add")){
			
			//声明一个文件上传类
			SmartUpload su=new SmartUpload();
			
			//初始化
			su.initialize(getServletConfig(),request,response);
			
			//上传所有提交过来的文件
			try {
				su.upload();
				
				//设置文件保存目录
				su.save("/file");
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String g_name=su.getRequest().getParameter("uname");
			String g_dress=su.getRequest().getParameter("dress");
			String g_dec=su.getRequest().getParameter("dec");
			//获取文件名称
			String g_img=su.getFiles().getFile(0).getFileName();
			String g_price=su.getRequest().getParameter("price");
			String g_scj=su.getRequest().getParameter("scj");
			String bottom=su.getRequest().getParameter("bottom");
			String g_descrip=su.getRequest().getParameter("descrip");
			
			Goodsbean god=new Goodsbean();
			god.setG_name(g_name);
			god.setG_dress(g_dress);
			god.setG_dec(g_dec);
			god.setG_img(g_img);
			god.setG_price(Float.parseFloat(g_price));
			god.setG_scj(Float.parseFloat(g_scj));
			god.setG_count(1000);//库存 默认设置1000
			god.setG_sale(0);//已售
			god.setG_statu(0);//0为未上架 1为已上架
			god.setG_descrip(g_descrip);
			god.setBottom_id(Integer.parseInt(bottom));
			
			boolean bln=ss.addGoods(god);
			//System.out.println(bln);
			request.getRequestDispatcher("goods?method=list").forward(request, response);
		}else if(method.equals("del")){
			String ID=request.getParameter("id");
			int id=Integer.parseInt(ID);
			
			boolean bln=ss.delGoods(id);
			
			request.getRequestDispatcher("/goods?method=list").forward(request, response);
		}else if(method.equals("goalert")){//去修改
			String ID=request.getParameter("id");
			int id=Integer.parseInt(ID);
			
			Goodsbean gods=ss.selhang(id);
			
			//保存
			request.setAttribute("goods", gods);
			
			List list=ss.selBottom();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("houtai_goods/alertGoods.jsp").forward(request, response);
			
		}else if(method.equals("alertnoimg")){//修改没有图片
			String g_name=request.getParameter("uname");
			String g_dress=request.getParameter("dress");
			String g_dec=request.getParameter("dec");
			String g_img=request.getParameter("photo");
			String g_price=request.getParameter("price");
			String g_scj=request.getParameter("scj");
			String bottom=request.getParameter("bottom");
			String g_descrip=request.getParameter("descrip");
			
			String ID=request.getParameter("id");
			int id=Integer.parseInt(ID);
			
			Goodsbean god=new Goodsbean();
			god.setG_id(id);
			god.setG_name(g_name);
			god.setG_dress(g_dress);
			god.setG_dec(g_dec);
			god.setG_img(g_img);
			god.setG_price(Float.parseFloat(g_price));
			god.setG_scj(Float.parseFloat(g_scj));
			god.setG_count(1);
			god.setG_sale(0);
			god.setG_statu(0);//0为未上架 1为已上架
			god.setG_descrip(g_descrip);
			god.setBottom_id(Integer.parseInt(bottom));

			boolean bln=ss.alerthang(god);
			
			//保存信息
			request.setAttribute("goods",god );//与goalert的 名称一样
			
			List list=ss.selBottom();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("goods?method=list").forward(request, response);
			
		}else if(method.equals("alertwithimg")){//修改

			//声明一个文件上传类
			SmartUpload su=new SmartUpload();
			
			//初始化
			su.initialize(getServletConfig(),request,response);
			
			//上传所有提交过来的文件
			try {
				su.upload();
				
				//设置文件保存目录
				su.save("/file");
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String g_name=su.getRequest().getParameter("uname");
			String g_dress=su.getRequest().getParameter("dress");
			String g_dec=su.getRequest().getParameter("dec");
			String g_img=su.getFiles().getFile(0).getFileName();
			String g_price=su.getRequest().getParameter("price");
			String g_scj=su.getRequest().getParameter("scj");
			String bottom=su.getRequest().getParameter("bottom");
			String g_descrip=su.getRequest().getParameter("descrip");
			
			String ID=su.getRequest().getParameter("id");
			int id=Integer.parseInt(ID);
			
			Goodsbean god=new Goodsbean();
			god.setG_id(id);
			god.setG_name(g_name);
			god.setG_dress(g_dress);
			god.setG_dec(g_dec);
			god.setG_img(g_img);
			god.setG_price(Float.parseFloat(g_price));
			god.setG_scj(Float.parseFloat(g_scj));
			god.setG_count(1);
			god.setG_sale(0);
			god.setG_statu(0);//0为未上架 1为已上架
			god.setG_descrip(g_descrip);
			god.setBottom_id(Integer.parseInt(bottom));

			boolean bln=ss.alerthang(god);
			
			//保存信息
			request.setAttribute("goods",god );//与goalert的 名称一样
			
			List list=ss.selBottom();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("goods?method=list").forward(request, response);
			
		}else if(method.equals("qtlist")){//前台点击类型出现的第一个分类的商品 这里有2个查询 1个分类 1个类型
			// 热门分类每个大分类取一项就可以
			// 1. 去一级分类表
			List<MoldBean> moldlist = imolds.selmold();
			// 2. 取二级分类表的第一个
			List<BottomBean> remenlist = new ArrayList<>();
			for(MoldBean mold: moldlist){
				BottomBean bt = sss.seloneBottomByMoldId(mold.getMold_id());
				if(null != bt.getBottom()){
					remenlist.add(bt);
				}
			}
			request.setAttribute("remenlist", remenlist);
			int pageCount=2;//控制数量为3
			
			//类型
			String MOLD_ID=request.getParameter("moldid");
			int moldid=Integer.parseInt(MOLD_ID);
			
			//查询类型的所有分类
			List bottomlist=sss.selfenlei(moldid);//查询好了类型的分类
			
			//查询这个类型的第一个分类
			int bottomid=sss.selonnbottom_id(moldid);//没有的默认返回为1要处理这个问题
			/*
			 * 
			 * */
			
			//查询第一个分类的所有商品
			List list=ss.selthreeGoods(bottomid,pageCount);

			request.setAttribute("goodslist", list);//这是商品信息
			request.setAttribute("goodssize", list.size());
			
			request.setAttribute("list", bottomlist);//这是这个类型的所有分类
			request.setAttribute("moldid", moldid);//这个是类型
			request.setAttribute("bottomid", bottomid);//这个是分类
			
			request.getRequestDispatcher("qiantai_main/right.jsp").forward(request, response);
			
		}else if(method.equals("threeqtlist")){//前台物品列表 这里有2个查询 1个分类 1个类型 这个不过要限制个数 为3个
			// 热门分类每个大分类取一项就可以
			// 1. 去一级分类表
			List<MoldBean> moldlist = imolds.selmold();
			// 2. 取二级分类表的第一个
			List<BottomBean> remenlist = new ArrayList<>();
			for(MoldBean mold: moldlist){
				BottomBean bt = sss.seloneBottomByMoldId(mold.getMold_id());
				if(null != bt.getBottom()){
					remenlist.add(bt);
				}
			}
			request.setAttribute("remenlist", remenlist);
			int pageCount=2;//控制数量为2
			
			String ID=request.getParameter("id");//分类bottom_id
			int id=Integer.parseInt(ID);
			
			List list=ss.selthreeGoods(id,pageCount);

			request.setAttribute("goodslist", list);//这是商品信息
			
			request.setAttribute("goodssize", list.size());//这是商品大小 如果小于0则不出现更多
			//查询这个类型的所有分类
			String MOLD_ID=request.getParameter("moldid");
			int moldid=Integer.parseInt(MOLD_ID);
			
			List bottomlist=sss.selfenlei(moldid);//查询好了类型的分类
			
			request.setAttribute("list", bottomlist);
			request.setAttribute("moldid", moldid);//保存这两个来查更多
			request.setAttribute("bottomid", id);//就是传过来的id
			
			request.getRequestDispatcher("qiantai_main/right.jsp").forward(request, response);
			
		}else if(method.equals("selmore")){
			//获取moldid 和bottomid
			String moldid=request.getParameter("mdid");
			String bottomid=request.getParameter("bottomid");
			
			int bid=Integer.parseInt(bottomid);
			//分类名
			String bottom=sss.selbottomname(bid);
			
			//查询商品 分页 
			int pageCount=8;
			int currPage=1;
			int totalRow=ss.selbottomgoodscount(Integer.parseInt(bottomid));
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
			
			//通过bottomid来查询商品
			List list=ss.sellistgoods(pageCount, currPage, Integer.parseInt(bottomid));

			//通过moldid来查询这个类型的所有分类
			List bottomlist=sss.selfenlei(Integer.parseInt(moldid));//查询好了类型的分类
			
			//保存商品
			request.setAttribute("goodslist", list);
			request.setAttribute("size", list.size());//为了让没有商品的图片不会显示
			
			//保存分类
			request.setAttribute("list", bottomlist);//分类集合
			
			//保存类型名称分类名称
			BottomBean bot=(BottomBean)bottomlist.get(0);

			request.setAttribute("bottom", bottom);//分类名
			request.setAttribute("mold", bot.getMold());//类型名
			
			request.setAttribute("moldid", moldid);//moldid
			request.setAttribute("bottomid",bottomid);//bottomid
			//保存值
			request.setAttribute("currPage", currPage);
			request.setAttribute("totalRow", totalRow);
			request.setAttribute("totalPage",totalPage);
			
			request.getRequestDispatcher("qiantai_Goods/GoodsList.jsp").forward(request, response);
			
		}else if(method.equals("selxsgoods")){//查询相近物品
			//查询更多商品 用list保存
			String uname=request.getParameter("uname");
			
			List goodslist=ss.selxsgoods(uname);
			
			request.setAttribute("goodslist", goodslist);//保存查询的物品信息
			
			request.setAttribute("listsize", goodslist.size());//保存大小

			if(goodslist.size()==0){//找不到
				
				response.sendRedirect("qiantai_Goods/noxiangsigoods.jsp");
			}else{
			
			//通过list中第一个g_id的botttom_id 来查询moldid
			Goodsbean gods=(Goodsbean)goodslist.get(0);
			BottomBean bot=ss.selbottom(gods.getBottom_id());
			
			//再通过moldid来查询有几个分类 bottom
			List list=sss.selfenlei(bot.getMold_id());
			request.setAttribute("list", list);//保存分类信息

			//查询类型
			String mold=sss.selMold(bot.getMold_id());
			
			request.setAttribute("bottom", bot.getBottom());
			request.setAttribute("mold", mold);
			
			request.setAttribute("moldid", bot.getMold_id());//moldid
			
			request.getRequestDispatcher("qiantai_Goods/GoodsList.jsp").forward(request, response);
			}
		}else if(method.equals("goodsxq")){//物品详情
			String ID=request.getParameter("id");
			int id=Integer.parseInt(ID);
			
			Goodsbean goods=ss.selhang(id);
			
			request.setAttribute("goods", goods);
			
			//属于的分类
			BottomBean bottom=ss.selbottom(goods.getBottom_id());
			request.setAttribute("bottom", bottom);
			
			//属于的类型
			MoldBean mold=ss.selmold(bottom.getMold_id());

			request.setAttribute("mold", mold);
			
			//查询评论通过 g_id来查 
			int pageCount=3;
			int currPage=1;
			int totalRow=iu.selcommentcount(id);
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
			
			List commentlist=iu.selcomment(pageCount, currPage,id);
			
			//保存
			request.setAttribute("commentlist", commentlist);
			request.setAttribute("commentlistsize", commentlist.size());
			//保存值
			request.setAttribute("currPage", currPage);
			request.setAttribute("totalRow", totalRow);
			request.setAttribute("totalPage",totalPage);
			
			//查询commentlist中uname和头像通过jruser_id 一个一个对应
			
			request.getRequestDispatcher("qiantai_sel/GoodsXQ.jsp").forward(request, response);
		}else if(method.equals("gouwuche")){//购物车清单
			String ID=request.getParameter("id");
			int id=Integer.parseInt(ID);
			
			Goodsbean goods=ss.selhang(id);
			
			HttpSession session=request.getSession();
			
			boolean bln=true;
			
			Object obj=session.getAttribute("gwcgoods");
			if(obj==null){
				List list=new ArrayList();
				list.add(goods);
				session.setAttribute("gwcgoods", list);
				session.setAttribute("chartcount", list.size());
			}else{
				//第二个以及以后的用户
				List li=(List)obj;
				for(int i=0;i<li.size();i++){
					Goodsbean gods=(Goodsbean)li.get(i);
					if(gods.getG_id()==goods.getG_id()){
						gods.setGwccount(gods.getGwccount()+1);
						bln=false;
						break;
					}
				}
				if(bln){
					li.add(goods);
				}
				session.setAttribute("chartcount", li.size());
			}
			
			response.sendRedirect("qiantai_sel/GoodsGouWuChe.jsp");
			
		}else if(method.equals("delgwcgoods")){//删除购物车物品
			HttpSession session=request.getSession();
			
			String ID=request.getParameter("id");
			int id=Integer.parseInt(ID);
			
			List list=(List)session.getAttribute("gwcgoods");
			
			for(int i=0;i<list.size();i++){
				Goodsbean gods=(Goodsbean)list.get(i);
				if(gods.getG_id()==id){
					list.remove(i);
				}
			}
			session.setAttribute("chartcount", list.size());
			response.sendRedirect("qiantai_sel/GoodsGouWuChe.jsp");
		}else if(method.equals("selstartshouyegoods")){//查询一开始的首页 商品
			// 热门分类每个大分类取一项就可以
			// 1. 去一级分类表
			List<MoldBean> moldlist = imolds.selmold();
			// 2. 取二级分类表的第一个
			List<BottomBean> remenlist = new ArrayList<>();
			for(MoldBean mold: moldlist){
				BottomBean bt = sss.seloneBottomByMoldId(mold.getMold_id());
				if(null != bt.getBottom()){
					remenlist.add(bt);
				}
			}
			
			//通过销量的多少对比来后去商品 分页。。。
			int pageCount=2;
			int currPage=1;
			int totalRow=ss.selgoodscount();
			int totalPage=6;//控制为6页
			
			//从right.jsp中操作然后传过来的页数处理
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
			
			List goodslist=ss.selfyGoods(pageCount, currPage);
			
			//保存值
			request.setAttribute("remenlist", remenlist);
			request.setAttribute("goodslist", goodslist);
			request.setAttribute("currPage", currPage);
			request.setAttribute("totalRow", totalRow);
			request.setAttribute("totalPage",totalPage);
			
			request.getRequestDispatcher("qiantai_main/right.jsp").forward(request, response);
		}else if(method.equals("goodspingjia")){//商品评价
			String pl=request.getParameter("comment");
			
			//保存评论
			HttpSession session=request.getSession();
			//先是 jruser_id
			JRuserBean jr=(JRuserBean)session.getAttribute("jruser");
			
			//再是g_iD
			String G_id=request.getParameter("gid");
			int g_id=Integer.parseInt(G_id);
			
			CommentBean co=new CommentBean();
			co.setJruser_id(jr.getJruser_id());
			co.setG_id(g_id);
			co.setC_comment(pl);
//			co.setC_time( new Date().toLocaleString());
			co.setC_time(si.format(new Date()));
			boolean bln=iu.addcomment(co);
			System.out.println(bln);
			//评论完
			if(bln){
				//去查询商品详细的servlet
				response.sendRedirect("goods?method=goodsxq&id="+g_id+"");
				
			}else{
				response.sendRedirect("zhongzhuang.jsp");
			}
			
		}else if(method.equals("dange")){
			//找5个分类为1的美食的商品
			List meishi=new ArrayList();
			
			// 1.先把分类为1的子分类
			List<BottomBean> bootomlist = sss.selfenlei(1);
			for(int i = 0; i < bootomlist.size(); i++){
				if(meishi.size() < 8){
					// 2. 再从子分类找出物品
					BottomBean gb = bootomlist.get(i);
					if(gb.getBottom() != null){
						meishi.add(ss.seldangegoods(gb.getBottom_id()));
					}
				}else{
					break;
				}
			}
			
			//找4个分类为5的休闲娱乐的商品
			List xiuxianyule=new ArrayList();
			
			bootomlist = sss.selfenlei(5);
			for(int i = 0; i < bootomlist.size(); i++){
				if(xiuxianyule.size() < 4){
					// 2. 再从子分类找出物品
					BottomBean gb = bootomlist.get(i);
					if(gb.getBottom() != null){
						xiuxianyule.add(ss.seldangegoods(gb.getBottom_id()));
					}
				}else{
					break;
				}
			}
			

//			//找5个分类为3的生活服务的商品
			List shfw=new ArrayList();
			
			bootomlist = sss.selfenlei(7);
			for(int i = 0; i < bootomlist.size(); i++){
				if(shfw.size() < 4){
					// 2. 再从子分类找出物品
					BottomBean gb = bootomlist.get(i);
					if(gb.getBottom() != null){
						shfw.add(ss.seldangegoods(gb.getBottom_id()));
					}
				}else{
					break;
				}
			}
			
//			//找5个分类为4的购物的商品
			List gowuu=new ArrayList();
			
			bootomlist = sss.selfenlei(8);
			for(int i = 0; i < bootomlist.size(); i++){
				if(gowuu.size() < 4){
					// 2. 再从子分类找出物品
					BottomBean gb = bootomlist.get(i);
					if(gb.getBottom() != null){
						gowuu.add(ss.seldangegoods(gb.getBottom_id()));
					}
				}else{
					break;
				}
			}
			
			//找4个分类为5的丽人的商品
			List liren=new ArrayList();
			
			bootomlist = sss.selfenlei(9);
			for(int i = 0; i < bootomlist.size(); i++){
				if(liren.size() < 4){
					// 2. 再从子分类找出物品
					BottomBean gb = bootomlist.get(i);
					if(gb.getBottom() != null){
						liren.add(ss.seldangegoods(gb.getBottom_id()));
					}
				}else{
					break;
				}
			}
			
			request.setAttribute("meishigoods", meishi);
			request.setAttribute("xiuxianyule", xiuxianyule);
			request.setAttribute("shfw", shfw);
			request.setAttribute("gowuu", gowuu);
			request.setAttribute("liren", liren);
			request.getRequestDispatcher("qiantai_main/main3.jsp").forward(request, response);
			
			//1.西餐最多的
//			Goodsbean xcgods=ss.seldangegoods(5);
//			meishi.add(xcgods);
//			
//			//2.东北菜最多的
//			Goodsbean dbgods=ss.seldangegoods(1);
//			meishi.add(dbgods);
//			
//			//3.海鲜最多的
//			Goodsbean hxgods=ss.seldangegoods(2);
//			meishi.add(hxgods);
			
//			//4.小吃快餐最多的
//			Goodsbean xckcgods=ss.seldangegoods(7);
//			meishi.add(xckcgods);
//			
//			//5.火锅最多的
//			Goodsbean jclc=ss.seldangegoods(9);
//			meishi.add(jclc);
//			
//			//6. 最多的
//			Goodsbean zzc=ss.seldangegoods(3);
//			meishi.add(zzc);
//			
//			//7.火锅最多的
//			Goodsbean xgky=ss.seldangegoods(4);
//			meishi.add(xgky);
//			
//			//8.火锅最多的 8个就好 放在主页
//			Goodsbean rh=ss.seldangegoods(5);
//			meishi.add(rh);
//			Goodsbean ycss=ss.seldangegoods(16);
//			xiuxianyule.add(ycss);
//			
//			Goodsbean zlam=ss.seldangegoods(20);
//			xiuxianyule.add(zlam);
//			
//			Goodsbean wq=ss.seldangegoods(18);
//			xiuxianyule.add(wq);
//
//			Goodsbean cs=ss.seldangegoods(19);
//			xiuxianyule.add(cs);
//			Goodsbean gxxz=ss.seldangegoods(21);
//			shfw.add(gxxz);
//			
//			Goodsbean hssy=ss.seldangegoods(22);
//			shfw.add(hssy);
//			
//			Goodsbean qzsy=ss.seldangegoods(23);
//			shfw.add(qzsy);
//			
//			Goodsbean pxkc=ss.seldangegoods(24);
//			shfw.add(pxkc);
//			Goodsbean nvz=ss.seldangegoods(25);
//			gowuu.add(nvz);
//			
//			Goodsbean naz=ss.seldangegoods(26);
//			gowuu.add(naz);
//			
//			Goodsbean ny=ss.seldangegoods(27);
//			gowuu.add(ny);
//			
//			Goodsbean shiping=ss.seldangegoods(28);
//			gowuu.add(shiping);
//			Goodsbean mf=ss.seldangegoods(11);
//			liren.add(mf);
//			
//			Goodsbean yj=ss.seldangegoods(10);
//			liren.add(yj);
		}

	}
}
