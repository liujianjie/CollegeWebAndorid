package com.dc.controller.customerTotal;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;

import com.dc.dao.customerTotal.totalDAO;
import com.dc.dao.customerTotal.totalDAOImpl;
import com.dc.dao.pinlun.PinLunDAO;
import com.dc.dao.pinlun.PinLunDAOImpl;
import com.dc.entity.PageEntity;

public class customerTotalAction {
    private List list;
    private String target;
    private String nowpage;
    private PageEntity page;
    private Map map; 
    private Map usermap; 
    private String dateA;//日期
    private String dateB;
    //顾客统计
    public String CustomerTotal(){
    	int pageN=0;
	    if(com.dc.util.StringUtil.checkNotNull(nowpage)){
	    	pageN=Integer.parseInt(nowpage);
	    }else{
	    	pageN=1;
	    }
		PageEntity page1=new PageEntity();
		page1.setNowpage(pageN);
		totalDAO total=new totalDAOImpl();
		Map map1=new HashedMap();
		map1.put("dateA",dateA);
		map1.put("dateB",dateB);
		list=total.select(map1,page1);
		usermap=total.find(map1);
        this.page=page1;
        this.map=map1;
    	this.target="/module/customerTotal/CustomerTotal.jsp";
    	return "success";
    }
    
    
    
	public Map getUsermap() {
		return usermap;
	}



	public void setUsermap(Map usermap) {
		this.usermap = usermap;
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


	public Map getMap() {
		return map;
	}

	public void setMap(Map map) {
		this.map = map;
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
    
}
