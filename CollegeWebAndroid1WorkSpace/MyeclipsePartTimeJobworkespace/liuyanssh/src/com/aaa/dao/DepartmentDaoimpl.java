package com.aaa.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Comment;
import com.aaa.entity.Department;
import com.aaa.util.PageEntity;
import com.aaa.util.PageUtil;

@Repository
public class DepartmentDaoimpl implements DepartmentDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
	// ��ҳ��ѯ
	private PageUtil pageUtil;
	public List getDepartmentList(){
		String hql = "from Department";
		//String sql = "select * from Department";
		List<Department> list = new ArrayList<Department>();
		try{
			list = hibernateTemplate.find(hql);
			System.out.println(list.size());
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		return list;
	}

	public void update(Department ct) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(ct);
	}

	public void del(Department ct) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(ct);
	}

	public void addBysql(Department ct) {
		Session session = null;
        Transaction tr = null;
		try{
			SessionFactory sf = hibernateTemplate.getSessionFactory();
			session = sf.openSession();
			String sql = "insert into department(department_name) values(?)";
            System.out.println(sql);
            tr = session.beginTransaction();
            SQLQuery query= session.createSQLQuery(sql);
            query.setString(0, ct.getDepartmentName());
			query.executeUpdate();
            tr.commit(); 
            session.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

	public PageEntity getAllDepartment(PageEntity page) {
		String hql = "select new Map(de.departmentId as departmentId,de.departmentName as departmentName) from Department de ";
		PageEntity pageEntity = pageUtil.getDataByPage(hql, page);
		return pageEntity;
	}

	public Department getDepartmentOne(Integer Id) {
		// ע��������
		String hql = "from Department where department_id = "+Id;
		//String sql = "select * from Department";
		try{
			System.out.println(Id);
			Department de = null;
			List<Department> list = hibernateTemplate.find(hql);
			if(list.size() > 0){
				de = list.get(0);
				System.out.println(de.getDepartmentName());
			}
			return de;
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}	
	
	public void delDepart(Integer Id){
		Session session = null;
        Transaction tr = null;
		try{
			SessionFactory sf = hibernateTemplate.getSessionFactory();
			session = sf.openSession();
            String sql = "delete from department where department_id="+Id;
            
            tr = session.beginTransaction();
            SQLQuery query= session.createSQLQuery(sql);
            System.out.println(sql);
			query.executeUpdate();
            tr.commit(); 
            session.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void updateBySql(Department ct) {
		Session session = null;
        Transaction tr = null;
		try{
			SessionFactory sf = hibernateTemplate.getSessionFactory();
			session = sf.openSession();
            String sql = "update department set department_name  = ? where department_id = ?";
            tr = session.beginTransaction();
            SQLQuery query= session.createSQLQuery(sql);
            query.setString(0, ct.getDepartmentName());
            query.setInteger(1, ct.getDepartmentId());
            System.out.println(sql);
			query.executeUpdate();
            tr.commit(); 
            session.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}
	
	public List getDepLevtListBydept(Integer Id) {
		String hql = "from LevelDept where dept_id = "+Id;
		//String sql = "select * from Department";
		try{
			System.out.println(Id);
			List list = hibernateTemplate.find(hql);
			System.out.println(list.size());
			return list;
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
