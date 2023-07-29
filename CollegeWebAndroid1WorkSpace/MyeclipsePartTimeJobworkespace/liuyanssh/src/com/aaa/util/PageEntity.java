package com.aaa.util;

import java.util.List;

//将分页所使用的到所有数据封装到当前类中,帮助我们存分页的主要数据
public class PageEntity {
   private Integer pageSize=8;//每页显示条数
   private Integer nowPage=1;//当前页，默认为第一页
   private Integer totalCount;//总条数
   private Integer totalPage;//总页数
   private List list;//每页显示的数据集合
public Integer getPageSize() {
	return pageSize;
}
public void setPageSize(Integer pageSize) {
	this.pageSize = pageSize;
}
public Integer getNowPage() {
	return nowPage;
}
public void setNowPage(Integer nowPage) {
	this.nowPage = nowPage;
}
public Integer getTotalCount() {
	return totalCount;
}
public void setTotalCount(Integer totalCount) {
	this.totalCount = totalCount;
}
public Integer getTotalPage() {
	return totalPage;
}
public void setTotalPage(Integer totalPage) {
	this.totalPage = totalPage;
}
public List getList() {
	return list;
}
public void setList(List list) {
	this.list = list;
}
   
   
}
