package com.dc.controller.repertory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.dc.dao.repertory.RepertoryDao;
import com.dc.dao.repertory.RepertoryDaoImpl;
import com.dc.entity.PageEntity;
import com.dc.util.StringUtil;

public class Repertory {
	private List listRepertory;		//接受查询数组
	private String caterialname;	//材料名称
	private String sum;				//材料总数量
	private String remainder;		//材料剩余库存数量
	private PageEntity page;		//实现分页
	private Map map;				//map数组
	private String nowpage;			//当前页数
	private String repertory;		//链接Repertory.jsp的类
	private String pageN;
	private String sumpage;
	/**
	 * 查询库存判断信息
	 * */
	public String selectRepertory(){
		int pageN=0;
		if(StringUtil.checkNotNull(nowpage)){
			pageN=Integer.parseInt(nowpage);
		}else{
			pageN=1;
		}
		PageEntity pageEntity=new PageEntity();
		pageEntity.setNowpage(pageN);
		RepertoryDao rep=new RepertoryDaoImpl();
		
		map=new HashMap();
		map.put("caterialname",caterialname);
		listRepertory=rep.findcaterial(map, pageEntity);
		this.page=pageEntity;
		/*System.out.println(pageEntity);*/
		this.repertory="/module/repertory/Repertory.jsp";
		return "select";
	}

	public String getSumpage() {
		return sumpage;
	}

	public void setSumpage(String sumpage) {
		this.sumpage = sumpage;
	}

	public String getPageN() {
		return pageN;
	}

	public void setPageN(String pageN) {
		this.pageN = pageN;
	}

	public List getListRepertory() {
		return listRepertory;
	}

	public void setListRepertory(List listRepertory) {
		this.listRepertory = listRepertory;
	}

	public String getCaterialname() {
		return caterialname;
	}

	public void setCaterialname(String caterialname) {
		this.caterialname = caterialname;
	}

	public String getSum() {
		return sum;
	}

	public void setSum(String sum) {
		this.sum = sum;
	}

	public String getRemainder() {
		return remainder;
	}

	public void setRemainder(String remainder) {
		this.remainder = remainder;
	}

	public PageEntity getPage() {
		return page;
	}

	public void setPage(PageEntity page) {
		this.page = page;
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

	public String getRepertory() {
		return repertory;
	}

	public void setRepertory(String repertory) {
		this.repertory = repertory;
	}
	
	
	
}
