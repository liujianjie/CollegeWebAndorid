package com.ht.action;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.ht.service.IApplyservice;
import com.ht.vo.Emp;
import com.ht.vo3.Applystudent;
import com.ht.vo3.Applystudent2;


public class ApplyStudentAction extends com.ht.common.BaseAction {
	IApplyservice ia=(IApplyservice)getService("aService");
	
	private Applystudent st;
	
	private String newlocation;
	
//招生名单 列表
     public String list1(){
    	 System.out.println("****************");
         List list=ia.appList();	 
         System.out.println(list.size());
    	 ToRequest("list",list);
    	 return "totable";
    	 
     }
     
     //点击预定报名
     public String a1(){
    	 System.out.println("进来了a1");
    	 
    	 HttpServletRequest req=ServletActionContext.getRequest();
    	 String id=req.getParameter("id");
    	 System.out.println("id的值： "+id);
    	 
//    	List list=  ia.check(Integer.parseInt(id));
//    	Map map=(Map)list.get(0);
//    	String statu=map.get("INTENSTATUS").toString();
//    	System.out.println("状态的值："+statu);
    	
//    	if(statu.equals("未知")){
    		 Applystudent  stu=ia.getStuInfoById(Long.parseLong(id));
	    	 System.out.println("属性：  "+stu.getIntenid());
	    	 
	    	 Applystudent2 stu2=new Applystudent2();
	    	 stu2.setIntenid2(stu.getIntenid());
	    	 stu2.setIntenname2(stu.getIntenname());
	    	 stu2.setIntensch2(stu.getIntensch());
	    	 stu2.setIntensex2(stu.getIntensex());
	    	 stu2.setIntenbir2(stu.getIntenbir());
	    	 stu2.setIntenfat2(stu.getIntenfat());
	    	 stu2.setIntenfatel2(stu.getIntenfatel());
	    	 stu2.setIntenaddr2(stu.getIntenaddr());
	    	 stu2.setIntplace(stu.getIntplace());
	    	 stu2.setIntemail2(stu.getIntemail());
	         //默认招生老师是周老师
	    	 Emp emp=(Emp)req.getSession().getAttribute("teacher");
	    	 
	    	 if(req.getSession().getAttribute("teacher")==null){
	    		 System.out.println("先登陆");
	    		 return null;
	    	 }
	    	 
	    	 stu2.setIntetea2(emp.getEname());
	    	 
	    	 	boolean bln1=ia.addStuInfo(stu2);
		    	 if(bln1){
		    		 System.out.println("添加成功");
		    	 }else{
		    		 System.out.println("添加失败");
		    	 }
		    	 
		    	 boolean bln2=ia.updStatus1(Long.parseLong(id));
		    	 if(bln2){
		    		 System.out.println("更改成功");
		    	 }else{
		    		 System.out.println("更改失败");
		    	 }

    	
    		return "flush_table";
    	 
     	}
     
         //点击不预定
         public String a2(){
    	 System.out.println("进来了a2");
    	 HttpServletRequest req=ServletActionContext.getRequest();
    	 String id=req.getParameter("id");
    	 
//    	 List list=  ia.check(Integer.parseInt(id));
//     	Map map=(Map)list.get(0);
//     	String statu=map.get("INTENSTATUS").toString();
//     	System.out.println("状态的值："+statu);
     	
//     	if(statu.equals("未知")){
     		 boolean bln=ia.updStatus2(Long.parseLong(id));
        	 if(bln){
        		 System.out.println("更改成功");
        	 }else{
        		 System.out.println("更改失败");
        	 }
//     	}
    	 
    	 return "flush_table";
    }
     
         
         
   //预定报名 列表
     public String list2(){
    	 System.out.println("进来list2");
          List list=ia.appList2();	 
          System.out.println(list.size());
    	  ToRequest("list",list);
    	  return "totable2";
        }
     
     //添加学生信息
     public String add(){
    	 System.out.println("学生姓名： "+st.getIntenname());
    	 st.setIntplace(newlocation);
    	 st.setIntenstatus("未知");
    	 System.out.println("学生籍贯： "+st.getIntplace());
    	 boolean bln=ia.addStu(st);
    	 if (bln) {
 			System.out.println("添加成功");
 			return "flush_table";
 		} else {
 			System.out.println("添加失败");
 		}
    	 return null;
     }
     
     
     
      public Applystudent getSt() {
		return st;
	}

	public void setSt(Applystudent st) {
		this.st = st;
	}

	public String getNewlocation() {
		return newlocation;
	}

	public void setNewlocation(String newlocation) {
		this.newlocation = newlocation;
	}
  }
