package com.ht.service;

import java.util.List;
import java.util.Set;

import com.ht.vo.Emp;
import com.ht.vo4.JiaoqingZhuangtai;

import com.ht.vo4.Salary;
import com.ht.vo4.Shouru;
import com.ht.vo4.Xuefei;
import com.ht.vo4.Zhichu;

public interface ICaiwuService {
//收入
	//查询收入列表
	public List shouru_list();
	public List shouru_list1(String f1,String f2);
	public List shouru_list2(String f3);
	//查询总收入
	public List total_shouru();
	//添加一笔收入
	public boolean shouru_add(Shouru sh);
	//查询单笔收入
	public  Shouru selShouruById(int id);
	//修改单笔收入
	public boolean shouru_upd(Shouru sh);
	//删除一笔收入
	public boolean shouru_del(Shouru sh);
	
	
	
//支出	
	//查询支出列表
	public List zhichu_list();
	public List zhichu_list1(String f1,String f2);
	public List zhichu_list2(String f3);
	//查询支出总额
	public List total_zhichu();
	//添加一笔支出
	public boolean zhichu_add(Zhichu zh);
	//查询单笔支出
	public Zhichu selZhichuById(int id);
	//修改一笔支出
	public boolean zhichu_upd(Zhichu zh);
	//删除一笔支出
	public boolean zhichu_del(Zhichu zh);
	
//学费
	//查询学费列表
	public List xuefei_list();
	//查询所有班级
	public List selAllClass();
	//查询学费加条件
	
	
	//添加一笔学费记录
	public List IsContainStu(String id1,String id2);
	public boolean xuefei_add(Xuefei xu);//添加
	
  //是否要往缴清状态表 插入/更改数据 方法：
	public List selCount(Long stuid,Long xueqi_id);
	public List selXueqiJiaofei(Long id1,Long id2);
	public boolean jiaoqing_add(JiaoqingZhuangtai jiao);
	public boolean jiaoqingstatus_upd(Long id1,Long id2);
	public List jiaoqing_list(String id1,String id2);
	
	//工资
	public List selSalaryList(String year,String month);
	//查询员工信息
	public Emp getEmpById(Long id);
	//根据职务查薪资
	public List selXinziByJob(String job);

	//查所有员工姓名
	public List selAllEmpName();
	
//局部刷新1
	public List selMoneyByYear(String year);
//局部刷新2
	public List selMoneyByYearMonth(String year,String month);
	
//局部刷新11
	public List selMoneyByYear2(String year);
//局部刷新22
	public List selMoneyByYearMonth2(String year,String month);
	
	//根据Id查学生姓名
	public List selStuName(Long id);
	//根据id查班级姓名
	public List selStuClass(Long id);

	//验证员工是否结算
	public List checkIsJiesuan(int empid,int year,int month);
	
	
	//查询值班
	public List selZhiban(int cpage,int pcount);
	//查已发布通知
	public List selTongzhi();
	//查通讯录
	public List selTel(int cpage,int pcount);
	
	//查值班总记录
	public int countZhiban();
	//查学生意见
	public List yijianlistpage(int start, int pageCount);
	
//查所有员工
	public List selAllEmp();
//查工资基本信息	
	public List selSalaryInfo(String eid);
	//往工资表里插入数据
	public boolean addSalaryEachEmp(Salary s);
	//发放工资列表
	public List selSalaryJiesuan(int y,int m);
	//改工资发放状态
	public boolean updFafangStatus(int eid,int y,int m);
	
	//修改某员工的底薪
	public boolean updEmpDixin(int eid,float money);
	
	//验证本月是否结算
	public int isJiesuan(int y,int m);
	
	
	//查某班级学生
	public List selStuByClass(int classid);
	
	//查发放工资的金额
	public List selFangfaJine(int eid,int y,int m);
}
