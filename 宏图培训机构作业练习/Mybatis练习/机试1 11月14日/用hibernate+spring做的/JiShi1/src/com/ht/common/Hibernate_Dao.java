package com.ht.common;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Hibernate_Dao {
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
	
	public List listbyhql(String hql) {
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
	
	//hql分页
	public List listpage(String hql,int startRow,int pagCount) {
		Transaction tran = null;
		Session session = null;
		try {
			session = Hibernate_Util.getSession();
			tran = session.beginTransaction();
			Query query= session.createQuery(hql);
			query.setFirstResult(startRow);//开始行
			query.setMaxResults(pagCount);//每页行数
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
	
	//查询总行数方法   select count(*) from DepartmentVo
	public int totalRow(String hql) {
		Transaction tran = null;
		Session session = null;
		try {
			session = Hibernate_Util.getSession();
			tran = session.beginTransaction();
			Query query= session.createQuery(hql);
			Long rows=(Long) query.uniqueResult();
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
	
	//sql分页
	//select e.ename,e.sex,d.dname from employee e left join department d on e.deptid=d.did 
	public List listpagebysql(String sql,int startRow,int pageCount) {
		Transaction tran = null;
		Session session = null;
		try {
			session = Hibernate_Util.getSession();
			tran = session.beginTransaction();
			SQLQuery query= session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);// 将查询结果转换成map集合
			query.setFirstResult(startRow);//开始行
			query.setMaxResults(pageCount);//每页行数
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
	
	//sql（三合一）增删改 delete from employee
	public boolean executeSql(String sql) {
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
//		Hibernate_Dao dao=new Hibernate_Dao();
//		String sql="delete from employee where eid=159";
//		String sql="insert into employee values(seq_orcl.NEXTVAL,10,'SQL添加','男')";
//		dao.executeSql(sql);
	}
}
