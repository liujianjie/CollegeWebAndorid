package com.aaa.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Staff;

@Repository
public class StaffDaoimpl implements StaffDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	public int add(Staff st){
		int i = 0;
		Session session = null;
        Transaction tr = null;
		try{
			SessionFactory sf = hibernateTemplate.getSessionFactory();
			session = sf.openSession();
			String sql = "insert into staff(staff_user_name,staff_user_pwd) values(?,?)";
//            String sql = "insert into staff(staff_user_name,staff_user_pwd,staff_dept_id) values("+st.getStaffUserName()+","+st.getStaffUserPwd()+","+st.getStaDeptId()+")";
			
            System.out.println(sql);
            tr = session.beginTransaction();
            SQLQuery query= session.createSQLQuery(sql);
            query.setString(0, st.getStaffUserName());
            query.setString(1, st.getStaffUserPwd());
			i = query.executeUpdate();
            tr.commit(); 
            session.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
		return i;
	}
	//��¼��ѯƥ�� 
	public Staff selOneByNameAndPsd(String username,String psd){
		Staff sta = new Staff();
//		String hql = "from Staff where staff_user_name=? and staff_user_pwd = ? order by staff_id";
		try{
//			List stalist = hibernateTemplate.find(hql,new String[]{username,psd});
			sta.setStaffUserName(username);
			sta.setStaffUserPwd(psd);
			List stalist = hibernateTemplate.findByExample(sta);
			System.out.println("stalist"+stalist.size());
			if(stalist.size() > 0){
				sta = new Staff();
				sta = (Staff) stalist.get(0);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		
//		String sql = "select * from Staff where staff_user_name=? and staff_user_pwd = ? limit 1";
//		Transaction tran = null;
//		Session session = null;
//		try {
//			session = hibernateTemplate.getSessionFactory().openSession();
//			tran = session.beginTransaction();
//			SQLQuery query= session.createSQLQuery(sql);
//			query.setString(0, username);
//			query.setString(1, username);
//			List<Staff> li= query.list();
//			System.out.println(li.size());
//			
//			if(li.size() > 0){
//				sta = new Staff();
//				sta = li.get(0);
//			}
//			tran.commit();
//			session.close();
//		}catch (Exception e1) {
//			e1.printStackTrace();
//		} 
		return sta;
	}
	
}
