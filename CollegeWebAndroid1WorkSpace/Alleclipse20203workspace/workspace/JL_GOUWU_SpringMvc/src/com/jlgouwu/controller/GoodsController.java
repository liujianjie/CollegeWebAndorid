
package com.jlgouwu.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
//import javax.jms.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jlgouwu.pojo.Bottom;
import com.jlgouwu.pojo.Comment;
import com.jlgouwu.pojo.Goods;
import com.jlgouwu.pojo.JRuser;
import com.jlgouwu.pojo.Mold;
import com.jlgouwu.service.BottomService;
import com.jlgouwu.service.GoodsService;
import com.jlgouwu.service.MoldService;
import com.jlgouwu.service.UserOrdersService;
//import com.sun.org.apache.bcel.internal.generic.AALOAD;

@Controller
@RequestMapping("goods")
public class GoodsController{
	@Resource
	GoodsService ss;
	@Resource
	BottomService sss;
	@Resource
	UserOrdersService iu;
	@Resource
	MoldService imolds;

	SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// 时间处理器
	@RequestMapping("list")
	private String list(Model model, String currp){
		//查询商品 分页 
		int pageCount=10;
		int currPage=1;
		int totalRow=ss.selgoodscount();
		int totalPage=(totalRow+pageCount-1)/pageCount;
		//从goodsxq.jsp中操作然后传过来的页数处理
		String currpage=currp;
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
		List<Goods> list=ss.selhtGoods(pageCount, currPage);
		model.addAttribute("list", list);
		//保存值
		model.addAttribute("currPage", currPage);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage",totalPage);
		return "houtai_goods/Goodslist";
	}
	@RequestMapping("toadd")
	private String toadd(Model model){
		List list=ss.selBottom();
		model.addAttribute("list", list);
		return "houtai_goods/Goodsadd";
	}
	@RequestMapping("add")
	private String add(List<MultipartFile> uploadfile, HttpServletRequest request){
		if(!uploadfile.isEmpty() && uploadfile.size() > 0 ) {
			for(MultipartFile file : uploadfile) {
				String g_name=request.getParameter("uname");
				String g_dress=request.getParameter("dress");
				String g_dec=request.getParameter("dec");
				//获取文件名称
//				String g_img=su.getFiles().getFile(0).getFileName();
				String g_img = file.getOriginalFilename();
				String g_price=request.getParameter("price");
				String g_scj=request.getParameter("scj");
				String bottom=request.getParameter("bottom");
				String g_descrip=request.getParameter("descrip");
				Goods god=new Goods();
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
				
				String originalFilename = file.getOriginalFilename();
				String dirPath = request.getServletContext().getRealPath("/file/");
				System.out.println(dirPath+originalFilename);
				File filePath = new File(dirPath);
				if(!filePath.exists()) {
					filePath.mkdirs();
				}
				try {
					file.transferTo(new File(dirPath + originalFilename ));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//System.out.println(bln);
//			request.getRequestDispatcher("goods?method=list").forward(request, response);
			return "redirect:/goods/list";
		}else {
			return "error";
		}
	}
	@RequestMapping("del")
	private String del(Model model, String id){
		String ID=id;
		int id1=Integer.parseInt(ID);
		
		boolean bln=ss.delGoods(id1);
		
		return "redirect:/goods/list";
	}
	@RequestMapping("goalert")
	private String goalert(Model model, String id){
		int id1=Integer.parseInt(id);
		Goods gods=ss.selhang(id1);
		//保存
		model.addAttribute("goods", gods);
		
		List<Bottom> list=ss.selBottom();
		
		model.addAttribute("list", list);
		
		return "houtai_goods/alertGoods";
	}
	@RequestMapping("alertnoimg")
	private String alertnoimg(HttpServletRequest request){
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
		
		Goods god=new Goods();
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
		
//		request.getRequestDispatcher("goods?method=list").forward(request, response);
		
		return "redirect:/goods/list";
	}
	@RequestMapping("alertwithimg")
	private String alertwithimg(List<MultipartFile> uploadfile, HttpServletRequest request){
		if(!uploadfile.isEmpty() && uploadfile.size() > 0 ) {
			Goods god=new Goods();
			for(MultipartFile file : uploadfile) {
				String g_name=request.getParameter("uname");
				String g_dress=request.getParameter("dress");
				String g_dec=request.getParameter("dec");
				//获取文件名称
//				String g_img=su.getFiles().getFile(0).getFileName();
				String g_img = file.getOriginalFilename();
				String g_price=request.getParameter("price");
				String g_scj=request.getParameter("scj");
				String bottom=request.getParameter("bottom");
				String g_descrip=request.getParameter("descrip");
				
				String ID=request.getParameter("id");
				int id=Integer.parseInt(ID);
				
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
				
				String originalFilename = file.getOriginalFilename();
				String dirPath = request.getServletContext().getRealPath("/file/");
				System.out.println(dirPath+originalFilename);
				File filePath = new File(dirPath);
				if(!filePath.exists()) {
					filePath.mkdirs();
				}
				try {
					file.transferTo(new File(dirPath + originalFilename ));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			//保存信息
			request.setAttribute("goods",god );//与goalert的 名称一样
			
			List list=ss.selBottom();
			
			request.setAttribute("list", list);
			
//			request.getRequestDispatcher("goods?method=list").forward(request, response);
			return "redirect:/goods/list";
		}else {
			return "error";
		}
	}
	@RequestMapping("qtlist")
	private String qtlist(Model model, String moldid){
		// 热门分类每个大分类取一项就可以
		// 1. 去一级分类表
		List<Mold> moldlist = imolds.selmold();
		// 2. 取二级分类表的第一个
		List<Bottom> remenlist = new ArrayList<>();
		for(Mold mold: moldlist){
			Bottom bt = sss.seloneBottomByMoldId(mold.getMold_id());
			if(null != bt.getBottom()){
				remenlist.add(bt);
			}
		}
		model.addAttribute("remenlist", remenlist);
		int pageCount=2;//控制数量为3
		
		//类型
		String MOLD_ID=moldid;
		int moldid1=Integer.parseInt(MOLD_ID);
		
		//查询类型的所有分类
		List bottomlist=sss.selfenlei(moldid1);//查询好了类型的分类
		
		//查询这个类型的第一个分类
		int bottomid=sss.selonnbottom_id(moldid1);//没有的默认返回为1要处理这个问题
		
		//查询第一个分类的所有商品
		List list=ss.selthreeGoods(bottomid,pageCount);

		model.addAttribute("goodslist", list);//这是商品信息
		model.addAttribute("goodssize", list.size());
		
		model.addAttribute("list", bottomlist);//这是这个类型的所有分类
		model.addAttribute("moldid", moldid);//这个是类型
		model.addAttribute("bottomid", bottomid);//这个是分类
		
		return "qiantai_main/right";
	}
	@RequestMapping("threeqtlist")
	private String threeqtlist(Model model, String id, String moldid){
		// 热门分类每个大分类取一项就可以
		// 1. 去一级分类表
		List<Mold> moldlist = imolds.selmold();
		// 2. 取二级分类表的第一个
		List<Bottom> remenlist = new ArrayList<>();
		for(Mold mold: moldlist){
			Bottom bt = sss.seloneBottomByMoldId(mold.getMold_id());
			if(null != bt.getBottom()){
				remenlist.add(bt);
			}
		}
		model.addAttribute("remenlist", remenlist);
		int pageCount=2;//控制数量为2
		
		String ID=id;//分类bottom_id
		int id1=Integer.parseInt(ID);
		
		List list=ss.selthreeGoods(id1,pageCount);

		model.addAttribute("goodslist", list);//这是商品信息
		
		model.addAttribute("goodssize", list.size());//这是商品大小 如果小于0则不出现更多
		//查询这个类型的所有分类
		String MOLD_ID=moldid;
		int moldid1=Integer.parseInt(MOLD_ID);
		
		List<Bottom> bottomlist=sss.selfenlei(moldid1);//查询好了类型的分类
		
		model.addAttribute("list", bottomlist);
		model.addAttribute("moldid", moldid);//保存这两个来查更多
		model.addAttribute("bottomid", id);//就是传过来的id

		return "qiantai_main/right";
	}
	@RequestMapping("selmore")
	private String selmore(Model model, String mdid, String bottomid, String currp){
		//获取moldid 和bottomid
		String moldid=mdid;
//		String bottomid=request.getParameter("bottomid");
		
		int bid=Integer.parseInt(bottomid);
		//分类名
		String bottom=sss.selbottomname(bid);
		
		//查询商品 分页 
		int pageCount=8;
		int currPage=1;
		int totalRow=ss.selbottomgoodscount(Integer.parseInt(bottomid));
		int totalPage=(totalRow+pageCount-1)/pageCount;
		
		//从goodsxq.jsp中操作然后传过来的页数处理
		String currpage=currp;
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
		model.addAttribute("goodslist", list);
		model.addAttribute("size", list.size());//为了让没有商品的图片不会显示
		
		//保存分类
		model.addAttribute("list", bottomlist);//分类集合
		
		//保存类型名称分类名称
		Bottom bot=(Bottom)bottomlist.get(0);

		model.addAttribute("bottom", bottom);//分类名
		model.addAttribute("mold", bot.getMold());//类型名
		
		model.addAttribute("moldid", moldid);//moldid
		model.addAttribute("bottomid",bottomid);//bottomid
		//保存值
		model.addAttribute("currPage", currPage);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage",totalPage);
		
		return "qiantai_Goods/GoodsList";
	}
	@RequestMapping("selxsgoods")
	private String selxsgoods(Model model, String uname, String bottomid, String currp){
		//查询更多商品 用list保存
//		String uname=request.getParameter("uname");
		
		List<Goods> goodslist=ss.selxsgoods(uname);
		
		model.addAttribute("goodslist", goodslist);//保存查询的物品信息
		
		model.addAttribute("listsize", goodslist.size());//保存大小

		if(goodslist.size()==0){//找不到
//			response.sendRedirect("qiantai_Goods/noxiangsigoods.jsp");
			return "qiantai_Goods/noxiangsigoods";
		}else{
		
		//通过list中第一个g_id的botttom_id 来查询moldid
		Goods gods=(Goods)goodslist.get(0);
		Bottom bot=ss.selbottom(gods.getBottom_id());
		
		//再通过moldid来查询有几个分类 bottom
		List<Bottom> list=sss.selfenlei(bot.getMold_id());
		model.addAttribute("list", list);//保存分类信息

		//查询类型
		String mold=sss.selMold2(bot.getMold_id());
		
		model.addAttribute("bottom", bot.getBottom());
		model.addAttribute("mold", mold);
		
		model.addAttribute("moldid", bot.getMold_id());//moldid
		
		return "qiantai_Goods/GoodsList";
		}
	}
	@RequestMapping("goodsxq")
	private String goodsxq(Model model, String id, String currp){
		String ID=id;
		int id1=Integer.parseInt(ID);
		
		Goods goods=ss.selhang(id1);
		
		model.addAttribute("goods", goods);
		
		//属于的分类
		Bottom bottom=ss.selbottom(goods.getBottom_id());
		model.addAttribute("bottom", bottom);
		
		//属于的类型
		Mold mold=ss.selmold(bottom.getMold_id());

		model.addAttribute("mold", mold);
		
		//查询评论通过 g_id来查 
		int pageCount=3;
		int currPage=1;
		int totalRow=iu.selcommentcount(id1);
		int totalPage=(totalRow+pageCount-1)/pageCount;
		
		//从goodsxq.jsp中操作然后传过来的页数处理
		String currpage=currp;
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
		
		List<Comment> commentlist=iu.selcomment(pageCount, currPage, id1);
		
		//保存
		model.addAttribute("commentlist", commentlist);
		model.addAttribute("commentlistsize", commentlist.size());
		//保存值
		model.addAttribute("currPage", currPage);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage",totalPage);
		
		//查询commentlist中uname和头像通过jruser_id 一个一个对应
		
		return "qiantai_sel/GoodsXQ";
	}
	@RequestMapping("gouwuche")
	private String gouwuche(Model model, HttpServletRequest request, String id, String currp){
		String ID=id;
		int id1=Integer.parseInt(ID);
		
		Goods goods=ss.selhang(id1);
		
		HttpSession session=request.getSession();
		
		boolean bln=true;
		
		Object obj=session.getAttribute("gwcgoods");
		if(obj==null){
			List<Goods> list=new ArrayList<Goods>();
			list.add(goods);
			session.setAttribute("gwcgoods", list);
			session.setAttribute("chartcount", list.size());
		}else{
			//第二个以及以后的用户
			List<Goods> li=(List<Goods>)obj;
			for(int i=0;i<li.size();i++){
				Goods gods=(Goods)li.get(i);
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
		
		return "qiantai_sel/GoodsGouWuChe";
	}
	@RequestMapping("delgwcgoods")
	private String delgwcgoods(Model model, HttpServletRequest request, String id, String currp){
		HttpSession session=request.getSession();
		
		String ID=id;
		int id1=Integer.parseInt(ID);
		
		List<Goods> list=(List)session.getAttribute("gwcgoods");
		
		for(int i=0;i<list.size();i++){
			Goods gods=(Goods)list.get(i);
			if(gods.getG_id()==id1){
				list.remove(i);
			}
		}
		session.setAttribute("chartcount", list.size());
		return "qiantai_sel/GoodsGouWuChe";
	}
	@RequestMapping("selstartshouyegoods")
	private String selstartshouyegoods(Model model, HttpServletRequest request,  String currp){
		// 热门分类每个大分类取一项就可以
		// 1. 去一级分类表
		List<Mold> moldlist = imolds.selmold();
		// 2. 取二级分类表的第一个
		List<Bottom> remenlist = new ArrayList<>();
		for(Mold mold: moldlist){
			Bottom bt = sss.seloneBottomByMoldId(mold.getMold_id());
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
		String currpage=currp;
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
		
		List<Goods> goodslist=ss.selfyGoods(pageCount, currPage);
		
		//保存值
		model.addAttribute("remenlist", remenlist);
		model.addAttribute("goodslist", goodslist);
		model.addAttribute("currPage", currPage);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage",totalPage);
		
		return "qiantai_main/right";
	}
	@RequestMapping("goodspingjia")
	private String goodspingjia(RedirectAttributes rdmodel, HttpServletRequest request,  String comment, String gid){
		System.out.println("goodspingjia"+gid);
		String pl=comment;
		
		//保存评论
		HttpSession session=request.getSession();
		//先是 jruser_id
		JRuser jr=(JRuser)session.getAttribute("jruser");
		
		//再是g_iD
		String G_id=gid;
		int g_id=Integer.parseInt(G_id);
		
		Comment co=new Comment();
		co.setJruser_id(jr.getJruser_id());
		co.setG_id(g_id);
		co.setC_comment(pl);
//		co.setC_time( new Date().toLocaleString());
		co.setC_time(si.format(new Date()));
		boolean bln=iu.addcomment(co);
		System.out.println(bln);
		//评论完
		if(bln){
			//去查询商品详细的servlet
//			response.sendRedirect("goods?method=goodsxq&id="+g_id+"");
			rdmodel.addAttribute("id", g_id);
			return "redirect:/goods/goodsxq";
			
		}else{
			return "zhongzhuang";
		}
	}
	@RequestMapping("dange")
	private String dange(Model model, HttpServletRequest request,  String comment, String gid){
		//找5个分类为1的美食的商品
		List<Goods> meishi=new ArrayList<Goods>();
		
		// 1.先把分类为1的子分类
		List<Bottom> bootomlist = sss.selfenlei(1);
		for(int i = 0; i < bootomlist.size(); i++){
			if(meishi.size() < 8){
				// 2. 再从子分类找出物品
				Bottom gb = bootomlist.get(i);
				if(gb.getBottom() != null){
					meishi.add(ss.seldangegoods(gb.getBottom_id()));
				}
			}else{
				break;
			}
		}
		
		//找4个分类为5的休闲娱乐的商品
		List<Goods> xiuxianyule=new ArrayList<Goods>();
		
		bootomlist = sss.selfenlei(5);
		for(int i = 0; i < bootomlist.size(); i++){
			if(xiuxianyule.size() < 4){
				// 2. 再从子分类找出物品
				Bottom gb = bootomlist.get(i);
				if(gb.getBottom() != null){
					xiuxianyule.add(ss.seldangegoods(gb.getBottom_id()));
				}
			}else{
				break;
			}
		}
		

//		//找5个分类为3的生活服务的商品
		List<Goods> shfw=new ArrayList<Goods>();
		
		bootomlist = sss.selfenlei(7);
		for(int i = 0; i < bootomlist.size(); i++){
			if(shfw.size() < 4){
				// 2. 再从子分类找出物品
				Bottom gb = bootomlist.get(i);
				if(gb.getBottom() != null){
					shfw.add(ss.seldangegoods(gb.getBottom_id()));
				}
			}else{
				break;
			}
		}
		
//		//找5个分类为4的购物的商品
		List<Goods> gowuu=new ArrayList<Goods>();
		
		bootomlist = sss.selfenlei(8);
		for(int i = 0; i < bootomlist.size(); i++){
			if(gowuu.size() < 4){
				// 2. 再从子分类找出物品
				Bottom gb = bootomlist.get(i);
				if(gb.getBottom() != null){
					gowuu.add(ss.seldangegoods(gb.getBottom_id()));
				}
			}else{
				break;
			}
		}
		
		//找4个分类为5的丽人的商品
		List<Goods> liren=new ArrayList<Goods>();
		
		bootomlist = sss.selfenlei(9);
		for(int i = 0; i < bootomlist.size(); i++){
			if(liren.size() < 4){
				// 2. 再从子分类找出物品
				Bottom gb = bootomlist.get(i);
				if(gb.getBottom() != null){
					liren.add(ss.seldangegoods(gb.getBottom_id()));
				}
			}else{
				break;
			}
		}
		
		model.addAttribute("meishigoods", meishi);
		model.addAttribute("xiuxianyule", xiuxianyule);
		model.addAttribute("shfw", shfw);
		model.addAttribute("gowuu", gowuu);
		model.addAttribute("liren", liren);
		return "qiantai_main/main3";
	}
}
