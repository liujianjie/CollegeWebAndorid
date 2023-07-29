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
import com.aaa.entity.LevelDept;
import com.aaa.util.PageEntity;
import com.aaa.util.PageUtil;

@Repository
public class LeveldeptDaoimpl implements LeveldeptDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
	private PageUtil pageUtil;
	public void update(LevelDept ct) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(ct);
	}
	public void del(LevelDept ct) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(ct);
	}
	public void delByDeptId(Integer id){
		Session session = null;
        Transaction tr = null;
		try{
			SessionFactory sf = hibernateTemplate.getSessionFactory();
			session = sf.openSession();
            String sql = "delete from level_dept where dept_id = "+id;
            System.out.println(sql);
            tr = session.beginTransaction();
            SQLQuery query= session.createSQLQuery(sql);
			query.executeUpdate();
            tr.commit(); 
            session.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}
}
