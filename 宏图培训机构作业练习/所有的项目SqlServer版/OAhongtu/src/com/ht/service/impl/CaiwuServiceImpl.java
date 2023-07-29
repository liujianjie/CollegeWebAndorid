package com.ht.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ht.common.Hibernate_Dao;
import com.ht.common.Hibernate_Util;
import com.ht.service.ICaiwuService;
import com.ht.vo.Emp;
import com.ht.vo4.DBConnection;
import com.ht.vo4.JiaoqingZhuangtai;

import com.ht.vo4.Salary;
import com.ht.vo4.Shouru;
import com.ht.vo4.Xuefei;
import com.ht.vo4.Zhichu;
import com.sun.org.apache.bcel.internal.generic.INEG;

public class CaiwuServiceImpl extends Hibernate_Dao implements ICaiwuService{
//����
	public List shouru_list(){
		String sql="select * from shouru";
		return listbysql(sql);
	}
	//��ʱ�����
	public List shouru_list1(String f1,String f2) {
		
		String sql="select * from shouru where 1=1";
		if(f1!=null&&!f1.equals("")){
			sql+="and s_year="+f1;
		}
		if(f2!=null&&!f2.equals("")){
			sql+="and s_month="+f2;
		}

		
		return listbysql(sql);

	}
	//����Ŀ����
	public List shouru_list2(String f3) {
		
		String sql="select * from shouru where 1=1";

		if(f3!=null&&!f3.equals("")){
			sql+="and shoufei_xiangmu="+f3;
		}

		return listbysql(sql);

	}
	//��������
	public List total_shouru() {
	// TODO Auto-generated method stub
	return listbysql("select sum(shoufei_jine) as total from shouru");
		
	}
	
	
	public boolean shouru_add(Shouru sh) {
		// TODO Auto-generated method stub
		return addObj(sh);
	}

	public Shouru selShouruById(int id) {
		// TODO Auto-generated method stub
		return (Shouru)getObj(Shouru.class, id);
	}

	public boolean shouru_upd(Shouru sh) {
		// TODO Auto-generated method stub
		return updObj(sh);
	}

	public boolean shouru_del(Shouru sh) {
		// TODO Auto-generated method stub
		return delObj(sh);
	}
	
	

	
//֧��
	///��֧���б�
	public List zhichu_list(){	//��ɸѡ
		String sql="select * from zhichu";
		return listbysql(sql);
	}
	
	public List zhichu_list1(String f1,String f2){	//��ʱ���
		System.out.println("������");
		String sql="select * from zhichu where 1=1";
		if(f1!=null&&!f1.equals("")){
			sql+="and z_year="+f1;
		}
		if(f2!=null&&!f2.equals("")){
			sql+="and z_month="+f2;
		}

		
		return listbysql(sql);
	}
	public List zhichu_list2(String f3){//����Ŀ��
		String sql="select * from zhichu where 1=1";

		if(f3!=null&&!f3.equals("")){
			sql+="and zhichu_xiangmu="+f3;
		}

		return listbysql(sql);
	}
	//����֧��
	public List total_zhichu() {
		// TODO Auto-generated method stub
		return listbysql("select sum(zhichu_jine) as total from zhichu");
	}
	
	public boolean zhichu_add(Zhichu zh) {
		// TODO Auto-generated method stub
		return addObj(zh);
	}

	public Zhichu selZhichuById(int id) {
		// TODO Auto-generated method stub
		return (Zhichu)getObj(Zhichu.class, id);
	}

	public boolean zhichu_upd(Zhichu zh) {
		// TODO Auto-generated method stub
		return updObj(zh);
	}


	public boolean zhichu_del(Zhichu zh) {
		// TODO Auto-generated method stub
		return delObj(zh);
	}

//ѧ��
	public List IsContainStu(String id1, String id2) {	//��֤
		// TODO Auto-generated method stub
		System.out.println("ʵ����");
		return listbysql("select intenid from student where classid='"+id1+"' and intenname='"+id2+"' ");
	}
	
	public List xuefei_list() {
		// TODO Auto-generated method stub
		return list("from Xuefei");
	}


	public boolean xuefei_add(Xuefei xu) {
		// TODO Auto-generated method stub
		return addObj(xu);
	}


	public List selCount(Long stuid, Long xueqi_id) {
		// TODO Auto-generated method stub
		return listbysql("select count(*) as sum_count from jiaoqing_zhuangtai where stuid='"+stuid+"' and xueqi_id='"+xueqi_id+"' ");
	}


	public List selXueqiJiaofei(Long id1,Long id2) {
		// TODO Auto-generated method stub
		
		return listbysql("select sum(jine) as sum_jine from xuefei where stuid='"+id1+"' and xueqi_id='"+id2+"' ");
	}


	public boolean jiaoqing_add(JiaoqingZhuangtai jiao) {
		// TODO Auto-generated method stub
		return addObj(jiao);
	}


	public boolean jiaoqingstatus_upd(Long id1,Long id2) {
		// TODO Auto-generated method stub
		return executesql("update jiaoqing_zhuangtai set status='�ѽ���' where stuid='"+id1+"' and xueqi_id='"+id2+"' ");
	}

	//�����״̬��
	public List jiaoqing_list(String id1,String id2) {
		// TODO Auto-generated method stub
		System.out.println("���˾��巽��");
		String sql="select * from jiaoqing_zhuangtai where 1=1";
		if(id1!=null&&id2!=null){	//ͨ���༶��ѧ�ڲ���
			sql+="and stuid in(select intenid from student t where classid='"+id1+"') and xueqi_id='"+id2+"' ";
		}
		
		return listbysql(sql);
	}
//�����а༶
	public List selAllClass() {
		// TODO Auto-generated method stub
		return listbysql("select * from classes");
	}
	
	//��ѯ����
	public List selSalaryList(String year, String month) {
		System.out.println("����ʵ���෽��");
		// TODO Auto-generated method stub
		String sql="select * from salary where 1=1  ";
		if(year!=null&&month!=null){
			sql+="and sa_year='"+year+"' and sa_month='"+month+"' ";
		}
		return listbysql(sql);
	}
	//��ѯԱ����Ϣ
	public Emp getEmpById(Long id){
		return (Emp)getObj(Emp.class, id);
	}
	//����ְ���н��
	public List selXinziByJob(String job){
		
		return listbysql("select xinzi from biaozhun where job='"+job+"' ");
	}
	
	
	
	//������Ա��
	public List selAllEmpName() {
		// TODO Auto-generated method stub
		return list("from Emp");
	}
	
	//�ֲ�ˢ��1
	public List selMoneyByYear(String year) {
		// TODO Auto-generated method stub
		return listbysql("select sum(shoufei_jine) as sum_year from shouru where s_year="+year);
	}
	//�ֲ�ˢ��2
	public List selMoneyByYearMonth(String year, String month) {
		// TODO Auto-generated method stub
		return listbysql("select sum(shoufei_jine) as sum_year from shouru where s_year='"+year+"' and s_month='"+month+"' ");
	}
	
	//�ֲ�ˢ��11
	public List selMoneyByYear2(String year) {
		// TODO Auto-generated method stub
		System.out.println("�ֲ�");
		return listbysql("select sum(zhichu_jine) as sum_year from zhichu where z_year="+year);
	}
	//�ֲ�ˢ��22
	public List selMoneyByYearMonth2(String year, String month) {
		// TODO Auto-generated method stub
		return listbysql("select sum(zhichu_jine) as sum_year from zhichu where z_year='"+year+"' and z_month='"+month+"' ");
	}
	
	//����Id��ѧ������
	public List selStuName(Long id) {
		// TODO Auto-generated method stub
		return listbysql("select intenname from student where intenid="+id);
	}
	
	//����id��༶
	public List selStuClass(Long id) {
		System.out.println("��༶ʵ����");
		// TODO Auto-generated method stub
		return listbysql("select classname from classes where classid=(select classid from student where intenid='"+id+"')");
	}
	
	
	//��֤Ա���Ƿ����
	public List checkIsJiesuan(int empid, int year, int month) {
		// TODO Auto-generated method stub
		return listbysql("select * from salary where EMPID='"+empid+"' and SA_YEAR='"+year+"' and SA_MONTH='"+month+"' ");
	}
	
	
	//��ֵ��
	public List selZhiban(int cpage,int pcount) {
		// TODO Auto-generated method stub
		return pagelistByhql("from Zhiban", (cpage-1)*pcount, pcount);
	}
	//��֪ͨ
	public List selTongzhi() {
		// TODO Auto-generated method stub
		return listbysql("select * from msg where msgstatus=1 and msgface=1");
	}
	//��ͨѶ¼
	public List selTel(int cpage,int pcount) {
		// TODO Auto-generated method stub
		return pagelistbysql("select ename as txl_ename,ephone as txl_ephone from emp",(cpage-1)*pcount, pcount);
	}
	
	//��ֵ���ܼ�¼
	public int countZhiban() {
		// TODO Auto-generated method stub
		System.out.println("��������");
		return list("from Zhiban").size();
	}
	//��ѧ�����
	public List yijianlistpage(int start, int pageCount){
		return pagelistbysql("select s.*,t.intenname from sback s inner join student t on t.intenid=s.stdid where s.statu in(0,1) order by sbackid desc",start,pageCount);
	}
	
	
//������Ա��
	public List selAllEmp() {
		// TODO Auto-generated method stub
		return listbysql("select * from emp");
	}
	
	//�鹤�ʻ�����Ϣ
	public List selSalaryInfo(String eid) {
		System.out.println("������");
		// TODO Auto-generated method stub
		String sql="select e.eid as salary_eid,d.dname as salary_dname,e.ename as salary_ename,e.jwork as salary_jwork,dx.money as salary_money from emp e,dept d,dixin dx where e.did=d.did and e.eid=dx.empid";
		if(eid!=null){
			sql+=" and e.eid="+eid;
		}
		return listbysql(sql);
	}
	
	//�����ʱ����������
	public boolean addSalaryEachEmp(Salary s){
		return addObj(s);
	}
	//���Ź����б�
	public List selSalaryJiesuan(int y,int m) {
		// TODO Auto-generated method stub
		return listbysql("select * from salary where year='"+y+"' and month='"+m+"' ");
	}
	//�Ĺ��ʷ���״̬
	public boolean updFafangStatus(int eid,int y ,int m) {
		// TODO Auto-generated method stub
		return executesql("update salary set status='�ѷ���' where empid='"+eid+"' and year='"+y+"' and month='"+m+"' ");
	}
	
	//�޸�ĳԱ���ĵ�н
	public boolean updEmpDixin(int eid, float money) {
		// TODO Auto-generated method stub
		return executesql("update dixin set money='"+money+"' where empid='"+eid+"' ");
	}
	
	
	//��֤�����Ƿ����
	public int isJiesuan(int y, int m) {
		// TODO Auto-generated method stub
		String sql="select * from salary where year='"+y+"' and month='"+m+"' ";
		return listbysql(sql).size();
	}
	
	
	//��ĳ�༶ѧ��
	public List selStuByClass(int classid) {
		// TODO Auto-generated method stub
		return listbysql("select * from student where classid="+classid);
	}
	
	//�鷢�Ź��ʵĽ��
	public List selFangfaJine(int eid, int y, int m) {
		// TODO Auto-generated method stub
		String sql="select total_salary from salary where empid='"+eid+"' and year='"+y+"' and month='"+m+"' ";
		return listbysql(sql);
	}
}
