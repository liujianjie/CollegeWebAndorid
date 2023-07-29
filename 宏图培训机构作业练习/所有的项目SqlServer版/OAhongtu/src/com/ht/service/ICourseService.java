package com.ht.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

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

public interface ICourseService {
	//登录
	public Emp findlogin(long password);
	public Student findlogin1(long password);
	//课程管理列表显示
	public List listcourse();
	//课程管理添加
	public boolean addcourse(Course course);
	//课程管理 去修改
	public Course toupdcou(long couid);
	//课程管理 修改
	public boolean updcourse(Course course);
	//课程管理删除
	public boolean delcourse(Course course);
	//课程管理查询。。。
	public Course getcourse(Serializable couid);
	
	//课程进度列表显示
	public List listcourseplan(long empid);
	public List listcourseplan();
	//查询员工
	public List listemp();
	//查询班级
	public List listclass();
	//查询学生
	public List liststudent();
	//查询年份
//	public List listyear();
	//课程进度添加
	public boolean addcourseplan(Courseplan courseplan);
	//课程进度管理 去修改
	public Courseplan toupdcp(long cpid);
	//课程进度管理 修改
	public boolean updcp(Courseplan courseplan);
	//课程进度删除
	public boolean delcourseplan(Courseplan courseplan);
	
	
	//查询部门下的员工
	public List deptemp();
	//查询部门
	public List listdept();
	//研讨会列表显示
	public List listdis();
	//研讨会添加
	public boolean adddis(Discuss discuss);
	//研讨会 去修改
	public Discuss toupddis(long disid);
	//研讨会 修改
	public boolean upddis(Discuss discuss);
	//研讨会删除
	public boolean deldis(Discuss discuss);
	
	//教员反馈列表显示
	public List listfed();
	public List listfed1(long empid);
	//教员反馈添加
	public boolean addfed(Fed fed);
	//年份添加
	public boolean addyear(Saveyear syear);
	//教员反馈管理 去修改
	public Fed toupdfed(long fedid);
	//教员反馈 修改
	public boolean updfed(Fed fed);
	//教员反馈删除
	public boolean delfed(Fed fed);
	
	//学生教员反馈列表显示
	public List liststufed(long stuclassid);
	
	public List isfeed(long fdid,long stuid);
	public List findstufed(long fdid);
	
	//教员反馈表
	public List liststu();
	//根据id查找员工对象
	public Emp findemp(long eid);
	//根据id查找fed表对象
	public Fed findfed(long fedid);
	//根据id查找feed表对象
	public Feedback findfeed(long fid);
	
	public List findfeed1(long feedyear,long feedmonth,long empid,long classid);
	//提交反馈后保存字段
	public boolean savefeed(Feedback feedback);
	//根据id查找class表对象
	public Classes findclass(long classid);
	//根据id查找Student表对象
	public Student findstudent(long stuid);
	//根据当前登录用户id查询已反馈表
	public List findteacher(long eid);
	//修改fed中的num值
	public boolean updnum(long fedid);
	
	//值班列表显示
	public List listduty();
	public List mydutylist(long id);
	//值班添加
	public boolean addduty(Dutys dutys);
	//值班 去修改
	public Dutys toupdduty(long dsid);
	//值班 修改
	public boolean updduty(Dutys dutys);
	//值班删除
	public boolean delduty(Dutys dutys);
	//根据员工id查找其所教的班级
	public List findclassbyid(long empid);
	//定时器更改反馈状态
	public boolean changestate(Date da);
}
