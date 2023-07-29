package com.dc.controller.order;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.dc.dao.order.CountDAO;
import com.dc.dao.order.CountDAOImpl;
import com.dc.util.StringUtil;

public class OrderCount {
	private List list1;
	private List list2;
	private List list3;
	private List list4;
	private String date1;
	private String date2;
	private String date3;
	public String findAll(){
		CountDAO c=new CountDAOImpl();
		if(StringUtil.checkNotNull(date3)){
			if(date3.equals("1")){
				Date date=new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date0=sdf.format(date);
				date2=date0;
				/*String[]a=date0.split("-");
				int n=Integer.parseInt(a[2])-1;
				if(n<10){
					a[2]="0"+n;
				}else{
					a[2]=Integer.toString(n);
				}*/
				date1=date0;
				
			}
			if(date3.equals("30")){
				Date date=new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String date0=sdf.format(date);
				date2=date0;
				String[]a=date0.split("-");
				int n=Integer.parseInt(a[1])-1;
				if(n<10){
					a[1]="0"+n;
				}else{
					a[1]=Integer.toString(n);
				}
				date1=a[0]+"-"+a[1]+"-"+a[2];
			}
		}
		list1=c.count1(date1,date2);
		
		list2=c.count2(date1,date2);
		
		
		return "list";
	}
	public List getList1() {
		return list1;
	}
	public void setList1(List list1) {
		this.list1 = list1;
	}
	public List getList2() {
		return list2;
	}
	public void setList2(List list2) {
		this.list2 = list2;
	}
	public String getDate1() {
		return date1;
	}
	public void setDate1(String date1) {
		this.date1 = date1;
	}
	public String getDate2() {
		return date2;
	}
	public void setDate2(String date2) {
		this.date2 = date2;
	}
	public List getList3() {
		return list3;
	}
	public void setList3(List list3) {
		this.list3 = list3;
	}
	public String getDate3() {
		return date3;
	}
	public void setDate3(String date3) {
		this.date3 = date3;
	}
	public List getList4() {
		return list4;
	}
	public void setList4(List list4) {
		this.list4 = list4;
	}
	
	
}
