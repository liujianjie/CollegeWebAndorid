package com.ht.service.impl;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.ht.common.Hibernate_Dao;
import com.ht.service.ICourseService;
import com.ht.vo.Emp;
import com.ht.vo2.Course;
import com.ht.vo2.Courseplan;
import com.ht.vo2.Discuss;
import com.ht.vo2.Dutys;
import com.ht.vo2.Fed;
import com.ht.vo2.Feedback;
import com.ht.vo2.Saveyear;
import com.ht.vo5.Classes;
import com.ht.vo5.Student;

public class CourseServiceImpl extends Hibernate_Dao implements ICourseService{
	//课程添加
	public boolean addcourse(Course course) {
		// TODO Auto-generated method stub
		return addObj(course);
	}
//课程管理列表
	public List listcourse() {
		// TODO Auto-generated method stub
		return list("from Course");
	}
	//课程管理 去修改
	public Course toupdcou(long couid) {
		// TODO Auto-generated method stub
		return (Course)getObj(Course.class, couid);
	}
	//课程管理 修改
	public boolean updcourse(Course course) {
		// TODO Auto-generated method stub
		return updObj(course);
	}
	//课程删除	
	public boolean delcourse(Course course) {
		// TODO Auto-generated method stub
		return delObj(course);
	}
	//课程查出。。
	public Course getcourse(Serializable couid) {
		return (Course) getObj(Course.class,couid);
	}
	
	
	//课程进度列表显示
	public List listcourseplan(long empid) {
		// TODO Auto-generated method stub
		return listbysql("select * from courseplan where empid = "+empid);
	}
	
	public List listcourseplan() {
		// TODO Auto-generated method stub
		return list("from Courseplan");
	}
	//查询员工
	public List listemp() {
		// TODO Auto-generated method stub
		return list("from Emp");
	}
	//课程进度添加
	public boolean addcourseplan(Courseplan courseplan) {
		// TODO Auto-generated method stub
		return addObj(courseplan);
	}
	//课程进度管理 去修改
	public Courseplan toupdcp(long cpid) {
		// TODO Auto-generated method stub
		return (Courseplan)getObj(Courseplan.class, cpid);
	}
	//课程进度管理 修改
	public boolean updcp(Courseplan courseplan) {
		// TODO Auto-generated method stub
		return updObj(courseplan);
	}
	//课程进度删除
	public boolean delcourseplan(Courseplan courseplan) {
		// TODO Auto-generated method stub
		return delObj(courseplan);
	}
	
	
	//查询部门下的员工
	public List deptemp(){
		return listbysql("select * from emp e,dept d where e.did=d.did");
	}
	//查询部门
	public List listdept(){
		return list("from Dept");
	}
	//查询年份
//	public List listyear(){
//		return list("from Saveyear");
//	}
	//研讨会列表显示
	public List listdis() {
		// TODO Auto-generated method stub
		return list("from Discuss");
	}
	//研讨会添加
	public boolean adddis(Discuss discuss) {
		// TODO Auto-generated method stub
		return addObj(discuss);
	}
	//研讨会 去修改
	public Discuss toupddis(long disid) {
		// TODO Auto-generated method stub
		return (Discuss)getObj(Discuss.class, disid);
	}
	//研讨会 修改
	public boolean upddis(Discuss discuss) {
		// TODO Auto-generated method stub
		return updObj(discuss);
	}
	//研讨会删除
	public boolean deldis(Discuss discuss) {
		// TODO Auto-generated method stub
		return delObj(discuss);
	}
	
	//教员反馈列表显示
	public List listfed() {
		// TODO Auto-generated method stub
		return list("from Fed");
	}
	
	//教员反馈列表显示
	public List listfed1(long empid) {
		// TODO Auto-generated method stub
		return listbysql("select * from fed where fedstate=1 and empid = "+empid);
	}
	
	//教员反馈添加
	public boolean addfed(Fed fed) {
		// TODO Auto-generated method stub
		return addObj(fed);
	}
	//年份添加
	public boolean addyear(Saveyear syear) {
		// TODO Auto-generated method stub
		return addObj(syear);
	}
	//教员反馈删除
	public boolean delfed(Fed fed) {
		// TODO Auto-generated method stub
		return delObj(fed);
	}
//	教员反馈管理 去修改
	public Fed toupdfed(long fedid) {
		// TODO Auto-generated method stub
		return (Fed)getObj(Fed.class, fedid);
	}
	//教员反馈管理 修改
	public boolean updfed(Fed fed) {
		// TODO Auto-generated method stub
		return updObj(fed);
	}
	
	
	//学生教员反馈列表显示
	public List liststufed(long stuclassid) {
		// TODO Auto-generated method stub
		return listbysql("select * from fed where fedstate=0 and classid = "+stuclassid);
	}
	//教员反馈表
	public List liststu() {
		// TODO Auto-generated method stub
		return list(" from Feedback");
	}
	//根据id查找员工对象
	public Emp findemp(long eid) {
		// TODO Auto-generated method stub
		return (Emp)getObj(Emp.class,eid);
	}
	//根据id查找fed表对象
	public Fed findfed(long fedid) {
		// TODO Auto-generated method stub
		return (Fed)getObj(Fed.class,fedid);
	}
	
	//提交反馈后保存字段
	public boolean savefeed(Feedback feedback) {
		// TODO Auto-generated method stub
		return addObj(feedback);
	}
	//修改fed中的num值
	public boolean updnum(long fedid){
		return executesql("update fed set num=1 where fedid="+fedid);
	}
	//查询班级
	public List listclass() {
		// TODO Auto-generated method stub
		return  list("from Classes");
	}
	
	
	//值班添加
	public boolean addduty(Dutys dutys) {
		// TODO Auto-generated method stub
		return addObj(dutys);

	}
	//值班列表删除
	public boolean delduty(Dutys dutys) {
		// TODO Auto-generated method stub
		return delObj(dutys);
	}
	//值班列表显示
	public List listduty() {
		// TODO Auto-generated method stub
		return list("from Dutys");
	}
	//值班 去修改
	public Dutys toupdduty(long dsid) {
		// TODO Auto-generated method stub
		return (Dutys)getObj(Dutys.class, dsid);
	}
	//值班修改
	public boolean updduty(Dutys dutys) {
		// TODO Auto-generated method stub
		return updObj(dutys);
	}
	//登录
	public Emp findlogin(long password) {
		return (Emp)getObj(Emp.class, password);
	}
	//登录
	public Student findlogin1(long password) {
		return (Student)getObj(Student.class, password);
	}
	//根据id查找class表对象
	public Classes findclass(long classid) {
		// TODO Auto-generated method stub
		return (Classes)getObj(Classes.class, classid);
	}
	//查询学生
	public List liststudent() {
		// TODO Auto-generated method stub
		return list("from Student");
	}
	//根据id查找feed表对象
	public Feedback findfeed(long fid) {
		// TODO Auto-generated method stub
		return (Feedback)getObj(Feedback.class, fid);
	}
	//根据班级id等多个字段查找feed
	public List findfeed1(long feedyear,long feedmonth,long empid,long classid) {
		// TODO Auto-generated method stub
		return listbysql("select * from feedback where feedyear = "+feedyear+" and feedmonth = "+feedmonth+" and empid = "+empid+" and cid = "+classid);
	}
	//根据id查找Student表对象
	public Student findstudent(long stuid) {
		// TODO Auto-generated method stub
		return (Student)getObj(Student.class, stuid);
	}
	//根据当前登录用户id查询已反馈表对象Feedback
	public List findteacher(long eid) {
		// TODO Auto-generated method stub
		return listbysql("select * from feedback where empid="+eid);
	}
	public List mydutylist(long id) {
		// TODO Auto-generated method stub
		return listbysql("select * from dutys where dsempid="+id);
	}
	//根据员工id查找其所教的班级
	public List findclassbyid(long empid) {
		// TODO Auto-generated method stub
		return  listbysql("select * from classes where empteach="+empid+" or empteachs = "+empid);
	}
	//定时器更改反馈状态
	public boolean changestate(Date da){
		return executesql("update fed set fedstate=1 where  fedendtime < to_date('"+da.toLocaleString()+"','yyyy-mm-dd hh24:mi:ss')");
	}
	public List isfeed(long fdid, long stuid) {
		// TODO Auto-generated method stub
		return listbysql("select * from feedback where fdid="+fdid+" and stuid="+stuid+"");
	}
	public List findstufed(long fdid) {
		// TODO Auto-generated method stub
		return listbysql("select * from fed where fedid="+fdid);
	}
	
}
