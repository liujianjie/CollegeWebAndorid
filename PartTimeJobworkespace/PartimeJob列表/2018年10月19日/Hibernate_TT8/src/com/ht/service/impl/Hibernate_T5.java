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
	// �����״̬
	public static DepartmentVo state() {
		Session session = Hibernate_Util.getSession();
		Transaction tran = session.beginTransaction();
		DepartmentVo dept = (DepartmentVo) session.get(DepartmentVo.class, 152);
		// ��ʱ�Ķ����ǳ־�״̬ ��session�ر�֮ǰ���ԶԶ�������޸ģ�����Ҫִ��update������
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

	// ��ϵת�ɶԷ�ά��
	public static void inverse(DepartmentVo dept) {
		Session session = Hibernate_Util.getSession();
		Transaction tran = session.beginTransaction();
		session.save(dept);
		tran.commit();
		session.close();
	}

	// hql��ѯ
	public static void hql() {
		Session session = Hibernate_Util.getSession();
		Transaction tran = session.beginTransaction();
		Query query = session.createQuery("from DepartmentVo d where d.did=?");
		query.setInteger(0, 152);// ��hibernate ռλ���Ǵ�0��ʼ���õ�
		DepartmentVo dept = (DepartmentVo) query.uniqueResult();// ����Ψһֵ
		System.out.println(dept.getDname());
		tran.commit();
		session.close();
	}

	public static void hql2() {
		Session session = Hibernate_Util.getSession();
		Transaction tran = session.beginTransaction();
		Query query = session
				.createQuery("from DepartmentVo d where d.did=:did");// ʹ���ַ�����Ϊռλ��
		query.setInteger("did", 152);
		DepartmentVo dept = (DepartmentVo) query.uniqueResult();// ����Ψһֵ
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

	// ���ù��캯���ķ�ʽ��ɸѡ�ֶ� ����Ҫ�����Ӧ�Ĺ��캯����
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

	// ���� avgƽ��ֵ count ���� sum �� max min ��ֵ upper Сдת��д distinct ȥ���ظ�����
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

	// QBC��ѯ
	public static void qbc() {
		Session session = Hibernate_Util.getSession();
		Transaction tran = session.beginTransaction();
		//�������������õ�һ�ֲ�ѯ����
		Criteria c = session.createCriteria(DepartmentVo.class);
		c.add(Restrictions.like("dname","%����%"));
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
		// ״̬����
		// DepartmentVo dept= Hibernate_T5.state();
		// dept.setDname("�з���1");

		// ���ز���
		// 1��lazy="false" ��������
		// 2��lazy="true" �ӳټ���
		// 3��fetch="join" Ԥ��ץȡ ��Ч�ʱ� �������ظߣ�
		// 3select * from department d inner join employee e on d.did=e.deptid

		// 1��select * from department
		// for(int i=0;i<depts.size();i++){
		// dept dept=depts.get(i);
		// select * from employee where deptid=dept.did;
		// }
		 List list = Hibernate_T5.list();
		 for (int i = 0; i < list.size(); i++) {
			 DepartmentVo dept=(DepartmentVo)list.get(i);
			 System.out.println(dept.getDname()+"  �µ�Ա����");
			 Set emps= dept.getEmployees();
			 Iterator it= emps.iterator();
			 while(it.hasNext()){
			 EmployeeVo emp=(EmployeeVo) it.next();
			 System.out.println(emp.getEname());
			 }
			 }
		DepartmentVo dept = new DepartmentVo();
		dept.setDname("������");

		EmployeeVo emp1 = new EmployeeVo();
		emp1.setEname("����");
		emp1.setSex("��");

		EmployeeVo emp2 = new EmployeeVo();
		emp2.setEname("С��");
		emp2.setSex("Ů");

		// ���Ź���Ա��
		dept.getEmployees().add(emp1);
		dept.getEmployees().add(emp2);

		emp1.setDepartmentVo(dept);
		emp2.setDepartmentVo(dept);

		// Hibernate_T5.inverse(dept);
		// inverse ="true " ��ϵ�ɸ�����ά������������޸���䣩
		// inverse="false "��ʾ��ϵ���Լ�ά�� ������޸�

		// insert="false" update="false"
		// ������Ҫ�Թ����н����������ʱ���������������

		// Hibernate_T5.hql();

		// Hibernate_T5.hql2();
		// Hibernate_T5.hql3();

		// Hibernate_T5.hql4();
		// Hibernate_T5.hql5();

//		Hibernate_T5.hql6();
		
//		Hibernate_T5.qbc();
	}
}
