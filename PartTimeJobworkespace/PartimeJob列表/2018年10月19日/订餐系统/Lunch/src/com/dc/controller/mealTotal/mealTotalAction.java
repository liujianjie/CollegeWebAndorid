package com.dc.controller.mealTotal;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.dc.dao.mealTotal.TotalDAO;
import com.dc.dao.mealTotal.TotalDAOImpl;
import com.dc.entity.PageEntity;
import com.dc.util.BaseAction;
import com.dc.util.StringUtil;

public class mealTotalAction extends BaseAction{
      private String dateA;
      private String dateB;
      private List list;
      private String target;
      private String nowpage;
      private PageEntity page;
      private Map map;
      private Map mapall;
      
      //菜品统计
      public String MealTotal(){
    	  int pageN=0;
  	    if(com.dc.util.StringUtil.checkNotNull(nowpage)){
  	    	pageN=Integer.parseInt(nowpage);
  	    }else{
  	    	pageN=1;
  	    }
  		PageEntity page1=new PageEntity();
  		page1.setNowpage(pageN);
  		TotalDAO total=new TotalDAOImpl();
  		Map map1=new HashedMap();
  		map1.put("dateA", dateA);
  		map1.put("dateB", dateB);
  		list=total.Select(map1, page1);
  		mapall=total.SelectAll(map1);
  		this.map=map1;
  		this.page=page1;
      	this.target="/module/mealTotal/MealTotal.jsp";
      	return "success";
      }
      /**
       * 菜品图表统计
       * @return
       */
      public void MealTu(){
  		TotalDAO total=new TotalDAOImpl();
  		Map map1=new HashedMap();
  		map1.put("dateA", dateA);
  		map1.put("dateB", dateB);
  		list=total.mealTu(map1);
  		this.map=map1;
  		this.getOut().print(StringUtil.transListToJson(list));
      }
      


	public Map getMapall() {
		return mapall;
	}



	public void setMapall(Map mapall) {
		this.mapall = mapall;
	}



	public Map getMap() {
		return map;
	}


	public void setMap(Map map) {
		this.map = map;
	}


	public String getDateA() {
		return dateA;
	}


	public void setDateA(String dateA) {
		this.dateA = dateA;
	}


	public String getDateB() {
		return dateB;
	}


	public void setDateB(String dateB) {
		this.dateB = dateB;
	}


	public List getList() {
		return list;
	}


	public void setList(List list) {
		this.list = list;
	}


	public String getTarget() {
		return target;
	}


	public void setTarget(String target) {
		this.target = target;
	}


	public String getNowpage() {
		return nowpage;
	}


	public void setNowpage(String nowpage) {
		this.nowpage = nowpage;
	}


	public PageEntity getPage() {
		return page;
	}


	public void setPage(PageEntity page) {
		this.page = page;
	}
      
      
}
