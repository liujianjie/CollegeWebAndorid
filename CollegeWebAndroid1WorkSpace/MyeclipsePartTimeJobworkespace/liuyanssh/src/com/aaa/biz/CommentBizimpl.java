package com.aaa.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aaa.dao.CommentDao;
import com.aaa.entity.Comment;
import com.aaa.util.PageEntity;
@Service
public class CommentBizimpl implements CommentBiz {
	@Autowired
private CommentDao  commentDao;
	public PageEntity getAllComment(PageEntity page) {
		// TODO Auto-generated method stub
		return  commentDao.getAllComment(page);
	}

	public void update(Comment ct) {
		// TODO Auto-generated method stub
		commentDao.update(ct);
	}

	public void del(Comment ct) {
		// TODO Auto-generated method stub
		commentDao.del(ct);
	}

	public void add(Comment ct) {
		// TODO Auto-generated method stub
		commentDao.add(ct);
	}

	public List getct() {
		// TODO Auto-generated method stub
		return commentDao.getct();
	}

	public void delById(Integer id) {
		// TODO Auto-generated method stub
		commentDao.delById(id);
	}

}
