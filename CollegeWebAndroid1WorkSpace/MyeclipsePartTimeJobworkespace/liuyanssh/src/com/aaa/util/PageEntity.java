package com.aaa.util;

import java.util.List;

//����ҳ��ʹ�õĵ��������ݷ�װ����ǰ����,�������Ǵ��ҳ����Ҫ����
public class PageEntity {
   private Integer pageSize=8;//ÿҳ��ʾ����
   private Integer nowPage=1;//��ǰҳ��Ĭ��Ϊ��һҳ
   private Integer totalCount;//������
   private Integer totalPage;//��ҳ��
   private List list;//ÿҳ��ʾ�����ݼ���
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
