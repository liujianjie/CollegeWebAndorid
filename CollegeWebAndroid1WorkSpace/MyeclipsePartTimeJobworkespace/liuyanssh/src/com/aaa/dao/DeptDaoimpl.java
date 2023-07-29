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
import com.aaa.entity.Dept;
import com.aaa.util.PageEntity;
import com.aaa.util.PageUtil;

@Repository
public class DeptDaoimpl implements DeptDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
	private PageUtil pageUtil;
		
	public PageEntity getDeptList(PageEntity page){
		String hql = "select new Map(c.deptId as deptId,c.deptName as deptName,u.departmentId as departmentId,u.departmentName as departmentName,u.departmentId as departmentId) from Dept c join c.department u";
		System.out.println(hql);
		//String hql = "select new Map(c.commentId as commentId,c.evaluate as evaluate,u.userName as userName,o.outOuderNum as outOuderNum,o.outCreateDate as outCreateDate,c.replay as replay) from Dept c join c.user u join c.outOrder o";
		PageEntity pageEntity = null;
		try{
			pageEntity = pageUtil.getDataByPage(hql, page);
		}catch(Exception e){
			e.printStackTrace();
		}
		return pageEntity;
	}

	public List getct() {
		String hql = "select new Map(c.deptId as deptId,c.deptName as deptName) from Dept c";
		List list = hibernateTemplate.find(hql);
		return list;
	}

	public void update(Dept ct) {
		hibernateTemplate.update(ct);
	}

	public void del(Dept ct) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(ct);
	}

	public void add(Dept ct) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(ct);
	}
	public Dept getDeptOne(Integer id){
		String hql = "from Dept where dept_id = "+id;
//		String hql = "select new Map(c.deptId as deptId,c.deptName as deptName) from Dept c where dept_id = "+id;
		try{
			System.out.println(id);
			Dept de = null;
			List<Dept> list = hibernateTemplate.find(hql);
			System.out.println("list.size()="+list.size());
			if(list.size() > 0){
				de = list.get(0);
				System.out.println(de.getDeptName());
			}
			return de;
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
		
	}
	public void updateBySql(Dept ct){
		Session session = null;
        Transaction tr = null;
		try{
			SessionFactory sf = hibernateTemplate.getSessionFactory();
			session = sf.openSession();
            String sql = "update dept set dept_name = ? , department_id = ? where dept_id = ?";
            
            tr = session.beginTransaction();
            SQLQuery query= session.createSQLQuery(sql);
            query.setString(0, ct.getDeptName());
            query.setInteger(1, ct.getDepartmentId());
            query.setInteger(2, ct.getDeptId());
            System.out.println(sql);
			query.executeUpdate();
            tr.commit(); 
            session.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void addDept(Dept ct) {
		Session session = null;
        Transaction tr = null;
		try{
			SessionFactory sf = hibernateTemplate.getSessionFactory();
			session = sf.openSession();
            String sql = "insert into dept(dept_name,department_id)  values(?,?)";
            
            tr = session.beginTransaction();
            SQLQuery query= session.createSQLQuery(sql);
            query.setString(0, ct.getDeptName());
            query.setInteger(1, ct.getDepartmentId());
            System.out.println(sql);
			query.executeUpdate();
            tr.commit(); 
            session.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

	public void delDepByDepartId(Integer id) {
		Session session = null;
        Transaction tr = null;
		try{
			SessionFactory sf = hibernateTemplate.getSessionFactory();
			session = sf.openSession();
            String sql = "delete from dept where department_id="+id;
            
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
	
	public void setLevelAndDept(Integer leid,Integer deptid){
		Session session = null;
        Transaction tr = null;	
		try{
			SessionFactory sf = hibernateTemplate.getSessionFactory();
			session = sf.openSession();
            String sql = "insert into level_dept(dept_id,level_id) values(?,?)";
            tr = session.beginTransaction();
            SQLQuery query= session.createSQLQuery(sql);
            query.setInteger(0, deptid);
            query.setInteger(1,leid );
            System.out.println(sql);
			query.executeUpdate();
            tr.commit(); 
            session.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public List getLevelIdList(Integer deptid) {
		Session session = null;
        Transaction tr = null;	
		try{
			SessionFactory sf = hibernateTemplate.getSessionFactory();
			session = sf.openSession();
            String sql = "select level_id from level_dept where dept_id = "+deptid;
            tr = session.beginTransaction();
            SQLQuery query= session.createSQLQuery(sql);
			List list= query.list();
            System.out.println(sql);
            tr.commit(); 
            session.close();
            return list;
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}

	public List getDeptListBydeparid(Integer Id) {
		String hql = "from Dept where department_id = "+Id;
//		String hql = "select new Map(c.deptId as deptId,c.deptName as deptName) from Dept c where dept_id = "+id;
		try{
			List<Dept> list = hibernateTemplate.find(hql);
			System.out.println("list.size()="+list.size());
			return list;
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		return null;
	}
}
