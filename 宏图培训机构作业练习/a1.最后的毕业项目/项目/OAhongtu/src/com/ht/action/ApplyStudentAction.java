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
	
//�������� �б�
     public String list1(){
    	 System.out.println("****************");
         List list=ia.appList();	 
         System.out.println(list.size());
    	 ToRequest("list",list);
    	 return "totable";
    	 
     }
     
     //���Ԥ������
     public String a1(){
    	 System.out.println("������a1");
    	 
    	 HttpServletRequest req=ServletActionContext.getRequest();
    	 String id=req.getParameter("id");
    	 System.out.println("id��ֵ�� "+id);
    	 
//    	List list=  ia.check(Integer.parseInt(id));
//    	Map map=(Map)list.get(0);
//    	String statu=map.get("INTENSTATUS").toString();
//    	System.out.println("״̬��ֵ��"+statu);
    	
//    	if(statu.equals("δ֪")){
    		 Applystudent  stu=ia.getStuInfoById(Long.parseLong(id));
	    	 System.out.println("���ԣ�  "+stu.getIntenid());
	    	 
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
	         //Ĭ��������ʦ������ʦ
	    	 Emp emp=(Emp)req.getSession().getAttribute("teacher");
	    	 
	    	 if(req.getSession().getAttribute("teacher")==null){
	    		 System.out.println("�ȵ�½");
	    		 return null;
	    	 }
	    	 
	    	 stu2.setIntetea2(emp.getEname());
	    	 
	    	 	boolean bln1=ia.addStuInfo(stu2);
		    	 if(bln1){
		    		 System.out.println("��ӳɹ�");
		    	 }else{
		    		 System.out.println("���ʧ��");
		    	 }
		    	 
		    	 boolean bln2=ia.updStatus1(Long.parseLong(id));
		    	 if(bln2){
		    		 System.out.println("���ĳɹ�");
		    	 }else{
		    		 System.out.println("����ʧ��");
		    	 }

    	
    		return "flush_table";
    	 
     	}
     
         //�����Ԥ��
         public String a2(){
    	 System.out.println("������a2");
    	 HttpServletRequest req=ServletActionContext.getRequest();
    	 String id=req.getParameter("id");
    	 
//    	 List list=  ia.check(Integer.parseInt(id));
//     	Map map=(Map)list.get(0);
//     	String statu=map.get("INTENSTATUS").toString();
//     	System.out.println("״̬��ֵ��"+statu);
     	
//     	if(statu.equals("δ֪")){
     		 boolean bln=ia.updStatus2(Long.parseLong(id));
        	 if(bln){
        		 System.out.println("���ĳɹ�");
        	 }else{
        		 System.out.println("����ʧ��");
        	 }
//     	}
    	 
    	 return "flush_table";
    }
     
         
         
   //Ԥ������ �б�
     public String list2(){
    	 System.out.println("����list2");
          List list=ia.appList2();	 
          System.out.println(list.size());
    	  ToRequest("list",list);
    	  return "totable2";
        }
     
     //���ѧ����Ϣ
     public String add(){
    	 System.out.println("ѧ�������� "+st.getIntenname());
    	 st.setIntplace(newlocation);
    	 st.setIntenstatus("δ֪");
    	 System.out.println("ѧ�����᣺ "+st.getIntplace());
    	 boolean bln=ia.addStu(st);
    	 if (bln) {
 			System.out.println("��ӳɹ�");
 			return "flush_table";
 		} else {
 			System.out.println("���ʧ��");
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
