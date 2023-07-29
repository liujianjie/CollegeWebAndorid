package com.aaa.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.aaa.entity.Department;
import com.aaa.entity.Dept;

public class TestConnetion {
	  public static void main(String[] args) throws SQLException {
	        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	        HibernateTemplate  hibernateTemplate = (HibernateTemplate) context.getBean("hibernateTemplate");
	        
	        Session session = null;
	        Transaction tr = null;
			try{
				SessionFactory sf = hibernateTemplate.getSessionFactory();
				session = sf.openSession();
				String sql = "update dept set dept_name = ? , department_id = ? where dept_id = ?";
	            
	            tr = session.beginTransaction();
	            SQLQuery query= session.createSQLQuery(sql);
	            query.setString(0, "12346");
	            query.setInteger(1, 2);
	            query.setInteger(2, 1);
	            System.out.println(sql);
				query.executeUpdate();
	            tr.commit(); 
	            session.close();
			}catch (Exception e1) {
				e1.printStackTrace();
			}
	        
//	        String hql = "from Department";
			//String sql = "select * from Department";
//			List<Department> list = new ArrayList<Department>();
//			try{
//				list = hibernateTemplate.find(hql);
//				System.out.println(list.size());
//			}catch (Exception e1) {
//				e1.printStackTrace();
//			}
//	        String hql = "from Department where department_id = 1 ";
//			//String sql = "select * from Department";
//			try{
//				Department de = null;
//				List<Department> list = hibernateTemplate.find(hql);
//				if(list.size() > 0){
//					de = list.get(0);
//					System.out.println(de.getDepartmentName());
//				}
//			}catch(Exception e){
//				e.printStackTrace();
//			}
	        
//	        String sql = "from Department";
//			// Object [] obj={user.getUserName(),user.getUserPwd()};
//			System.out.println(sql);
//			try{
//				List list = hibernateTemplate.find(sql);
//				System.out.println(list.toString());
//			}catch (Exception e1) {
//				e1.printStackTrace();
//			}
			
//			Session session = null;
//	        Transaction tr = null;
//			//String sql = "select * from Department";
//			try{
//				session = hibernateTemplate.getSessionFactory().openSession();
//	            String sql = "insert into staff(staff_user_name,staff_user_pwd,staff_dept_id) values(1,1,1)";
//	            System.out.println(sql);
//	            tr = session.beginTransaction();
//	            //Statement state1 = session.connection().createStatement();
//	            SQLQuery query= session.createSQLQuery(sql);
//				int i=query.executeUpdate();
//	            System.out.println(i);
//	            tr.commit();
//	            session.close();
//			}catch (Exception e1) {
//				e1.printStackTrace();
//			}
	    }
}
