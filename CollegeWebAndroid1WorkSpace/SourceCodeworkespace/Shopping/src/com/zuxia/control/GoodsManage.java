package com.zuxia.control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zuxia.dao.GoodsInfoDao;
import com.zuxia.dao.GoodsTypeDao;
import com.zuxia.model.GoodsInfo;
import com.zuxia.model.GoodsType;
import com.zuxia.util.PageModel;
import com.zuxia.util.StringUtil;

public class GoodsManage extends HttpServlet {

	//处理GET请求
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String op = request.getParameter("op");
		String returnURL ="";
		if(op == null || "".equals(op.trim())){
			returnURL = queryAll(request, response);
		}else{
			if("query".equals(op)){
				returnURL = query(request, response);
			}else if("toEdit".equals(op)){
				returnURL = toEdit(request, response);
			}else if("update".equals(op)){
					returnURL = update(request,response);
			}else if("toAdd".equals(op)){
				returnURL = toAdd(request,response);
			}else if("add".equals(op)){
				returnURL = add(request,response);
			}else if("remove".equals(op)){
				returnURL = remove(request,response);
			}else if("removeMore".equals(op)){
				returnURL = removeMore(request,response);
			} else {
				request.setAttribute("msg", "访问资源出错！访问该资源未携带必要的参数！");
				returnURL = "../admin/error.jsp";
			}
		}
		
		request.getRequestDispatcher(returnURL).forward(request, response);
	}
	
	//查询所有
	private String queryAll(HttpServletRequest request, HttpServletResponse response){
		int pageSize=10;
		int pageNo=1;
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} catch (NumberFormatException e) {
		}
		GoodsInfoDao dao = new GoodsInfoDao();
		PageModel<GoodsInfo> pm = dao.getAllGoods(pageSize, pageNo);
		if(pm!=null && pm.getData().isEmpty() && pageNo!=1){
			pm = dao.getAllGoods(pageSize, 1);
		}
		request.setAttribute("allGoods", pm);
		return "../admin/goodsManage.jsp";
	}
	
	//商品关键词查询
	private String query(HttpServletRequest request, HttpServletResponse response){
		int pageSize=10;
		int pageNo=1;
		try {
			pageSize = Integer.parseInt(request.getParameter("pageSize"));
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		} catch (NumberFormatException e) {
		}
		String keyWords = request.getParameter("keywords");
		GoodsInfoDao dao = new GoodsInfoDao();
		PageModel<GoodsInfo> pm = dao.getAllGoods(pageSize, pageNo,keyWords);
		request.setAttribute("allGoods", pm);
		return "../admin/goodsManage.jsp";
	}

	//前往添加页面
	private String toAdd(HttpServletRequest request, HttpServletResponse response){
		ArrayList<GoodsType> types = new GoodsTypeDao().getAllGoodsTypes();
		request.setAttribute("types", types);
		return "../admin/addGoods.jsp";
	}
	
	//添加
	private String add(HttpServletRequest request, HttpServletResponse response){
		String goodsName = request.getParameter("goodsName");
		String typeId = request.getParameter("typeId");
		String price = request.getParameter("price");
		String discount = request.getParameter("discount");
		String status = request.getParameter("status");
		String isRecommend = request.getParameter("isRecommend");
		String isNew = request.getParameter("isNew");
		String photo = request.getParameter("photo");
		String remark = request.getParameter("remark");
		
		try {
			GoodsInfo goods = new GoodsInfo();
			goods.setGoodsName(goodsName);
			goods.getGoodsType().setTypeId(Integer.parseInt(typeId));
			goods.setPrice(Double.parseDouble(price));
			goods.setDiscount(Float.parseFloat(discount));
			goods.setIsRecommend(isRecommend==null?1:0);
			goods.setStatus(status==null?1:0);
			goods.setIsNew(isNew==null?1:0);
			String fileName = photo.substring(photo.lastIndexOf("\\")+1);
			goods.setPhoto(fileName);
			goods.setRemark(remark);
			
			boolean flag = new GoodsInfoDao().addGoods(goods);
			if(flag){
				return queryAll(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", "对不起，添加商品信息失败！");
		return "../admin/failed.jsp";
	}
	
	//去修改页面
	private String toEdit(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		if(!StringUtil.isNullOrEmpty(id)){
			GoodsInfo goods = new GoodsInfoDao().getGoodsInfo(Integer.parseInt(id));
			if(goods!=null){
				request.setAttribute("goods", goods);
				ArrayList<GoodsType> types = new GoodsTypeDao().getAllGoodsTypes();
				request.setAttribute("types", types);
				return "../admin/updateGoods.jsp";
			}
		}
		request.setAttribute("msg", "对不起，未找到此商品信息！");
		return "../admin/error.jsp";
	}
	
	//修改
	private String update(HttpServletRequest request, HttpServletResponse response){
		String goodsId = request.getParameter("id");
		String goodsName = request.getParameter("goodsName");
		String typeId = request.getParameter("typeId");
		String price = request.getParameter("price");
		String discount = request.getParameter("discount");
		String status = request.getParameter("status");
		String isRecommend = request.getParameter("isRecommend");
		String isNew = request.getParameter("isNew");
		String photo = request.getParameter("photo");
		String remark = request.getParameter("remark");
		
		try {
			GoodsInfo goods = new GoodsInfo();
			goods.setGoodsId(Integer.parseInt(goodsId));
			goods.setGoodsName(goodsName);
			goods.getGoodsType().setTypeId(Integer.parseInt(typeId));
			goods.setPrice(Double.parseDouble(price));
			goods.setDiscount(Float.parseFloat(discount));
			goods.setIsRecommend(isRecommend==null?1:0);
			goods.setStatus(status==null?1:0);
			goods.setIsNew(isNew==null?1:0);
			String fileName = photo.substring(photo.lastIndexOf("\\")+1);
			goods.setPhoto(fileName);
			goods.setRemark(remark);
			
			boolean flag = new GoodsInfoDao().updateGoods(goods);
			if(flag){
				return queryAll(request, response);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		request.setAttribute("msg", "对不起，修改商品信息失败！");
		return "../admin/failed.jsp";
	}
	
	//删除
	private String remove(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		if(!StringUtil.isNullOrEmpty(id)){
			boolean  flag = new GoodsInfoDao().removeGoods(Integer.parseInt(id));
			if(flag){
				return queryAll(request, response);
			}
		}
		request.setAttribute("msg", "对不起，删除商品信息失败！");
		return "../admin/failed.jsp";
	}
	
	//删除多个
	private String removeMore(HttpServletRequest request, HttpServletResponse response){
		String ids = request.getParameter("removeIds");
		if(!StringUtil.isNullOrEmpty(ids)){
			boolean  flag = new GoodsInfoDao().removeGoods(ids);
			if(flag){
				return queryAll(request, response);
			}
		}
		request.setAttribute("msg", "对不起，删除商品信息失败！");
		return "../admin/failed.jsp";
	}
	
	
	//处理POST请求
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
