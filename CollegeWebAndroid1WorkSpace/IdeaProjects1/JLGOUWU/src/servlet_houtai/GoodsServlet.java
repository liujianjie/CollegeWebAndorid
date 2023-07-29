
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

	SimpleDateFormat si = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");// ʱ�䴦����
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
			//��ѯ��Ʒ ��ҳ 
			int pageCount=10;
			int currPage=1;
			int totalRow=ss.selgoodscount();
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
			
			List list=ss.selhtGoods(pageCount, currPage);
			
			request.setAttribute("list", list);
			//����ֵ
			request.setAttribute("currPage", currPage);
			request.setAttribute("totalRow", totalRow);
			request.setAttribute("totalPage",totalPage);
			
			request.getRequestDispatcher("houtai_goods/Goodslist.jsp").forward(request, response);
		}else if(method.equals("toadd")){
			List list=ss.selBottom();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("houtai_goods/Goodsadd.jsp").forward(request, response);
		}else if(method.equals("add")){
			
			//����һ���ļ��ϴ���
			SmartUpload su=new SmartUpload();
			
			//��ʼ��
			su.initialize(getServletConfig(),request,response);
			
			//�ϴ������ύ�������ļ�
			try {
				su.upload();
				
				//�����ļ�����Ŀ¼
				su.save("/file");
			} catch (SmartUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String g_name=su.getRequest().getParameter("uname");
			String g_dress=su.getRequest().getParameter("dress");
			String g_dec=su.getRequest().getParameter("dec");
			//��ȡ�ļ�����
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
			god.setG_count(1000);//��� Ĭ������1000
			god.setG_sale(0);//����
			god.setG_statu(0);//0Ϊδ�ϼ� 1Ϊ���ϼ�
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
		}else if(method.equals("goalert")){//ȥ�޸�
			String ID=request.getParameter("id");
			int id=Integer.parseInt(ID);
			
			Goodsbean gods=ss.selhang(id);
			
			//����
			request.setAttribute("goods", gods);
			
			List list=ss.selBottom();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("houtai_goods/alertGoods.jsp").forward(request, response);
			
		}else if(method.equals("alertnoimg")){//�޸�û��ͼƬ
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
			god.setG_statu(0);//0Ϊδ�ϼ� 1Ϊ���ϼ�
			god.setG_descrip(g_descrip);
			god.setBottom_id(Integer.parseInt(bottom));

			boolean bln=ss.alerthang(god);
			
			//������Ϣ
			request.setAttribute("goods",god );//��goalert�� ����һ��
			
			List list=ss.selBottom();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("goods?method=list").forward(request, response);
			
		}else if(method.equals("alertwithimg")){//�޸�

			//����һ���ļ��ϴ���
			SmartUpload su=new SmartUpload();
			
			//��ʼ��
			su.initialize(getServletConfig(),request,response);
			
			//�ϴ������ύ�������ļ�
			try {
				su.upload();
				
				//�����ļ�����Ŀ¼
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
			god.setG_statu(0);//0Ϊδ�ϼ� 1Ϊ���ϼ�
			god.setG_descrip(g_descrip);
			god.setBottom_id(Integer.parseInt(bottom));

			boolean bln=ss.alerthang(god);
			
			//������Ϣ
			request.setAttribute("goods",god );//��goalert�� ����һ��
			
			List list=ss.selBottom();
			
			request.setAttribute("list", list);
			
			request.getRequestDispatcher("goods?method=list").forward(request, response);
			
		}else if(method.equals("qtlist")){//ǰ̨������ͳ��ֵĵ�һ���������Ʒ ������2����ѯ 1������ 1������
			// ���ŷ���ÿ�������ȡһ��Ϳ���
			// 1. ȥһ�������
			List<MoldBean> moldlist = imolds.selmold();
			// 2. ȡ���������ĵ�һ��
			List<BottomBean> remenlist = new ArrayList<>();
			for(MoldBean mold: moldlist){
				BottomBean bt = sss.seloneBottomByMoldId(mold.getMold_id());
				if(null != bt.getBottom()){
					remenlist.add(bt);
				}
			}
			request.setAttribute("remenlist", remenlist);
			int pageCount=2;//��������Ϊ3
			
			//����
			String MOLD_ID=request.getParameter("moldid");
			int moldid=Integer.parseInt(MOLD_ID);
			
			//��ѯ���͵����з���
			List bottomlist=sss.selfenlei(moldid);//��ѯ�������͵ķ���
			
			//��ѯ������͵ĵ�һ������
			int bottomid=sss.selonnbottom_id(moldid);//û�е�Ĭ�Ϸ���Ϊ1Ҫ�����������
			/*
			 * 
			 * */
			
			//��ѯ��һ�������������Ʒ
			List list=ss.selthreeGoods(bottomid,pageCount);

			request.setAttribute("goodslist", list);//������Ʒ��Ϣ
			request.setAttribute("goodssize", list.size());
			
			request.setAttribute("list", bottomlist);//����������͵����з���
			request.setAttribute("moldid", moldid);//���������
			request.setAttribute("bottomid", bottomid);//����Ƿ���
			
			request.getRequestDispatcher("qiantai_main/right.jsp").forward(request, response);
			
		}else if(method.equals("threeqtlist")){//ǰ̨��Ʒ�б� ������2����ѯ 1������ 1������ �������Ҫ���Ƹ��� Ϊ3��
			// ���ŷ���ÿ�������ȡһ��Ϳ���
			// 1. ȥһ�������
			List<MoldBean> moldlist = imolds.selmold();
			// 2. ȡ���������ĵ�һ��
			List<BottomBean> remenlist = new ArrayList<>();
			for(MoldBean mold: moldlist){
				BottomBean bt = sss.seloneBottomByMoldId(mold.getMold_id());
				if(null != bt.getBottom()){
					remenlist.add(bt);
				}
			}
			request.setAttribute("remenlist", remenlist);
			int pageCount=2;//��������Ϊ2
			
			String ID=request.getParameter("id");//����bottom_id
			int id=Integer.parseInt(ID);
			
			List list=ss.selthreeGoods(id,pageCount);

			request.setAttribute("goodslist", list);//������Ʒ��Ϣ
			
			request.setAttribute("goodssize", list.size());//������Ʒ��С ���С��0�򲻳��ָ���
			//��ѯ������͵����з���
			String MOLD_ID=request.getParameter("moldid");
			int moldid=Integer.parseInt(MOLD_ID);
			
			List bottomlist=sss.selfenlei(moldid);//��ѯ�������͵ķ���
			
			request.setAttribute("list", bottomlist);
			request.setAttribute("moldid", moldid);//�����������������
			request.setAttribute("bottomid", id);//���Ǵ�������id
			
			request.getRequestDispatcher("qiantai_main/right.jsp").forward(request, response);
			
		}else if(method.equals("selmore")){
			//��ȡmoldid ��bottomid
			String moldid=request.getParameter("mdid");
			String bottomid=request.getParameter("bottomid");
			
			int bid=Integer.parseInt(bottomid);
			//������
			String bottom=sss.selbottomname(bid);
			
			//��ѯ��Ʒ ��ҳ 
			int pageCount=8;
			int currPage=1;
			int totalRow=ss.selbottomgoodscount(Integer.parseInt(bottomid));
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
			
			//ͨ��bottomid����ѯ��Ʒ
			List list=ss.sellistgoods(pageCount, currPage, Integer.parseInt(bottomid));

			//ͨ��moldid����ѯ������͵����з���
			List bottomlist=sss.selfenlei(Integer.parseInt(moldid));//��ѯ�������͵ķ���
			
			//������Ʒ
			request.setAttribute("goodslist", list);
			request.setAttribute("size", list.size());//Ϊ����û����Ʒ��ͼƬ������ʾ
			
			//�������
			request.setAttribute("list", bottomlist);//���༯��
			
			//�����������Ʒ�������
			BottomBean bot=(BottomBean)bottomlist.get(0);

			request.setAttribute("bottom", bottom);//������
			request.setAttribute("mold", bot.getMold());//������
			
			request.setAttribute("moldid", moldid);//moldid
			request.setAttribute("bottomid",bottomid);//bottomid
			//����ֵ
			request.setAttribute("currPage", currPage);
			request.setAttribute("totalRow", totalRow);
			request.setAttribute("totalPage",totalPage);
			
			request.getRequestDispatcher("qiantai_Goods/GoodsList.jsp").forward(request, response);
			
		}else if(method.equals("selxsgoods")){//��ѯ�����Ʒ
			//��ѯ������Ʒ ��list����
			String uname=request.getParameter("uname");
			
			List goodslist=ss.selxsgoods(uname);
			
			request.setAttribute("goodslist", goodslist);//�����ѯ����Ʒ��Ϣ
			
			request.setAttribute("listsize", goodslist.size());//�����С

			if(goodslist.size()==0){//�Ҳ���
				
				response.sendRedirect("qiantai_Goods/noxiangsigoods.jsp");
			}else{
			
			//ͨ��list�е�һ��g_id��botttom_id ����ѯmoldid
			Goodsbean gods=(Goodsbean)goodslist.get(0);
			BottomBean bot=ss.selbottom(gods.getBottom_id());
			
			//��ͨ��moldid����ѯ�м������� bottom
			List list=sss.selfenlei(bot.getMold_id());
			request.setAttribute("list", list);//���������Ϣ

			//��ѯ����
			String mold=sss.selMold(bot.getMold_id());
			
			request.setAttribute("bottom", bot.getBottom());
			request.setAttribute("mold", mold);
			
			request.setAttribute("moldid", bot.getMold_id());//moldid
			
			request.getRequestDispatcher("qiantai_Goods/GoodsList.jsp").forward(request, response);
			}
		}else if(method.equals("goodsxq")){//��Ʒ����
			String ID=request.getParameter("id");
			int id=Integer.parseInt(ID);
			
			Goodsbean goods=ss.selhang(id);
			
			request.setAttribute("goods", goods);
			
			//���ڵķ���
			BottomBean bottom=ss.selbottom(goods.getBottom_id());
			request.setAttribute("bottom", bottom);
			
			//���ڵ�����
			MoldBean mold=ss.selmold(bottom.getMold_id());

			request.setAttribute("mold", mold);
			
			//��ѯ����ͨ�� g_id���� 
			int pageCount=3;
			int currPage=1;
			int totalRow=iu.selcommentcount(id);
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
			
			List commentlist=iu.selcomment(pageCount, currPage,id);
			
			//����
			request.setAttribute("commentlist", commentlist);
			request.setAttribute("commentlistsize", commentlist.size());
			//����ֵ
			request.setAttribute("currPage", currPage);
			request.setAttribute("totalRow", totalRow);
			request.setAttribute("totalPage",totalPage);
			
			//��ѯcommentlist��uname��ͷ��ͨ��jruser_id һ��һ����Ӧ
			
			request.getRequestDispatcher("qiantai_sel/GoodsXQ.jsp").forward(request, response);
		}else if(method.equals("gouwuche")){//���ﳵ�嵥
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
				//�ڶ����Լ��Ժ���û�
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
			
		}else if(method.equals("delgwcgoods")){//ɾ�����ﳵ��Ʒ
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
		}else if(method.equals("selstartshouyegoods")){//��ѯһ��ʼ����ҳ ��Ʒ
			// ���ŷ���ÿ�������ȡһ��Ϳ���
			// 1. ȥһ�������
			List<MoldBean> moldlist = imolds.selmold();
			// 2. ȡ���������ĵ�һ��
			List<BottomBean> remenlist = new ArrayList<>();
			for(MoldBean mold: moldlist){
				BottomBean bt = sss.seloneBottomByMoldId(mold.getMold_id());
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
			
			List goodslist=ss.selfyGoods(pageCount, currPage);
			
			//����ֵ
			request.setAttribute("remenlist", remenlist);
			request.setAttribute("goodslist", goodslist);
			request.setAttribute("currPage", currPage);
			request.setAttribute("totalRow", totalRow);
			request.setAttribute("totalPage",totalPage);
			
			request.getRequestDispatcher("qiantai_main/right.jsp").forward(request, response);
		}else if(method.equals("goodspingjia")){//��Ʒ����
			String pl=request.getParameter("comment");
			
			//��������
			HttpSession session=request.getSession();
			//���� jruser_id
			JRuserBean jr=(JRuserBean)session.getAttribute("jruser");
			
			//����g_iD
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
			//������
			if(bln){
				//ȥ��ѯ��Ʒ��ϸ��servlet
				response.sendRedirect("goods?method=goodsxq&id="+g_id+"");
				
			}else{
				response.sendRedirect("zhongzhuang.jsp");
			}
			
		}else if(method.equals("dange")){
			//��5������Ϊ1����ʳ����Ʒ
			List meishi=new ArrayList();
			
			// 1.�Ȱѷ���Ϊ1���ӷ���
			List<BottomBean> bootomlist = sss.selfenlei(1);
			for(int i = 0; i < bootomlist.size(); i++){
				if(meishi.size() < 8){
					// 2. �ٴ��ӷ����ҳ���Ʒ
					BottomBean gb = bootomlist.get(i);
					if(gb.getBottom() != null){
						meishi.add(ss.seldangegoods(gb.getBottom_id()));
					}
				}else{
					break;
				}
			}
			
			//��4������Ϊ5���������ֵ���Ʒ
			List xiuxianyule=new ArrayList();
			
			bootomlist = sss.selfenlei(5);
			for(int i = 0; i < bootomlist.size(); i++){
				if(xiuxianyule.size() < 4){
					// 2. �ٴ��ӷ����ҳ���Ʒ
					BottomBean gb = bootomlist.get(i);
					if(gb.getBottom() != null){
						xiuxianyule.add(ss.seldangegoods(gb.getBottom_id()));
					}
				}else{
					break;
				}
			}
			

//			//��5������Ϊ3������������Ʒ
			List shfw=new ArrayList();
			
			bootomlist = sss.selfenlei(7);
			for(int i = 0; i < bootomlist.size(); i++){
				if(shfw.size() < 4){
					// 2. �ٴ��ӷ����ҳ���Ʒ
					BottomBean gb = bootomlist.get(i);
					if(gb.getBottom() != null){
						shfw.add(ss.seldangegoods(gb.getBottom_id()));
					}
				}else{
					break;
				}
			}
			
//			//��5������Ϊ4�Ĺ������Ʒ
			List gowuu=new ArrayList();
			
			bootomlist = sss.selfenlei(8);
			for(int i = 0; i < bootomlist.size(); i++){
				if(gowuu.size() < 4){
					// 2. �ٴ��ӷ����ҳ���Ʒ
					BottomBean gb = bootomlist.get(i);
					if(gb.getBottom() != null){
						gowuu.add(ss.seldangegoods(gb.getBottom_id()));
					}
				}else{
					break;
				}
			}
			
			//��4������Ϊ5�����˵���Ʒ
			List liren=new ArrayList();
			
			bootomlist = sss.selfenlei(9);
			for(int i = 0; i < bootomlist.size(); i++){
				if(liren.size() < 4){
					// 2. �ٴ��ӷ����ҳ���Ʒ
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
			
			//1.��������
//			Goodsbean xcgods=ss.seldangegoods(5);
//			meishi.add(xcgods);
//			
//			//2.����������
//			Goodsbean dbgods=ss.seldangegoods(1);
//			meishi.add(dbgods);
//			
//			//3.��������
//			Goodsbean hxgods=ss.seldangegoods(2);
//			meishi.add(hxgods);
			
//			//4.С�Կ������
//			Goodsbean xckcgods=ss.seldangegoods(7);
//			meishi.add(xckcgods);
//			
//			//5.�������
//			Goodsbean jclc=ss.seldangegoods(9);
//			meishi.add(jclc);
//			
//			//6. ����
//			Goodsbean zzc=ss.seldangegoods(3);
//			meishi.add(zzc);
//			
//			//7.�������
//			Goodsbean xgky=ss.seldangegoods(4);
//			meishi.add(xgky);
//			
//			//8.������� 8���ͺ� ������ҳ
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
