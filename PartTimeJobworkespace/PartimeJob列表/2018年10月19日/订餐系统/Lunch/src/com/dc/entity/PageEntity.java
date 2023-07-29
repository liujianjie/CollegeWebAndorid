package com.dc.entity;

import java.util.HashMap;
import java.util.List;

public class PageEntity {
	private int nowpage;//当前第几页
	private int  pagecount=6;//每页多少条
	private List<HashMap> pagelist;//存储当前页信息
	private int sumpage;//总页数
	private int sumcount;//总条数
	public List<HashMap> getPagelist() {
		return pagelist;
	}
	public void setPagelist(List<HashMap> pagelist) {
		this.pagelist = pagelist;
	}
	public int getNowpage() {
		return nowpage;
	}
	public void setNowpage(int nowpage) {
		this.nowpage = nowpage;
	}
	public int getPagecount() {
		return pagecount;
	}
	public void setPagecount(int pagecount) {
		this.pagecount = pagecount;
	}
	public int getSumpage() {
		return sumpage;
	}
	public void setSumpage(int sumpage) {
		this.sumpage = sumpage;
	}
	public int getSumcount() {
		return sumcount;
	}
	public void setSumcount(int sumcount) {
		this.sumcount = sumcount;
	}
	
}
