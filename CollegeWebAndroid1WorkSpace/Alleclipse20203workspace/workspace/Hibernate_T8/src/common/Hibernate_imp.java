package common;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class Hibernate_imp {
	//总行数
	public int totalRow(String hql){
		Session session=null;
		Transaction tran=null;
		try{
			session=Hibernate_Util.getsession();
			tran=session.beginTransaction();
			Query query=session.createQuery(hql);
			Long longs=(Long)query.uniqueResult();//返回一个唯一值
			tran.commit();
			return Integer.parseInt(longs+"");
		}catch(Exception e){
			e.printStackTrace();
			if(tran!=null){
				tran.rollback();
			}
			return 1;
		}finally {
			if(session!=null){
				session.close();
			}
		}		
	}
	
	public List hibernatehql(String hql,int startrow,int pagecount){
		Session session=null;
		Transaction tran=null;
		try{
			session=Hibernate_Util.getsession();
			tran=session.beginTransaction();
			Query query=session.createQuery(hql);
			query.setFirstResult(startrow);
			query.setMaxResults(pagecount);
			List list=query.list();
			tran.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			if(tran!=null){
				tran.rollback();
			}
			return null;
		}finally {
			if(session!=null){
				session.close();
			}
		}
	}
	
	public List hibernatebysql(String sql,int startrow,int pagecount){
		Session session=null;
		Transaction tran=null;
		try{
			session=Hibernate_Util.getsession();
			tran=session.beginTransaction();
			SQLQuery query=session.createSQLQuery(sql);
			query.setFirstResult(startrow);
			query.setMaxResults(pagecount);
			List list=query.list();
			tran.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			if(tran!=null){
				tran.rollback();
			}
			return null;
		}finally {
			if(session!=null){
				session.close();
			}
		}
	}
	
	public List hibernatebysql1(String sql,int startrow,int pagecount){
		Session session=null;
		Transaction tran=null;
		try{
			session=Hibernate_Util.getsession();
			tran=session.beginTransaction();
			SQLQuery query=session.createSQLQuery(sql);
			query.setFirstResult(startrow);
			query.setMaxResults(pagecount);
			query.setResultTransformer(Criteria.ALIAS_TO_ENTITY_MAP);
			List list=query.list();
			tran.commit();
			return list;
		}catch(Exception e){
			e.printStackTrace();
			if(tran!=null){
				tran.rollback();
			}
			return null;
		}finally {
			if(session!=null){
				session.close();
			}
		}
	}
	//执行sql的方法（三合一，增删改）executeUpdate
	public static void sql(String sql){
		Session session=null;
		Transaction tran=null;
		try{
			session=Hibernate_Util.getsession();
			tran=session.beginTransaction();
			SQLQuery query=session.createSQLQuery(sql);
			int i=query.executeUpdate();
			System.out.println(i);
			tran.commit();
		}catch(Exception e){
			if(tran!=null){
				tran.rollback();
			}
			
		}finally {
			if(session!=null){
				session.close();
			}
		}
		
	}
	public static void main(String[] args) {
		Hibernate_imp hh=new Hibernate_imp();
		hh.sql("insert into employee values(sequence_emp.nextval,231,'话话','男')");
	}
}
