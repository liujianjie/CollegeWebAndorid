
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

	SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// ʱ�䴦����
	@RequestMapping("list")
	private String list(Model model, String currp){
		//��ѯ��Ʒ ��ҳ 
		int pageCount=10;
		int currPage=1;
		int totalRow=ss.selgoodscount();
		int totalPage=(totalRow+pageCount-1)/pageCount;
		//��goodsxq.jsp�в���Ȼ�󴫹�����ҳ������
		String currpage=currp;
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
		List<Goods> list=ss.selhtGoods(pageCount, currPage);
		model.addAttribute("list", list);
		//����ֵ
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
				//��ȡ�ļ�����
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
				god.setG_count(1000);//��� Ĭ������1000
				god.setG_sale(0);//����
				god.setG_statu(0);//0Ϊδ�ϼ� 1Ϊ���ϼ�
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
		//����
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
		god.setG_statu(0);//0Ϊδ�ϼ� 1Ϊ���ϼ�
		god.setG_descrip(g_descrip);
		god.setBottom_id(Integer.parseInt(bottom));

		boolean bln=ss.alerthang(god);
		
		//������Ϣ
		request.setAttribute("goods",god );//��goalert�� ����һ��
		
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
				//��ȡ�ļ�����
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
				god.setG_statu(0);//0Ϊδ�ϼ� 1Ϊ���ϼ�
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
			//������Ϣ
			request.setAttribute("goods",god );//��goalert�� ����һ��
			
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
		// ���ŷ���ÿ�������ȡһ��Ϳ���
		// 1. ȥһ�������
		List<Mold> moldlist = imolds.selmold();
		// 2. ȡ���������ĵ�һ��
		List<Bottom> remenlist = new ArrayList<>();
		for(Mold mold: moldlist){
			Bottom bt = sss.seloneBottomByMoldId(mold.getMold_id());
			if(null != bt.getBottom()){
				remenlist.add(bt);
			}
		}
		model.addAttribute("remenlist", remenlist);
		int pageCount=2;//��������Ϊ3
		
		//����
		String MOLD_ID=moldid;
		int moldid1=Integer.parseInt(MOLD_ID);
		
		//��ѯ���͵����з���
		List bottomlist=sss.selfenlei(moldid1);//��ѯ�������͵ķ���
		
		//��ѯ������͵ĵ�һ������
		int bottomid=sss.selonnbottom_id(moldid1);//û�е�Ĭ�Ϸ���Ϊ1Ҫ�����������
		
		//��ѯ��һ�������������Ʒ
		List list=ss.selthreeGoods(bottomid,pageCount);

		model.addAttribute("goodslist", list);//������Ʒ��Ϣ
		model.addAttribute("goodssize", list.size());
		
		model.addAttribute("list", bottomlist);//����������͵����з���
		model.addAttribute("moldid", moldid);//���������
		model.addAttribute("bottomid", bottomid);//����Ƿ���
		
		return "qiantai_main/right";
	}
	@RequestMapping("threeqtlist")
	private String threeqtlist(Model model, String id, String moldid){
		// ���ŷ���ÿ�������ȡһ��Ϳ���
		// 1. ȥһ�������
		List<Mold> moldlist = imolds.selmold();
		// 2. ȡ���������ĵ�һ��
		List<Bottom> remenlist = new ArrayList<>();
		for(Mold mold: moldlist){
			Bottom bt = sss.seloneBottomByMoldId(mold.getMold_id());
			if(null != bt.getBottom()){
				remenlist.add(bt);
			}
		}
		model.addAttribute("remenlist", remenlist);
		int pageCount=2;//��������Ϊ2
		
		String ID=id;//����bottom_id
		int id1=Integer.parseInt(ID);
		
		List list=ss.selthreeGoods(id1,pageCount);

		model.addAttribute("goodslist", list);//������Ʒ��Ϣ
		
		model.addAttribute("goodssize", list.size());//������Ʒ��С ���С��0�򲻳��ָ���
		//��ѯ������͵����з���
		String MOLD_ID=moldid;
		int moldid1=Integer.parseInt(MOLD_ID);
		
		List<Bottom> bottomlist=sss.selfenlei(moldid1);//��ѯ�������͵ķ���
		
		model.addAttribute("list", bottomlist);
		model.addAttribute("moldid", moldid);//�����������������
		model.addAttribute("bottomid", id);//���Ǵ�������id

		return "qiantai_main/right";
	}
	@RequestMapping("selmore")
	private String selmore(Model model, String mdid, String bottomid, String currp){
		//��ȡmoldid ��bottomid
		String moldid=mdid;
//		String bottomid=request.getParameter("bottomid");
		
		int bid=Integer.parseInt(bottomid);
		//������
		String bottom=sss.selbottomname(bid);
		
		//��ѯ��Ʒ ��ҳ 
		int pageCount=8;
		int currPage=1;
		int totalRow=ss.selbottomgoodscount(Integer.parseInt(bottomid));
		int totalPage=(totalRow+pageCount-1)/pageCount;
		
		//��goodsxq.jsp�в���Ȼ�󴫹�����ҳ������
		String currpage=currp;
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
		
		//ͨ��bottomid����ѯ��Ʒ
		List list=ss.sellistgoods(pageCount, currPage, Integer.parseInt(bottomid));

		//ͨ��moldid����ѯ������͵����з���
		List bottomlist=sss.selfenlei(Integer.parseInt(moldid));//��ѯ�������͵ķ���
		
		//������Ʒ
		model.addAttribute("goodslist", list);
		model.addAttribute("size", list.size());//Ϊ����û����Ʒ��ͼƬ������ʾ
		
		//�������
		model.addAttribute("list", bottomlist);//���༯��
		
		//�����������Ʒ�������
		Bottom bot=(Bottom)bottomlist.get(0);

		model.addAttribute("bottom", bottom);//������
		model.addAttribute("mold", bot.getMold());//������
		
		model.addAttribute("moldid", moldid);//moldid
		model.addAttribute("bottomid",bottomid);//bottomid
		//����ֵ
		model.addAttribute("currPage", currPage);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage",totalPage);
		
		return "qiantai_Goods/GoodsList";
	}
	@RequestMapping("selxsgoods")
	private String selxsgoods(Model model, String uname, String bottomid, String currp){
		//��ѯ������Ʒ ��list����
//		String uname=request.getParameter("uname");
		
		List<Goods> goodslist=ss.selxsgoods(uname);
		
		model.addAttribute("goodslist", goodslist);//�����ѯ����Ʒ��Ϣ
		
		model.addAttribute("listsize", goodslist.size());//�����С

		if(goodslist.size()==0){//�Ҳ���
//			response.sendRedirect("qiantai_Goods/noxiangsigoods.jsp");
			return "qiantai_Goods/noxiangsigoods";
		}else{
		
		//ͨ��list�е�һ��g_id��botttom_id ����ѯmoldid
		Goods gods=(Goods)goodslist.get(0);
		Bottom bot=ss.selbottom(gods.getBottom_id());
		
		//��ͨ��moldid����ѯ�м������� bottom
		List<Bottom> list=sss.selfenlei(bot.getMold_id());
		model.addAttribute("list", list);//���������Ϣ

		//��ѯ����
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
		
		//���ڵķ���
		Bottom bottom=ss.selbottom(goods.getBottom_id());
		model.addAttribute("bottom", bottom);
		
		//���ڵ�����
		Mold mold=ss.selmold(bottom.getMold_id());

		model.addAttribute("mold", mold);
		
		//��ѯ����ͨ�� g_id���� 
		int pageCount=3;
		int currPage=1;
		int totalRow=iu.selcommentcount(id1);
		int totalPage=(totalRow+pageCount-1)/pageCount;
		
		//��goodsxq.jsp�в���Ȼ�󴫹�����ҳ������
		String currpage=currp;
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
		
		List<Comment> commentlist=iu.selcomment(pageCount, currPage, id1);
		
		//����
		model.addAttribute("commentlist", commentlist);
		model.addAttribute("commentlistsize", commentlist.size());
		//����ֵ
		model.addAttribute("currPage", currPage);
		model.addAttribute("totalRow", totalRow);
		model.addAttribute("totalPage",totalPage);
		
		//��ѯcommentlist��uname��ͷ��ͨ��jruser_id һ��һ����Ӧ
		
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
			//�ڶ����Լ��Ժ���û�
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
		// ���ŷ���ÿ�������ȡһ��Ϳ���
		// 1. ȥһ�������
		List<Mold> moldlist = imolds.selmold();
		// 2. ȡ���������ĵ�һ��
		List<Bottom> remenlist = new ArrayList<>();
		for(Mold mold: moldlist){
			Bottom bt = sss.seloneBottomByMoldId(mold.getMold_id());
			if(null != bt.getBottom()){
				remenlist.add(bt);
			}
		}
		
		//ͨ�������Ķ��ٶԱ�����ȥ��Ʒ ��ҳ������
		int pageCount=2;
		int currPage=1;
		int totalRow=ss.selgoodscount();
		int totalPage=6;//����Ϊ6ҳ
		
		//��right.jsp�в���Ȼ�󴫹�����ҳ������
		String currpage=currp;
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
		
		List<Goods> goodslist=ss.selfyGoods(pageCount, currPage);
		
		//����ֵ
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
		
		//��������
		HttpSession session=request.getSession();
		//���� jruser_id
		JRuser jr=(JRuser)session.getAttribute("jruser");
		
		//����g_iD
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
		//������
		if(bln){
			//ȥ��ѯ��Ʒ��ϸ��servlet
//			response.sendRedirect("goods?method=goodsxq&id="+g_id+"");
			rdmodel.addAttribute("id", g_id);
			return "redirect:/goods/goodsxq";
			
		}else{
			return "zhongzhuang";
		}
	}
	@RequestMapping("dange")
	private String dange(Model model, HttpServletRequest request,  String comment, String gid){
		//��5������Ϊ1����ʳ����Ʒ
		List<Goods> meishi=new ArrayList<Goods>();
		
		// 1.�Ȱѷ���Ϊ1���ӷ���
		List<Bottom> bootomlist = sss.selfenlei(1);
		for(int i = 0; i < bootomlist.size(); i++){
			if(meishi.size() < 8){
				// 2. �ٴ��ӷ����ҳ���Ʒ
				Bottom gb = bootomlist.get(i);
				if(gb.getBottom() != null){
					meishi.add(ss.seldangegoods(gb.getBottom_id()));
				}
			}else{
				break;
			}
		}
		
		//��4������Ϊ5���������ֵ���Ʒ
		List<Goods> xiuxianyule=new ArrayList<Goods>();
		
		bootomlist = sss.selfenlei(5);
		for(int i = 0; i < bootomlist.size(); i++){
			if(xiuxianyule.size() < 4){
				// 2. �ٴ��ӷ����ҳ���Ʒ
				Bottom gb = bootomlist.get(i);
				if(gb.getBottom() != null){
					xiuxianyule.add(ss.seldangegoods(gb.getBottom_id()));
				}
			}else{
				break;
			}
		}
		

//		//��5������Ϊ3������������Ʒ
		List<Goods> shfw=new ArrayList<Goods>();
		
		bootomlist = sss.selfenlei(7);
		for(int i = 0; i < bootomlist.size(); i++){
			if(shfw.size() < 4){
				// 2. �ٴ��ӷ����ҳ���Ʒ
				Bottom gb = bootomlist.get(i);
				if(gb.getBottom() != null){
					shfw.add(ss.seldangegoods(gb.getBottom_id()));
				}
			}else{
				break;
			}
		}
		
//		//��5������Ϊ4�Ĺ������Ʒ
		List<Goods> gowuu=new ArrayList<Goods>();
		
		bootomlist = sss.selfenlei(8);
		for(int i = 0; i < bootomlist.size(); i++){
			if(gowuu.size() < 4){
				// 2. �ٴ��ӷ����ҳ���Ʒ
				Bottom gb = bootomlist.get(i);
				if(gb.getBottom() != null){
					gowuu.add(ss.seldangegoods(gb.getBottom_id()));
				}
			}else{
				break;
			}
		}
		
		//��4������Ϊ5�����˵���Ʒ
		List<Goods> liren=new ArrayList<Goods>();
		
		bootomlist = sss.selfenlei(9);
		for(int i = 0; i < bootomlist.size(); i++){
			if(liren.size() < 4){
				// 2. �ٴ��ӷ����ҳ���Ʒ
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
