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
//收入
	public List shouru_list(){
		String sql="select * from shouru";
		return listbysql(sql);
	}
	//按时间查找
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
	//按项目查找
	public List shouru_list2(String f3) {
		
		String sql="select * from shouru where 1=1";

		if(f3!=null&&!f3.equals("")){
			sql+="and shoufei_xiangmu="+f3;
		}

		return listbysql(sql);

	}
	//查总收入
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
	
	

	
//支出
	///查支出列表
	public List zhichu_list(){	//不筛选
		String sql="select * from zhichu";
		return listbysql(sql);
	}
	
	public List zhichu_list1(String f1,String f2){	//按时间查
		System.out.println("进来了");
		String sql="select * from zhichu where 1=1";
		if(f1!=null&&!f1.equals("")){
			sql+="and z_year="+f1;
		}
		if(f2!=null&&!f2.equals("")){
			sql+="and z_month="+f2;
		}

		
		return listbysql(sql);
	}
	public List zhichu_list2(String f3){//按项目查
		String sql="select * from zhichu where 1=1";

		if(f3!=null&&!f3.equals("")){
			sql+="and zhichu_xiangmu="+f3;
		}

		return listbysql(sql);
	}
	//查总支出
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

//学费
	public List IsContainStu(String id1, String id2) {	//验证
		// TODO Auto-generated method stub
		System.out.println("实现类");
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
		return executesql("update jiaoqing_zhuangtai set status='已缴清' where stuid='"+id1+"' and xueqi_id='"+id2+"' ");
	}

	//查缴清状态表
	public List jiaoqing_list(String id1,String id2) {
		// TODO Auto-generated method stub
		System.out.println("进了具体方法");
		String sql="select * from jiaoqing_zhuangtai where 1=1";
		if(id1!=null&&id2!=null){	//通过班级、学期查找
			sql+="and stuid in(select intenid from student t where classid='"+id1+"') and xueqi_id='"+id2+"' ";
		}
		
		return listbysql(sql);
	}
//查所有班级
	public List selAllClass() {
		// TODO Auto-generated method stub
		return listbysql("select * from classes");
	}
	
	//查询工资
	public List selSalaryList(String year, String month) {
		System.out.println("进来实现类方法");
		// TODO Auto-generated method stub
		String sql="select * from salary where 1=1  ";
		if(year!=null&&month!=null){
			sql+="and sa_year='"+year+"' and sa_month='"+month+"' ";
		}
		return listbysql(sql);
	}
	//查询员工信息
	public Emp getEmpById(Long id){
		return (Emp)getObj(Emp.class, id);
	}
	//根据职务查薪资
	public List selXinziByJob(String job){
		
		return listbysql("select xinzi from biaozhun where job='"+job+"' ");
	}
	
	
	
	//查所有员工
	public List selAllEmpName() {
		// TODO Auto-generated method stub
		return list("from Emp");
	}
	
	//局部刷新1
	public List selMoneyByYear(String year) {
		// TODO Auto-generated method stub
		return listbysql("select sum(shoufei_jine) as sum_year from shouru where s_year="+year);
	}
	//局部刷新2
	public List selMoneyByYearMonth(String year, String month) {
		// TODO Auto-generated method stub
		return listbysql("select sum(shoufei_jine) as sum_year from shouru where s_year='"+year+"' and s_month='"+month+"' ");
	}
	
	//局部刷新11
	public List selMoneyByYear2(String year) {
		// TODO Auto-generated method stub
		System.out.println("局部");
		return listbysql("select sum(zhichu_jine) as sum_year from zhichu where z_year="+year);
	}
	//局部刷新22
	public List selMoneyByYearMonth2(String year, String month) {
		// TODO Auto-generated method stub
		return listbysql("select sum(zhichu_jine) as sum_year from zhichu where z_year='"+year+"' and z_month='"+month+"' ");
	}
	
	//根据Id查学生姓名
	public List selStuName(Long id) {
		// TODO Auto-generated method stub
		return listbysql("select intenname from student where intenid="+id);
	}
	
	//根据id查班级
	public List selStuClass(Long id) {
		System.out.println("查班级实现类");
		// TODO Auto-generated method stub
		return listbysql("select classname from classes where classid=(select classid from student where intenid='"+id+"')");
	}
	
	
	//验证员工是否结算
	public List checkIsJiesuan(int empid, int year, int month) {
		// TODO Auto-generated method stub
		return listbysql("select * from salary where EMPID='"+empid+"' and SA_YEAR='"+year+"' and SA_MONTH='"+month+"' ");
	}
	
	
	//查值班
	public List selZhiban(int cpage,int pcount) {
		// TODO Auto-generated method stub
		return pagelistByhql("from Zhiban", (cpage-1)*pcount, pcount);
	}
	//查通知
	public List selTongzhi() {
		// TODO Auto-generated method stub
		return listbysql("select * from msg where msgstatus=1 and msgface=1");
	}
	//查通讯录
	public List selTel(int cpage,int pcount) {
		// TODO Auto-generated method stub
		return pagelistbysql("select ename as txl_ename,ephone as txl_ephone from emp",(cpage-1)*pcount, pcount);
	}
	
	//查值班总记录
	public int countZhiban() {
		// TODO Auto-generated method stub
		System.out.println("查总行数");
		return list("from Zhiban").size();
	}
	//查学生意见
	public List yijianlistpage(int start, int pageCount){
		return pagelistbysql("select s.*,t.intenname from sback s inner join student t on t.intenid=s.stdid where s.statu in(0,1) order by sbackid desc",start,pageCount);
	}
	
	
//查所有员工
	public List selAllEmp() {
		// TODO Auto-generated method stub
		return listbysql("select * from emp");
	}
	
	//查工资基本信息
	public List selSalaryInfo(String eid) {
		System.out.println("进来了");
		// TODO Auto-generated method stub
		String sql="select e.eid as salary_eid,d.dname as salary_dname,e.ename as salary_ename,e.jwork as salary_jwork,dx.money as salary_money from emp e,dept d,dixin dx where e.did=d.did and e.eid=dx.empid";
		if(eid!=null){
			sql+=" and e.eid="+eid;
		}
		return listbysql(sql);
	}
	
	//往工资表里插入数据
	public boolean addSalaryEachEmp(Salary s){
		return addObj(s);
	}
	//发放工资列表
	public List selSalaryJiesuan(int y,int m) {
		// TODO Auto-generated method stub
		return listbysql("select * from salary where year='"+y+"' and month='"+m+"' ");
	}
	//改工资发放状态
	public boolean updFafangStatus(int eid,int y ,int m) {
		// TODO Auto-generated method stub
		return executesql("update salary set status='已发放' where empid='"+eid+"' and year='"+y+"' and month='"+m+"' ");
	}
	
	//修改某员工的底薪
	public boolean updEmpDixin(int eid, float money) {
		// TODO Auto-generated method stub
		return executesql("update dixin set money='"+money+"' where empid='"+eid+"' ");
	}
	
	
	//验证本月是否结算
	public int isJiesuan(int y, int m) {
		// TODO Auto-generated method stub
		String sql="select * from salary where year='"+y+"' and month='"+m+"' ";
		return listbysql(sql).size();
	}
	
	
	//查某班级学生
	public List selStuByClass(int classid) {
		// TODO Auto-generated method stub
		return listbysql("select * from student where classid="+classid);
	}
	
	//查发放工资的金额
	public List selFangfaJine(int eid, int y, int m) {
		// TODO Auto-generated method stub
		String sql="select total_salary from salary where empid='"+eid+"' and year='"+y+"' and month='"+m+"' ";
		return listbysql(sql);
	}
}
