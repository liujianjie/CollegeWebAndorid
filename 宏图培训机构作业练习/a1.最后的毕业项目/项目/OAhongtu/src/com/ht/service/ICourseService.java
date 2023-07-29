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
	//��¼
	public Emp findlogin(long password);
	public Student findlogin1(long password);
	//�γ̹����б���ʾ
	public List listcourse();
	//�γ̹������
	public boolean addcourse(Course course);
	//�γ̹��� ȥ�޸�
	public Course toupdcou(long couid);
	//�γ̹��� �޸�
	public boolean updcourse(Course course);
	//�γ̹���ɾ��
	public boolean delcourse(Course course);
	//�γ̹����ѯ������
	public Course getcourse(Serializable couid);
	
	//�γ̽����б���ʾ
	public List listcourseplan(long empid);
	public List listcourseplan();
	//��ѯԱ��
	public List listemp();
	//��ѯ�༶
	public List listclass();
	//��ѯѧ��
	public List liststudent();
	//��ѯ���
//	public List listyear();
	//�γ̽������
	public boolean addcourseplan(Courseplan courseplan);
	//�γ̽��ȹ��� ȥ�޸�
	public Courseplan toupdcp(long cpid);
	//�γ̽��ȹ��� �޸�
	public boolean updcp(Courseplan courseplan);
	//�γ̽���ɾ��
	public boolean delcourseplan(Courseplan courseplan);
	
	
	//��ѯ�����µ�Ա��
	public List deptemp();
	//��ѯ����
	public List listdept();
	//���ֻ��б���ʾ
	public List listdis();
	//���ֻ����
	public boolean adddis(Discuss discuss);
	//���ֻ� ȥ�޸�
	public Discuss toupddis(long disid);
	//���ֻ� �޸�
	public boolean upddis(Discuss discuss);
	//���ֻ�ɾ��
	public boolean deldis(Discuss discuss);
	
	//��Ա�����б���ʾ
	public List listfed();
	public List listfed1(long empid);
	//��Ա�������
	public boolean addfed(Fed fed);
	//������
	public boolean addyear(Saveyear syear);
	//��Ա�������� ȥ�޸�
	public Fed toupdfed(long fedid);
	//��Ա���� �޸�
	public boolean updfed(Fed fed);
	//��Ա����ɾ��
	public boolean delfed(Fed fed);
	
	//ѧ����Ա�����б���ʾ
	public List liststufed(long stuclassid);
	
	public List isfeed(long fdid,long stuid);
	public List findstufed(long fdid);
	
	//��Ա������
	public List liststu();
	//����id����Ա������
	public Emp findemp(long eid);
	//����id����fed�����
	public Fed findfed(long fedid);
	//����id����feed�����
	public Feedback findfeed(long fid);
	
	public List findfeed1(long feedyear,long feedmonth,long empid,long classid);
	//�ύ�����󱣴��ֶ�
	public boolean savefeed(Feedback feedback);
	//����id����class�����
	public Classes findclass(long classid);
	//����id����Student�����
	public Student findstudent(long stuid);
	//���ݵ�ǰ��¼�û�id��ѯ�ѷ�����
	public List findteacher(long eid);
	//�޸�fed�е�numֵ
	public boolean updnum(long fedid);
	
	//ֵ���б���ʾ
	public List listduty();
	public List mydutylist(long id);
	//ֵ�����
	public boolean addduty(Dutys dutys);
	//ֵ�� ȥ�޸�
	public Dutys toupdduty(long dsid);
	//ֵ�� �޸�
	public boolean updduty(Dutys dutys);
	//ֵ��ɾ��
	public boolean delduty(Dutys dutys);
	//����Ա��id���������̵İ༶
	public List findclassbyid(long empid);
	//��ʱ�����ķ���״̬
	public boolean changestate(Date da);
}
