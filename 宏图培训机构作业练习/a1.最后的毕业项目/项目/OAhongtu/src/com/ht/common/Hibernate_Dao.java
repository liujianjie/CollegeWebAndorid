package com.ht.common;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.ht.vo5.Student;

public class Hibernate_Dao extends Contents{
	// 添加
	public boolean addObj(Object obj) {
		Transaction tran = null;
		Session session = null;
		try {
			session = Hibernate_Util.getSession();
			tran = session.beginTransaction();
			session.save(obj);
			tran.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tran != null) {
				tran.rollback();
			}
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	//修改
	public boolean updObj(Object obj) {
		Transaction tran = null;
		Session session = null;
		try {
			session = Hibernate_Util.getSession();
			tran = session.beginTransaction();
			session.update(obj);
			tran.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tran != null) {
				tran.rollback();
			}
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	//删除
	public boolean delObj(Object obj) {
		Transaction tran = null;
		Session session = null;
		try {
			session = Hibernate_Util.getSession();
			tran = session.beginTransaction();
			session.delete(obj);
			tran.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tran != null) {
				tran.rollback();
			}
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	//获取
	public Object getObj(Class clas,Serializable id) {
		Transaction tran = null;
		Session session = null;
		try {
			session = Hibernate_Util.getSession();
			tran = session.beginTransaction();
			Object obj= session.get(clas, id);
			tran.commit();
			return obj;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tran != null) {
				tran.rollback();
			}
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	//hql查询列表
	public List list(String hql) {
		Transaction tran = null;
		Session session = null;
		try {
			session = Hibernate_Util.getSession();
			tran = session.beginTransaction();
			Query query= session.createQuery(hql);
			List list= query.list();
			tran.commit();
			return list;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tran != null) {
				tran.rollback();
			}
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	
	
	//查询总行数   select count(*) from DepartmentVo
	public int totalRow(String hql) {
		Transaction tran = null;
		Session session = null;
		try {
			session = Hibernate_Util.getSession();
			tran = session.beginTransaction();
			Query query= session.createQuery(hql);
			Long rows= (Long)query.uniqueResult();
			tran.commit();
			return Integer.parseInt(rows+"");
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tran != null) {
				tran.rollback();
			}
			return 0;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	//hql分页
	public List pagelistByhql(String hql,int startRow,int PageCount) {
		Transaction tran = null;
		Session session = null;
		try {
			session = Hibernate_Util.getSession();
			tran = session.beginTransaction();
			Query query= session.createQuery(hql);
			query.setFirstResult(startRow); // 开始行
			query.setMaxResults(PageCount);//   每页行数 
			List list= query.list();
			tran.commit();
			return list;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tran != null) {
				tran.rollback();
			}
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	//sql查询所有(不分页)
	public List listbysql(String sql) {
		Transaction tran = null;
		Session session = null;
		try {
			session = Hibernate_Util.getSession();
			tran = session.beginTransaction();
			SQLQuery query= session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);// 将查询结果转换成map集合
			List list= query.list();
			tran.commit();
			return list;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tran != null) {
				tran.rollback();
			}
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	//用hibernate执行sql 分页
	
	//select e.ename,e.sex,d.dname from employee e left join department d on e.deptid=d.did;
	public List pagelistbysql(String sql,int startRow,int PageCount) {
		Transaction tran = null;
		Session session = null;
		try {
			session = Hibernate_Util.getSession();
			tran = session.beginTransaction();
			SQLQuery query= session.createSQLQuery(sql);
			query.setFirstResult(startRow); // 开始行
			query.setMaxResults(PageCount);//   每页行数 
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);//将结果转换成 Map集合
			List list= query.list();
			tran.commit();
			return list;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tran != null) {
				tran.rollback();
			}
			return null;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	
	//执行sql的方法 (三合一 增删改)
	public boolean executesql(String sql) {
		Transaction tran = null;
		Session session = null;
		try {
			session = Hibernate_Util.getSession();
			tran = session.beginTransaction();
			SQLQuery query= session.createSQLQuery(sql);
			int i=query.executeUpdate();
			tran.commit();
			return true;
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			if (tran != null) {
				tran.rollback();
			}
			return false;
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}
	
	public static void main(String[] args) {
		Hibernate_Dao dao=new Hibernate_Dao();
//		String sql="delete from employee where eid=158";
		String sql="insert into employee values(seq_orcl.NEXTVAL,10,'sql','男')";
		dao.executesql(sql);
	}
}
