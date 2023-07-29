package com.ht.service.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.ht.common.Hibernate_Util;
import com.ht.vo.DepartmentVo;
import com.ht.vo.EmployeeVo;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;

public class Hibernate_T5 {
	// 对象的状态
	public static DepartmentVo state() {
		Session session = Hibernate_Util.getSession();
		Transaction tran = session.beginTransaction();
		DepartmentVo dept = (DepartmentVo) session.get(DepartmentVo.class, 152);
		// 此时的对象是持久状态 在session关闭之前可以对对象进行修改（不需要执行update方法）
		tran.commit();
		session.close();
		return dept;
	}

	public static List list() {
		Session session = Hibernate_Util.getSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from DepartmentVo");
		List list = query.list();
		
		tran.commit();
		session.close();
		return  list;

	}

	// 关系转由对方维护
	public static void inverse(DepartmentVo dept) {
		Session session = Hibernate_Util.getSession();
		Transaction tran = session.beginTransaction();
		session.save(dept);
		tran.commit();
		session.close();
	}

	// hql查询
	public static void hql() {
		Session session = Hibernate_Util.getSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from DepartmentVo d where d.did=?");
		query.setInteger(0, 152);// 在hibernate 占位符是从0开始设置的
		DepartmentVo dept = (DepartmentVo) query.uniqueResult();// 返回唯一值
		System.out.println(dept.getDname());
		tran.commit();
		session.close();
	}

	public static void hql2() {
		Session session = Hibernate_Util.getSession();
		Transaction tran = session.beginTransaction();
		Query query = session
				.createQuery("from DepartmentVo d where d.did=:did");// 使用字符串作为占位符
		query.setInteger("did", 152);
		DepartmentVo dept = (DepartmentVo) query.uniqueResult();// 返回唯一值
		System.out.println(dept.getDname());
		tran.commit();
		session.close();
	}

	public static void hql3() {
		Session session = Hibernate_Util.getSession();
		Transaction tran = session.beginTransaction();
		Query query = session
				.createQuery("select d.did,d.dname  from DepartmentVo d");
		List list = query.list();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			System.out.println(obj[0] + " " + obj[1]);

		}
		tran.commit();
		session.close();

	}

	// 采用构造函数的方式来筛选字段 （需要定义对应的构造函数）
	public static void hql4() {
		Session session = Hibernate_Util.getSession();
		Transaction tran = session.beginTransaction();
		Query query = session
				.createQuery("select new DepartmentVo( d.did,d.dname)  from DepartmentVo d");
		List list = query.list();
		for (int i = 0; i < list.size(); i++) {
			DepartmentVo dept = (DepartmentVo) list.get(i);
			System.out.println(dept.getDid() + "" + dept.getDname());
		}
	}

	// 函数 avg平均值 count 数量 sum 和 max min 最值 upper 小写转大写 distinct 去除重复数据
	public static void hql5() {
		Session session = Hibernate_Util.getSession();
		Transaction tran = session.beginTransaction();
		Query query = session
				.createQuery("select distinct d.dname  from DepartmentVo d");
		List list = query.list();
		for (int i = 0; i < list.size(); i++) {
			Object obj = (Object) list.get(i);
			System.out.println(obj);
		}
	}

	public static void hql6() {
		Session session = Hibernate_Util.getSession();
		Transaction tran = session.beginTransaction();
		Query query = session
				.createQuery("select dd.did,dd.dname from DepartmentVo dd where dd.did>(select avg(d.did) from DepartmentVo d)");
		List list = query.list();
		for (int i = 0; i < list.size(); i++) {
			Object[] obj = (Object[]) list.get(i);
			System.out.println(obj[0] + " " + obj[1]);
		}
	}

	// QBC查询
	public static void qbc() {
		Session session = Hibernate_Util.getSession();
		Transaction tran = session.beginTransaction();
		//更符合面向对象得到一种查询方法
		Criteria c = session.createCriteria(DepartmentVo.class);
		c.add(Restrictions.like("dname","%技术%"));
		c.add(Restrictions.between("did", 150, 190));
		
		List list = c.list();
		for (int i = 0; i < list.size(); i++) {
			DepartmentVo dept = (DepartmentVo) list.get(i);
			System.out.println(dept.getDid() + "" + dept.getDname());
		}
		tran.commit();
		session.close();
	}

	public static void main(String[] args) {
		// 状态测试
		// DepartmentVo dept= Hibernate_T5.state();
		// dept.setDname("研发部1");

		// 加载策略
		// 1、lazy="false" 立即加载
		// 2、lazy="true" 延迟加载
		// 3、fetch="join" 预先抓取 （效率比 立即加载高）
		// 3select * from department d inner join employee e on d.did=e.deptid

		// 1、select * from department
		// for(int i=0;i<depts.size();i++){
		// dept dept=depts.get(i);
		// select * from employee where deptid=dept.did;
		// }
		 List list = Hibernate_T5.list();
		 for (int i = 0; i < list.size(); i++) {
			 DepartmentVo dept=(DepartmentVo)list.get(i);
			 System.out.println(dept.getDname()+"  下的员工有");
			 Set emps= dept.getEmployees();
			 Iterator it= emps.iterator();
			 while(it.hasNext()){
			 EmployeeVo emp=(EmployeeVo) it.next();
			 System.out.println(emp.getEname());
			 }
			 }
		DepartmentVo dept = new DepartmentVo();
		dept.setDname("技术部");

		EmployeeVo emp1 = new EmployeeVo();
		emp1.setEname("王武");
		emp1.setSex("男");

		EmployeeVo emp2 = new EmployeeVo();
		emp2.setEname("小六");
		emp2.setSex("女");

		// 部门关联员工
		dept.getEmployees().add(emp1);
		dept.getEmployees().add(emp2);

		emp1.setDepartmentVo(dept);
		emp2.setDepartmentVo(dept);

		// Hibernate_T5.inverse(dept);
		// inverse ="true " 关系由父对象维护（不会出现修改语句）
		// inverse="false "表示关系由自己维护 会出现修改

		// insert="false" update="false"
		// 当我需要对关联列进行添加数据时，添加这两个属性

		// Hibernate_T5.hql();

		// Hibernate_T5.hql2();
		// Hibernate_T5.hql3();

		// Hibernate_T5.hql4();
		// Hibernate_T5.hql5();

//		Hibernate_T5.hql6();
		
//		Hibernate_T5.qbc();
	}
}
