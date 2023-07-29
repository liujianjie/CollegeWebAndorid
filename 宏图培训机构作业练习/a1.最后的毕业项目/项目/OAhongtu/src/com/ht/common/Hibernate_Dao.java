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
	// ���
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
	
	//�޸�
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
	
	//ɾ��
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
	
	//��ȡ
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
	
	//hql��ѯ�б�
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
	
	
	
	//��ѯ������   select count(*) from DepartmentVo
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
	
	//hql��ҳ
	public List pagelistByhql(String hql,int startRow,int PageCount) {
		Transaction tran = null;
		Session session = null;
		try {
			session = Hibernate_Util.getSession();
			tran = session.beginTransaction();
			Query query= session.createQuery(hql);
			query.setFirstResult(startRow); // ��ʼ��
			query.setMaxResults(PageCount);//   ÿҳ���� 
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
	
	//sql��ѯ����(����ҳ)
	public List listbysql(String sql) {
		Transaction tran = null;
		Session session = null;
		try {
			session = Hibernate_Util.getSession();
			tran = session.beginTransaction();
			SQLQuery query= session.createSQLQuery(sql);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);// ����ѯ���ת����map����
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
	
	//��hibernateִ��sql ��ҳ
	
	//select e.ename,e.sex,d.dname from employee e left join department d on e.deptid=d.did;
	public List pagelistbysql(String sql,int startRow,int PageCount) {
		Transaction tran = null;
		Session session = null;
		try {
			session = Hibernate_Util.getSession();
			tran = session.beginTransaction();
			SQLQuery query= session.createSQLQuery(sql);
			query.setFirstResult(startRow); // ��ʼ��
			query.setMaxResults(PageCount);//   ÿҳ���� 
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);//�����ת���� Map����
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
	
	
	//ִ��sql�ķ��� (����һ ��ɾ��)
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
		String sql="insert into employee values(seq_orcl.NEXTVAL,10,'sql','��')";
		dao.executesql(sql);
	}
}
