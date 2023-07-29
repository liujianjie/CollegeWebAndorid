package com.aaa.dao;

import java.util.List;

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
	   //∑÷“≥≤È—Ø
	   private PageUtil pageUtil;
	public PageEntity getAllComment(PageEntity page) {
		String hql="select new Map(c.commentId as commentId,c.evaluate as evaluate,u.userName as userName,o.outOuderNum as outOuderNum,o.outCreateDate as outCreateDate) from Comment c join c.user u join c.outOrder o";
		PageEntity pageEntity= pageUtil.getDataByPage(hql, page);
		return pageEntity;
		}
	

	public void update(Comment ct) {
		// TODO Auto-generated method stub
hibernateTemplate.update(ct);
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
		String hql="select new Map(c.commentId as commentId,c.evaluate as evaluate) from Comment c";
		List list=hibernateTemplate.find(hql);
		return list;
	}

}
