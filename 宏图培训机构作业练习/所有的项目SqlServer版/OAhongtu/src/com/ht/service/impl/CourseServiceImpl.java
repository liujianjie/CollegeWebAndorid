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
	//�γ����
	public boolean addcourse(Course course) {
		// TODO Auto-generated method stub
		return addObj(course);
	}
//�γ̹����б�
	public List listcourse() {
		// TODO Auto-generated method stub
		return list("from Course");
	}
	//�γ̹��� ȥ�޸�
	public Course toupdcou(long couid) {
		// TODO Auto-generated method stub
		return (Course)getObj(Course.class, couid);
	}
	//�γ̹��� �޸�
	public boolean updcourse(Course course) {
		// TODO Auto-generated method stub
		return updObj(course);
	}
	//�γ�ɾ��	
	public boolean delcourse(Course course) {
		// TODO Auto-generated method stub
		return delObj(course);
	}
	//�γ̲������
	public Course getcourse(Serializable couid) {
		return (Course) getObj(Course.class,couid);
	}
	
	
	//�γ̽����б���ʾ
	public List listcourseplan(long empid) {
		// TODO Auto-generated method stub
		return listbysql("select * from courseplan where empid = "+empid);
	}
	
	public List listcourseplan() {
		// TODO Auto-generated method stub
		return list("from Courseplan");
	}
	//��ѯԱ��
	public List listemp() {
		// TODO Auto-generated method stub
		return list("from Emp");
	}
	//�γ̽������
	public boolean addcourseplan(Courseplan courseplan) {
		// TODO Auto-generated method stub
		return addObj(courseplan);
	}
	//�γ̽��ȹ��� ȥ�޸�
	public Courseplan toupdcp(long cpid) {
		// TODO Auto-generated method stub
		return (Courseplan)getObj(Courseplan.class, cpid);
	}
	//�γ̽��ȹ��� �޸�
	public boolean updcp(Courseplan courseplan) {
		// TODO Auto-generated method stub
		return updObj(courseplan);
	}
	//�γ̽���ɾ��
	public boolean delcourseplan(Courseplan courseplan) {
		// TODO Auto-generated method stub
		return delObj(courseplan);
	}
	
	
	//��ѯ�����µ�Ա��
	public List deptemp(){
		return listbysql("select * from emp e,dept d where e.did=d.did");
	}
	//��ѯ����
	public List listdept(){
		return list("from Dept");
	}
	//��ѯ���
//	public List listyear(){
//		return list("from Saveyear");
//	}
	//���ֻ��б���ʾ
	public List listdis() {
		// TODO Auto-generated method stub
		return list("from Discuss");
	}
	//���ֻ����
	public boolean adddis(Discuss discuss) {
		// TODO Auto-generated method stub
		return addObj(discuss);
	}
	//���ֻ� ȥ�޸�
	public Discuss toupddis(long disid) {
		// TODO Auto-generated method stub
		return (Discuss)getObj(Discuss.class, disid);
	}
	//���ֻ� �޸�
	public boolean upddis(Discuss discuss) {
		// TODO Auto-generated method stub
		return updObj(discuss);
	}
	//���ֻ�ɾ��
	public boolean deldis(Discuss discuss) {
		// TODO Auto-generated method stub
		return delObj(discuss);
	}
	
	//��Ա�����б���ʾ
	public List listfed() {
		// TODO Auto-generated method stub
		return list("from Fed");
	}
	
	//��Ա�����б���ʾ
	public List listfed1(long empid) {
		// TODO Auto-generated method stub
		return listbysql("select * from fed where fedstate=1 and empid = "+empid);
	}
	
	//��Ա�������
	public boolean addfed(Fed fed) {
		// TODO Auto-generated method stub
		return addObj(fed);
	}
	//������
	public boolean addyear(Saveyear syear) {
		// TODO Auto-generated method stub
		return addObj(syear);
	}
	//��Ա����ɾ��
	public boolean delfed(Fed fed) {
		// TODO Auto-generated method stub
		return delObj(fed);
	}
//	��Ա�������� ȥ�޸�
	public Fed toupdfed(long fedid) {
		// TODO Auto-generated method stub
		return (Fed)getObj(Fed.class, fedid);
	}
	//��Ա�������� �޸�
	public boolean updfed(Fed fed) {
		// TODO Auto-generated method stub
		return updObj(fed);
	}
	
	
	//ѧ����Ա�����б���ʾ
	public List liststufed(long stuclassid) {
		// TODO Auto-generated method stub
		return listbysql("select * from fed where fedstate=0 and classid = "+stuclassid);
	}
	//��Ա������
	public List liststu() {
		// TODO Auto-generated method stub
		return list(" from Feedback");
	}
	//����id����Ա������
	public Emp findemp(long eid) {
		// TODO Auto-generated method stub
		return (Emp)getObj(Emp.class,eid);
	}
	//����id����fed�����
	public Fed findfed(long fedid) {
		// TODO Auto-generated method stub
		return (Fed)getObj(Fed.class,fedid);
	}
	
	//�ύ�����󱣴��ֶ�
	public boolean savefeed(Feedback feedback) {
		// TODO Auto-generated method stub
		return addObj(feedback);
	}
	//�޸�fed�е�numֵ
	public boolean updnum(long fedid){
		return executesql("update fed set num=1 where fedid="+fedid);
	}
	//��ѯ�༶
	public List listclass() {
		// TODO Auto-generated method stub
		return  list("from Classes");
	}
	
	
	//ֵ�����
	public boolean addduty(Dutys dutys) {
		// TODO Auto-generated method stub
		return addObj(dutys);

	}
	//ֵ���б�ɾ��
	public boolean delduty(Dutys dutys) {
		// TODO Auto-generated method stub
		return delObj(dutys);
	}
	//ֵ���б���ʾ
	public List listduty() {
		// TODO Auto-generated method stub
		return list("from Dutys");
	}
	//ֵ�� ȥ�޸�
	public Dutys toupdduty(long dsid) {
		// TODO Auto-generated method stub
		return (Dutys)getObj(Dutys.class, dsid);
	}
	//ֵ���޸�
	public boolean updduty(Dutys dutys) {
		// TODO Auto-generated method stub
		return updObj(dutys);
	}
	//��¼
	public Emp findlogin(long password) {
		return (Emp)getObj(Emp.class, password);
	}
	//��¼
	public Student findlogin1(long password) {
		return (Student)getObj(Student.class, password);
	}
	//����id����class�����
	public Classes findclass(long classid) {
		// TODO Auto-generated method stub
		return (Classes)getObj(Classes.class, classid);
	}
	//��ѯѧ��
	public List liststudent() {
		// TODO Auto-generated method stub
		return list("from Student");
	}
	//����id����feed�����
	public Feedback findfeed(long fid) {
		// TODO Auto-generated method stub
		return (Feedback)getObj(Feedback.class, fid);
	}
	//���ݰ༶id�ȶ���ֶβ���feed
	public List findfeed1(long feedyear,long feedmonth,long empid,long classid) {
		// TODO Auto-generated method stub
		return listbysql("select * from feedback where feedyear = "+feedyear+" and feedmonth = "+feedmonth+" and empid = "+empid+" and cid = "+classid);
	}
	//����id����Student�����
	public Student findstudent(long stuid) {
		// TODO Auto-generated method stub
		return (Student)getObj(Student.class, stuid);
	}
	//���ݵ�ǰ��¼�û�id��ѯ�ѷ��������Feedback
	public List findteacher(long eid) {
		// TODO Auto-generated method stub
		return listbysql("select * from feedback where empid="+eid);
	}
	public List mydutylist(long id) {
		// TODO Auto-generated method stub
		return listbysql("select * from dutys where dsempid="+id);
	}
	//����Ա��id���������̵İ༶
	public List findclassbyid(long empid) {
		// TODO Auto-generated method stub
		return  listbysql("select * from classes where empteach="+empid+" or empteachs = "+empid);
	}
	//��ʱ�����ķ���״̬
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
