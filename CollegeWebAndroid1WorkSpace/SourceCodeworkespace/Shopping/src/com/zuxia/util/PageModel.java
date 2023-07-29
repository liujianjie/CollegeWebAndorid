package com.zuxia.util;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 分页JavaBean
 */
public class PageModel<T> implements Serializable{
	
	private int pageSize=5; //每页显示的条数 
	private int pageNo = 1; //当前页码
	private int totalRecords = 0; //总记录数
	private ArrayList<T> data=null; //当前页的数据 
	
	/**
	 * 设置每页显示记录的条数
	 */
	public void setPageSize(int size){
		this.pageSize = size;
	}
	
	/**
	 * 获取每页显示的记录的条数
	 */
	public int getPageSize(){
		return this.pageSize;
	}
	
	/**
	 * 设置当前页的页码
	 */
	public void setPageNo(int no){
		this.pageNo = no;
	}
	
	/**
	 * 获取当前页的页码
	 */
	public int getPageNo(){
		return this.pageNo;
	}
	
	/**
	 * 获取总页数
	 */
	public int getTotalPages(){
		int temp = (totalRecords+pageSize-1)/pageSize;
		return temp <= 0 ? 1 : temp;
//		if(totalRecords%pageSize==0){
//			return totalRecords/pageSize;
//		}else{
//			return totalRecords/pageSize + 1;
//		}
	}
	
	/**
	 * 设置记录总数
	 */
	public void setTotalRecords(int totalRecords){
		this.totalRecords = totalRecords;
	}
	
	/**
	 * 获取记录总数
	 */
	public int getTotalRecords(){
		return this.totalRecords;
	}
	
	/**
	 * 设置当前页的数据
	 */
	public void setData(ArrayList<T> data){
		this.data = data;
	}
	
	/**
	 * 获取当前页的数据
	 */
	public ArrayList<T> getData(){
		return this.data;
	}
	
	/**
	 * 获取首页页码
	 */
	public int getIndexPageNo(){
		return 1;
	}
	
	/**
	 * 获取尾页页码
	 */
	public int getLastPageNo(){
		return this.getTotalPages();
	}
	
	/**
	 * 获取上一页页码
	 */
	public int getPreviousPageNo(){
		if(this.pageNo <= 1){
			return 1;
		}else{
			return this.pageNo-1;
		}
	}
	
	/**
	 * 获取下一页页码
	 */
	public int getNextPageNo(){
		if(this.pageNo >= this.getTotalPages()){
			return this.getTotalPages();
		}else{
			return this.pageNo+1;
		}
	}
}
