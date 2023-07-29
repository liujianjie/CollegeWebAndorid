package com.aaa.dao;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.aaa.entity.Comment;
import com.aaa.util.PageEntity;
import com.aaa.util.PageUtil;

@Repository
public class CommentDaoimpl implements CommentDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Autowired
	// ��ҳ��ѯ
	private PageUtil pageUtil;

	public PageEntity getAllComment(PageEntity page) {
		String hql = "select new Map(c.commentId as commentId,c.evaluate as evaluate,u.userName as userName,o.outOuderNum as outOuderNum,o.outCreateDate as outCreateDate,c.replay as replay) from Comment c join c.user u join c.outOrder o";
		PageEntity pageEntity = pageUtil.getDataByPage(hql, page);
		return pageEntity;
	}

	public void update(Comment ct) {
		// TODO Auto-generated method stub
//		hibernateTemplate.update(ct);
		Session session = null;
        Transaction tr = null;
		try{
			SessionFactory sf = hibernateTemplate.getSessionFactory();
			session = sf.openSession();
            String sql = "update comment set replay= ?  where comment_id = ?";
            System.out.println(sql);
            tr = session.beginTransaction();
            SQLQuery query= session.createSQLQuery(sql);
            query.setString(0, ct.getReplay());
            query.setInteger(1, ct.getCommentId());
			query.executeUpdate();
            tr.commit(); 
            session.close();
		}catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	public void del(Comment ct) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(ct);
	}

	public void add(Comment ct) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(ct);
	}

	public List getct() {
		String hql = "select new Map(c.commentId as commentId,c.evaluate as evaluate,c.replay as replay) from Comment c";
		List list = hibernateTemplate.find(hql);
		return list;
	}
	public void delById(Integer id) {
		Session session = null;
        Transaction tr = null;
		try{
			SessionFactory sf = hibernateTemplate.getSessionFactory();
			session = sf.openSession();
            String sql = "delete from comment where comment_id = "+id;
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
