package com.dc.entity;

import java.util.HashMap;
import java.util.List;

public class PageEntity {
	private int nowpage;//��ǰ�ڼ�ҳ
	private int  pagecount=6;//ÿҳ������
	private List<HashMap> pagelist;//�洢��ǰҳ��Ϣ
	private int sumpage;//��ҳ��
	private int sumcount;//������
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
